package ClientOjek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;
import javax.swing.JFrame;
import java.util.Date;
import java.text.SimpleDateFormat;

import Model.*;
import Controller.*;
/**
 * Kelas WatchDog berfungsi sebagai monitor dan aktuator jalannya konektifitas client dengan server.
 * WatchDog berfungsi sebagai objek yang menjembatani antara lokal program dengan remote.
 * WatchDog menggunakan thread yang berbeda dengan main program sehingga dapat berjalan secara beriringan.
 */
public class WatchDog implements Runnable{
    ClientConnectionHandler conn;
    Object data;
    static volatile Pesanan pesanan;
    static volatile Ojek ojek;
    static volatile GPS gps;
    static volatile JFrame mainFrame;
    static volatile Boolean isLogout;
    
    private Thread t;
    private String threadName;
    private boolean programRun;
    private int waktuCek;
    private Socket sock;
    /**
     * Konstruktor dari kelas WatchDog
     * 
     * @param   String    namaThread untuk Objek WatchDog
     * @param   int       Waktu ketika akan melakukan pemberhentian semetara
     * 
     */
    public WatchDog(String name, int waktuCek, JFrame mainFrame)
    {
        // initialise instance variables
        this.mainFrame = mainFrame;
        gps = new GPS();
        conn = new ClientConnectionHandler();
        conn.connect();
        threadName = name;
        this.waktuCek = waktuCek;
        programRun = true;
        System.out.println("[System] Creating " + threadName);
    }

    public void run(){
        System.out.println("[System] Running " + threadName);
        while(programRun){
            try {
                Thread.sleep(waktuCek);
                Object data = conn.getData();
                if(data instanceof ConnectionCommand){
                    ConnectionCommand command = (ConnectionCommand)data;
                    if(command.equals(ConnectionCommand.PESAN)){
                        System.out.println("Yuhuuu ada pesan");
                        pesanan = (Pesanan)conn.getData();
                        if(true){
                            ojek.setPesanan(pesanan);
                            pesanan.setPelayan(ojek);
                        }
                        conn.sendCommand(ConnectionCommand.OJEK);
                        conn.sendCommand(ConnectionCommand.AMBIL);
                        conn.sendData(pesanan);
                    }else if(command.equals(ConnectionCommand.SELESAI)){
                        System.out.println("Kerjaan selesai, bisa makan hari ini");
                        pesanan = (Pesanan)conn.getData();
                    }else if(command.equals(ConnectionCommand.BATAL)){
                        System.out.println("Hilang sudah uang makan");
                        pesanan = (Pesanan)conn.getData();
                    }else if(command.equals(ConnectionCommand.LOGOUT)){
                        if((Boolean)conn.getData()){
                            System.out.println("Logout");
                            exit();
                        }
                    }else if(command.equals(ConnectionCommand.AMBIL)){
                        System.out.println("Ambil pesanan");
                        pesanan = (Pesanan)conn.getData();
                        ojek = pesanan.getPelayan();
                    }
                }
            } catch(InterruptedException e) {
                System.out.println("[System] Thread " + threadName + " interrupted");
                exit();
            } catch(Exception e){
                System.out.println(e.getMessage());
                exit();
            }
        }
        System.out.println("[Syetm] Thread " + threadName + " existing");
    }
    
    /**
     * Metode ini digunakan ketika kita ingin menjalankan thread dari WatchDog.
     * Metode ini akan membuat thread baru dari instance WatchDog.
     */
    public void start(){
        System.out.println("[System] Starting " + threadName);
        t = new Thread(this);
        t.start();
    }
    
    /**
     * Metode ini digunakan ketika pemanggil menunggu hingga WatchDog memasuka kondisi program selesai/mati.
     */
    public void join(){
        try {
            t.join();
        } catch(InterruptedException e){
            System.out.println("[Sytem] Thread " + threadName + " interrupted");
        }
    }
    
    /**
     * Metode ini digunakan ketika kita ingin menghentikan sementara thread WatchDog selama 500 ms.
     */
    public void sleep(){
        try {
            t.sleep(500);
        } catch(InterruptedException e){
            System.out.println("[System] Thread " + threadName + " interrupted");
        }
    }
    
    /**
     * Metode yang untuk menghentikan proses WatchDog, termasuk menutup konektifitas socket.
     */
    public void exit(){
        programRun = false;
        conn.disconnect();
    }
    
    /**
     * Metode untuk melakukan proses registrasi dengan mengirimkan data ke server melalui socket.
     * 
     * @param   uname       Username untuk autentikasi
     * @param   password    Password untuk autentikasi
     * 
     * @return              Bollean Kondisi keberhasilan registrasi
     */
    public Boolean register(String uname, String password, String nama, Date dob, String telefon, String email, String noPlat){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); // Set your date format
        String dateString = dateFormat.format(dob); // Get Date String according to date format
        conn.sendCommand(ConnectionCommand.OJEK);
        conn.sendCommand(ConnectionCommand.REGISTER);
        conn.sendData(uname);
        conn.sendData(password);
        conn.sendData(nama);
        conn.sendData(dateString);
        conn.sendData(telefon);
        conn.sendData(email);
        conn.sendData(noPlat);
        data = conn.getData();
        if(data instanceof Boolean){
            if((Boolean)data)
                return true;
             else
                return false;
        } else
            return false;
    }
    
    /**
     * Metode untuk melakukan proses login dengan mengirimkan data ke server melalui socket.
     * 
     * @param   uname       Username untuk autentikasi
     * @param   password    Password untuk autentikasi
     * 
     * @return              Objek ojek berdasarkan database server
     */
    public Ojek login(String uname, String password){
        conn.sendCommand(ConnectionCommand.OJEK);
        conn.sendCommand(ConnectionCommand.LOGIN);
        conn.sendData(uname);
        conn.sendData(password);
        data = conn.getData();
        if(data instanceof Ojek){
            if(data != null){
                this.ojek = (Ojek)data;
                this.ojek.setPosisi(gps.getData());
                conn.sendData(this.ojek);
                System.out.println(ojek.getNama() + " berhasil login");
            }
        }  
        return this.ojek;
    }
    
    /**
     * Metode untuk melakukan proses logout dengan mengirimkan data ke server melalui socket.
     * 
     * @param   ojek        Objek referensi untuk melakukan logout
     * 
     * @return              Kondisi apakah proses berhasil atau tidak
     */
    public Boolean logout(Ojek ojek){
        conn.sendCommand(ConnectionCommand.OJEK);
        conn.sendCommand(ConnectionCommand.LOGOUT);
        conn.sendData(ojek);
        return true;
    }
    
//     public synchronized ConnectionCommand pesananAmbil(ConnectionCommand command){
//         while(true){
//             if(command.equals(ConnectionCommand.AMBIL))
//                 return command;
//             else if(command.equals(ConnectionCommand.TOLAK))
//                 return command;
//         }
//     }
    /**
     * Metode untuk melakukan proses pembatanan pesanan 
     */    
    public synchronized void pesananBatal(){
        conn.sendCommand(ConnectionCommand.OJEK);
        conn.sendCommand(ConnectionCommand.BATAL);
        conn.sendData(ojek);
    }
    
    /**
     * Metode untuk mendapatkan objek ojek.
     * Metode ini digunakan untuk saling berbagi objek ojek.
     * 
     * @return              Objek ojek
     * @see                 Model.Ojek         
     */
    public synchronized Ojek getOjek(){
        return ojek;
    }
    
    /**
     * Metode untuk mendapatkan objek pesanan.
     * Metode ini digunakan untuk saling berbagi objek pesanan.
     * 
     * @return              Objek pesanan
     * @see                 Model.Pesanan
     */
    public synchronized Pesanan getPesanan(){
        return pesanan;
    }
    
    /**
     * Metode untuk mengubah objek ojek berdasarkan parameter.
     * Metode ini digunakan untuk saling berbagi objek ojek.
     * 
     * @param   Ojek        Objek ojek baru
     * @see                 Model.Ojek         
     */
    public synchronized void setOjek(Ojek ojek){
        this.ojek = ojek;
    }
    
    /**
     * Metode untuk mengubah objek pesanan berdasarkan parameter.
     * Metode ini digunakan untuk saling berbagi objek pesanan.
     * 
     * @param     Pesanan   Objek pesanan baru
     * @see                 Model.Pesanan         
     */
    public synchronized void setPesanan(Pesanan pesanan){
        this.pesanan = pesanan;
    }
}