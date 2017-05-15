package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

import Model.*;
import Controller.ConnectionCommand;
/**
 * Kelas ini berfungsi untuk mengatasi sebagai proses yang berkaitan dengan socket
 * Kelas ini digunakan untuk mengirimkan dan menerima data dari/ke server dan client
 * Kelas ini merupakan program inti dari server dimana mengatasi permintaan proses dari client.
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.12
 * 
 * TODO:Mengatasi masalah ketika client terminasi secara paksa
 * 
 */
public class ServerConnectionHandler implements Runnable
{
    // instance variables - replace the example below with your own
    private Thread t;
    private String threadName;
    private boolean programRun;
    private int waktuCek;
    private Socket sock;
    
    /**
     * Konstruktor dari kelas ServerConnectionHandler
     * 
     * @param   Socket    socket unik yang menjadi media hubungan dengan client
     * @param   String    namaThread untuk Objek WatchDog
     * @param   int       Waktu ketika akan melakukan pemberhentian semetara
     * 
     */
    public ServerConnectionHandler(Socket sock, String name, int waktuCek)
    {
        // initialise instance variables
        this.sock = sock;
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
                Object data = getData();
                if(data instanceof ConnectionCommand){
                    ConnectionCommand command = (ConnectionCommand)data;
                    if(command.equals(ConnectionCommand.PENGGUNA)){
                        command = (ConnectionCommand)getData();
                        if(command.equals(ConnectionCommand.LOGIN)){
                            String uname = (String)getData();
                            String password = (String)getData();
                            Pelanggan pelanggan = DatabaseUser.loginPengguna(uname, password);
                            sendData(pelanggan);
                            if(pelanggan != null){
                                pelanggan = (Pelanggan)getData();
                                DatabaseUser.addPelanggan(pelanggan, sock);
                                System.out.println("> Pelanggan " + pelanggan.getNama() + " login");
                                System.out.println("[System] Total " + DatabaseUser.activeClients.size() + " active clients");
                            }
                        }else if(command.equals(ConnectionCommand.LOGOUT)){
                            Pelanggan pelanggan = (Pelanggan)getData();
                            if(DatabaseUser.removePelanggan(pelanggan.getID())){
                                sendData(true);
                                System.out.println("> Pelanggan " + pelanggan.getNama() + " logout");
                            }
                            else
                                sendData(false);
                        }else if(command.equals(ConnectionCommand.REGISTER)){
                            String uname = (String)getData();
                            String password = (String)getData();
                            String nama = (String)getData();
                            String dob = (String)getData();
                            String noTelepon = (String)getData();
                            String email = (String)getData();
                            if(DatabaseUser.registerPelanggan(uname, password, nama, dob, noTelepon, email)){
                                sendData(true);
                                System.out.println("> Pelanggan baru registrasi dengan username " + uname + " berhasil");
                            }else{
                                sendData(false);
                                System.out.println("> Pelanggan baru registrasi dengan username " + uname + " gagal");
                            }
                        }else if(command.equals(ConnectionCommand.PESAN)){
                            Pesanan pesanan = (Pesanan)getData();
                            pesanan.setBiaya(Administrasi.hitungBiaya(pesanan));
                            Pelanggan pelanggan = pesanan.getPelanggan();
                            Ojek ojek = Administrasi.temukanOjekTerdekat(pesanan);
                            if(ojek == null){
                                System.out.println("[!] Pelanggan" + pelanggan.getNama());
                                System.out.println("[!] Tidak ditemukan pelayan terdekat");
                                sendData(ConnectionCommand.UNKNOWN);
                            }else{
                                Socket newSock = DatabaseUser.activeClients.get(ojek.getUsername());
                                sendData(ConnectionCommand.PESAN, newSock);
                                sendData(pesanan, newSock);
                            }
                       }else if(command.equals(ConnectionCommand.BATAL)){
                            Pelanggan pelanggan = (Pelanggan)getData();
                            pelanggan = DatabaseUser.getUserPelanggan(pelanggan.getID());
                            System.out.println("[!] Pelanggan " + pelanggan.getNama() + " tidak punya uang");
                            Socket newSock = DatabaseUser.activeClients.get(DatabasePesanan.getPesanan(pelanggan).getPelayan().getUsername());
                            if(newSock == null){
                                System.out.println("[!] Pelanggan" + pelanggan.getNama());
                                System.out.println("[!] Ojek tidak aktif");
                                sendData(ConnectionCommand.UNKNOWN);
                            }else{
                                sendData(ConnectionCommand.BATAL);
                                sendData(ConnectionCommand.BATAL, newSock);
                                Administrasi.pesananDibatalkan(pelanggan);
                                sendData(DatabasePesanan.getPesanan(pelanggan), newSock);
                                sendData(DatabasePesanan.getPesanan(pelanggan));
                                DatabasePesanan.hapusPesanan(DatabasePesanan.getPesanan(pelanggan));
                            }
                        }else if(command.equals(ConnectionCommand.SELESAI)){
                            Pelanggan pelanggan = (Pelanggan)getData();
                            Socket newSock = DatabaseUser.activeClients.get(DatabaseUser.getUserOjek(DatabasePesanan.getPesanan(pelanggan).getPelayan().getID()).getUsername());
                            if(newSock == null){
                                System.out.println("[!] Pelanggan " + pelanggan.getNama());
                                System.out.println("[!] Ojek tidak aktif");
                                sendData(ConnectionCommand.UNKNOWN);
                            }else{
                                System.out.println("[!] Pelanggan " + pelanggan.getNama() + " menyelesaikan pesanan");
                                sendData(ConnectionCommand.SELESAI, newSock);
                                sendData(ConnectionCommand.SELESAI);
                                Administrasi.pesananSelesai(DatabasePesanan.getPesanan(pelanggan));
                                sendData(DatabasePesanan.getPesanan(pelanggan), newSock);
                                sendData(DatabasePesanan.getPesanan(pelanggan));
                                DatabasePesanan.hapusPesanan(DatabasePesanan.getPesanan(pelanggan));
                            }
                        }else if(command.equals(ConnectionCommand.HAPUS)){
                            // NOP
                        }
                    }else if(command.equals(ConnectionCommand.OJEK)){
                        System.out.println(ConnectionCommand.OJEK);
                        command = (ConnectionCommand)getData();
                        if(command.equals(ConnectionCommand.LOGIN)){
                            String uname = (String)getData();
                            String password = (String)getData();
                            Ojek ojek = DatabaseUser.loginPelayan(uname, password);
                            sendData(ojek);
                            if(ojek != null){
                                ojek = (Ojek)getData();
                                DatabaseUser.addOjek(ojek, sock);
                                System.out.println("> Ojek " + ojek.getNama() + " login");
                                System.out.println("[System] Total " + DatabaseUser.activeClients.size() + " active clients");
                            }
                        }else if(command.equals(ConnectionCommand.LOGOUT)){
                            Ojek ojek = (Ojek)getData();
                            if(DatabaseUser.removeOjek(ojek.getID())){
                                sendData(true);
                                System.out.println("> Ojek " + ojek.getNama() + " logout");
                            }else {
                                sendData(false);
                            }
                        }else if(command.equals(ConnectionCommand.REGISTER)){
                            System.out.println("> Ojek baru registrasi dengan username  berhasil");
                            String uname = (String)getData();
                            System.out.println("> Ojek baru registrasi dengan username l");
                            String password = (String)getData();
                            String nama = (String)getData();
                            String dob = (String)getData();
                            String noTelepon = (String)getData();
                            String email = (String)getData();
                            String noPlat = (String)getData();
                            if(DatabaseUser.registerOjek(uname, password, nama, dob, noTelepon, email, noPlat)){
                                sendData(true);
                                System.out.println("> Ojek baru registrasi dengan username " + uname + " berhasil");
                            }else{
                                sendData(false);
                                System.out.println("> Ojek baru registrasi dengan username " + uname + " gagal");
                            }
                        }else if(command.equals(ConnectionCommand.AMBIL)){
                            Pesanan pesanan = (Pesanan)getData();
                            if(pesanan.getPelayan() != null){
                                Administrasi.ojekAmbilPesanan(pesanan, DatabaseUser.getUserOjek(pesanan.getPelayan().getID()));
                                DatabasePesanan.addPesanan(pesanan);
                                System.out.println("> Ojek " + pesanan.getPelayan().getNama() + " berhasil mengambil pesanan");
                            }
                            Socket newSock = DatabaseUser.activeClients.get(pesanan.getPelanggan().getUsername());
                            sendData(ConnectionCommand.PESAN, newSock);
                            sendData(pesanan, newSock);
                            sendData(ConnectionCommand.AMBIL);
                            sendData(pesanan);
                        }else if(command.equals(ConnectionCommand.BATAL)){
                            Ojek ojek = (Ojek)getData();
                            Pesanan pesanan = ojek.getPesanan();
                            System.out.println("[!] Ojek " + ojek.getNama() + " sudah kaya");
                            Pelanggan pelanggan = ojek.getPesanan().getPelanggan();
                            Socket newSock = DatabaseUser.activeClients.get(DatabaseUser.getUserOjek(ojek.getID()).getPesanan().getPelanggan().getUsername());
                            sendData(ConnectionCommand.BATAL, newSock);
                            sendData(ConnectionCommand.BATAL);
                            Administrasi.pesananDibatalkan(DatabaseUser.getUserOjek(ojek.getID()));
                            pesanan = DatabasePesanan.getPesanan(pelanggan);
                            sendData(pesanan, newSock);
                            sendData(pesanan);
                            DatabasePesanan.hapusPesanan(DatabasePesanan.getPesanan(pelanggan));
                        }else if(command.equals(ConnectionCommand.HAPUS)){
                            // NOP   
                        }
                    }else{
                        sendData(DatabasePesanan.getDatabase());
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
     * Metode ini digunakan ketika kita ingin menjalankan thread dari ServerConnectionHandler.
     * Metode ini akan membuat thread baru dari instance ServerConnectionHandler.
     */
    public void start(){
        System.out.println("Starting " + threadName);
        t = new Thread(this);
        t.start();
    }
    
    /**
     * Metode ini digunakan ketika pemanggil menunggu hingga ServerConnectionHandler memasuka kondisi program selesai/mati.
     */
    public void join(){
        try {
            t.join();
        } catch(InterruptedException e){
            System.out.println("[System] Thread " + threadName + " interrupted");
        }
    }
    
    /**
     * Metode yang untuk menghentikan proses WatchDog, termasuk menutup konektifitas socket.
     */
    public void exit(){
        programRun = false;
        try {
            sock.close();
        }catch(IOException e){
            
        }
    }
    
    /**
     * Metode ini untuk mengirimkan data secara umum
     * 
     * @param   Object   data yang akan dikirimkan ke remote
     * @see     Object
     */
    protected void sendData(Object data){
        try{      
            ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
            out.writeObject(data);
            out.flush();
        }catch(EOFException | SocketException e){
            exit();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Metode ini untuk mengirimkan data secara umum dengan socket yang berbeda
     * 
     * @param   Object   data yang akan dikirimkan ke remote
     * @param   Socket   Socket baru yang berbeda dengan socket yang dipakai oleh thread program ini
     * @see     Object
     */
    protected void sendData(Object data, Socket newSock){
        try{      
            ObjectOutputStream out = new ObjectOutputStream(newSock.getOutputStream());
            out.writeObject(data);
            out.flush();
        }catch(EOFException | SocketException e){
            exit();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Metode ini untuk menerima data secara umum
     * 
     * @return   Object   data yang diterima dari remote
     * @see     Object
     */
    protected Object getData(){
        Object data = null;
        try{
            ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
            data = in.readObject();
        }catch(EOFException | SocketException e){
            exit();
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    /**
     * Metode ini untuk menerima data secara umum dengan socket yang berbeda
     * 
     * @param   Socket   Socket baru yang berbeda dengan socket yang dipakai oleh thread program ini
     * 
     * @return   Object   data yang diterima dari remote
     * @see     Object
     */
    protected Object getData(Socket newSock){
        Object data = null;
        try{
            ObjectInputStream in = new ObjectInputStream(newSock.getInputStream());
            data = in.readObject();
        }catch(EOFException | SocketException e){
            exit();
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public static void main(String[] args){
        try{  
            ServerSocket serverSocket = new ServerSocket(6666);  
            while (true) {
                 Socket sock = serverSocket.accept();
                 System.out.println("[System] Connected");
                 if(sock.isConnected()){
                     new ServerConnectionHandler(sock, "socket" + Thread.activeCount(), 100).start();
                 }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
