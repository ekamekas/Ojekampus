package ClientPelanggan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;
import javax.swing.JOptionPane;
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
    static volatile Pelanggan pelanggan;
    static volatile GPS gps;
    
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
    public WatchDog(String name, int waktuCek)
    {
        // initialise instance variables
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
                        pesanan = (Pesanan)conn.getData();
                        JOptionPane.showMessageDialog(null, "Pemesanan berhasil", "", JOptionPane.INFORMATION_MESSAGE);
                    }else if(command.equals(ConnectionCommand.BATAL)){
                        System.out.println("[!] Ojeknya sudah kaya");
                        pesanan = (Pesanan)conn.getData();
                    }else if(command.equals(ConnectionCommand.SELESAI)){
                        pesanan = (Pesanan)conn.getData();
                    }else if(command.equals(ConnectionCommand.LOGOUT)){
                        if((Boolean)conn.getData()){
                            System.out.println("Logout");
                        }
                        conn.sendData(null);
                    }else if(command.equals(ConnectionCommand.UNKNOWN)){
                        JOptionPane.showMessageDialog(null, "Error.", "alert", JOptionPane.ERROR_MESSAGE);
                        System.out.println("[!] Error.");
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
        System.out.println("[System] Thread " + threadName + " existing");
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
            System.out.println("{System] Thread " + threadName + " interrupted");
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
    public Boolean register(String uname, String password, String nama, Date dob, String telefon, String email){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); // Set your date format
        String dateString = dateFormat.format(dob); // Get Date String according to date format
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.REGISTER);
        conn.sendData(uname);
        conn.sendData(password);
        conn.sendData(nama);
        conn.sendData(dateString);
        conn.sendData(telefon);
        conn.sendData(email);
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
     * @return              Objek pelanggan berdasarkan database server
     */
    public Pelanggan login(String uname, String password){
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.LOGIN);
        conn.sendData(uname);
        conn.sendData(password);
        data = conn.getData();
        pelanggan = null;
        if(data instanceof Pelanggan){
            if(data != null){
                pelanggan = (Pelanggan)data;
                conn.sendData(pelanggan);
                System.out.println("> Pelanggan" + pelanggan.getNama() + " berhasil login");
            }
        } 
        return pelanggan;
    }
    
    /**
     * Metode untuk melakukan proses logout dengan mengirimkan data ke server melalui socket.
     * 
     * @param   Pelanggan        Objek referensi untuk melakukan logout
     * 
     * @return              Kondisi apakah proses berhasil atau tidak
     */
    public Boolean logout(Pelanggan pelanggan){
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.LOGOUT);
        conn.sendData(pelanggan);
        return true;
    }
    
    /**
     * Metode untuk melakukan proses pemesanan oleh pelanggan ke database dan clientOjek
     * 
     * @param   TipeLayanan        tipe layanan yang digunakan oleh pelanggan
     * @param   Lokasi             Lokasi awal pesanan
     * @param   Lokasi             Lokasi akhir pesanan
     * @param   String             Pengguna jasa pada lokasi awal
     * @param   String             Pengguna jasa pada lokasi akhir
     * 
     */  
    public synchronized void pesananPesan(TipeLayanan tipeLayanan, Lokasi awal, Lokasi akhir, String pelangganAwal){
        System.out.println("> Pelanggan mengirim pesan");
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.PESAN);
        conn.sendData(new Pesanan(pelanggan, tipeLayanan, awal, akhir, pelangganAwal));
    }
    
    /**
     * Metode untuk melakukan proses pemesanan oleh pelanggan ke database dan clientOjek
     * 
     * @param   TipeLayanan        tipe layanan yang digunakan oleh pelanggan
     * @param   Lokasi             Lokasi awal pesanan
     * @param   Lokasi             Lokasi akhir pesanan
     * @param   String             Pengguna jasa pada lokasi awal
     * @param   String             Pengguna jasa pada lokasi akhir
     * 
     */  
    public synchronized void pesananPesan(TipeLayanan tipeLayanan, Lokasi awal, Lokasi akhir, String pelangganAwal, String pelangganAkhir){
        System.out.println("> Pelanggan mengirim pesan");
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.PESAN);
        conn.sendData(new Pesanan(pelanggan, tipeLayanan, awal, akhir, pelangganAwal, pelangganAkhir));
    }
    
    /**
     * Metode untuk melakukan proses pembatanan pesanan
     */  
    public synchronized void pesananBatal(){
        System.out.println("> Saya mau teleportasi saja");
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.BATAL);
        conn.sendData(pelanggan);
    }
    
    /**
     * Metode untuk melakukan penyelesaikan pesalanan yang sudah ada.
     * Metode ini digunakan untuk saling berbagi objek pesanan.
     * 
     * @see                 Model.Pesanan
     */
    public synchronized void pesananSelesai(){
        System.out.println("> Bintang lima");
        conn.sendCommand(ConnectionCommand.PENGGUNA);
        conn.sendCommand(ConnectionCommand.SELESAI);
        conn.sendData(pelanggan);
    }
    
    public synchronized Pelanggan getPelanggan(){
        return pelanggan;
    }
    
    public synchronized Pesanan getPesanan(){
        return pesanan;
    }
    
    public synchronized void setOjek(Pelanggan pelanggan){
        this.pelanggan = pelanggan;
    }
    
    public synchronized void setPesanan(Pesanan pesanan){
        this.pesanan = pesanan;
    }
    }