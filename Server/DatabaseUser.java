package Server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Model.*;
/**
 * Kelas DatabaseUser menyimpan data setiap informasi Pelanggan dan Ojek yang dibuat sistem ojeKampus
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatabaseUser
{
    // setiap variabel hanya dapat diakses oleh DatabaseUser saja dan hanya dibuat sekali
    private static volatile ArrayList<User> userDatabase = new ArrayList<User>();
    protected static volatile Map<String, Socket> activeClients = new HashMap<String, Socket>();
    private static int id_ojek_terakhir = 1;
    private static int id_pelanggan_terakhir = 1;
    
    public static ArrayList<User> getDatabase(){
        return userDatabase;
    }
    
    /**
     * Penambahan ojek ke database
     * 
     * @param       baru           instance ojek yang akan ditambahkan
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static synchronized boolean addOjek(Ojek baru)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
        Ojek pelayan = new Ojek(baru.getID(), null, null, null);
       if(!userDatabase.isEmpty() && getOjekDatabase().contains(pelayan)){
           //System.out.println("[!] SYSTEM : Penambahan ojek gagal");
           return false;
       } else {
           userDatabase.add(baru);
           id_ojek_terakhir += 1;
           //System.out.println("[!] SYSTEM : Penambahan ojek berhasil");
           return true;
       }
    }
    
    /**
     * Penambahan ojek ke database
     * 
     * @param       baru           instance ojek yang akan ditambahkan
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static synchronized boolean addOjek(Ojek baru, Socket sock)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
        Ojek pelayan = new Ojek(baru.getID(), null, null, null);
       if(!userDatabase.isEmpty() && getOjekDatabase().contains(pelayan)){
           //System.out.println("[!] SYSTEM : Penambahan ojek gagal");
           return false;
       } else {
           userDatabase.add(baru);
           activeClients.put(baru.getUsername(), sock);
           id_ojek_terakhir += 1;
           //System.out.println("[!] SYSTEM : Penambahan ojek berhasil");
           return true;
       }
    }
    
    /**
     * Penambahan pelanggan ke database
     * 
     * @param       baru            Pengguna layanan ojeKampus
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static synchronized boolean addPelanggan(Pelanggan baru)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
       Pelanggan pelanggan = new Pelanggan(baru.getID(), null, null);   
       if(!userDatabase.isEmpty() && getPelangganDatabase().contains(pelanggan)){
           //System.out.println("[!] SYSTEM : Penambahan pelanggan gagal");
           return false;
       } else {
           userDatabase.add(baru);
           id_pelanggan_terakhir += 1;
           //System.out.println("[!] SYSTEM : Penambahan pelanggan berhasil");
           return true;
       }
    }
    
    /**
     * Penambahan pelanggan ke database
     * 
     * @param       baru            Pengguna layanan ojeKampus
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static synchronized boolean addPelanggan(Pelanggan baru, Socket sock)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
       Pelanggan pelanggan = new Pelanggan(baru.getID(), null, null);   
       if(!userDatabase.isEmpty() && getPelangganDatabase().contains(pelanggan)){
           //System.out.println("[!] SYSTEM : Penambahan pelanggan gagal");
           return false;
       } else {
           userDatabase.add(baru);
           activeClients.put(baru.getUsername(), sock);
           id_pelanggan_terakhir += 1;
           //System.out.println("[!] SYSTEM : Penambahan pelanggan berhasil");
           return true;
       }
    }
    
    /**
     * Mendapatkan nomor identitas ojek terakhir
     * 
     * @param       none nothing
     * 
     * @return      id_ojek_terakhir        nomor identitas ojek terakhir
     * 
     */
    public static int getIDOjekTerakhir()
    {
        /* 
         * Method mendapatkan nomor identitas ojek terakhir
         */
        return id_ojek_terakhir;
    }
    
    /**
     * Mendapatkan nomor identitas pelanggan terakhir
     * 
     * @param       none nothing
     * 
     * @return      id_pelanggan_terakhir nomor identitas pelanggan terakhir
     * 
     */
    public static int getIDPelangganTerakhir()
    {
        /* 
         * Method mendapatkan nomor identitas pelanggan terakhir
         */
        return id_pelanggan_terakhir;
    }
    
    public static synchronized ArrayList<Ojek> getOjekDatabase(){
        ArrayList<Ojek> ojekDatabase = new ArrayList<Ojek>();
        for(User u : userDatabase){
            if(u instanceof Ojek)
                ojekDatabase.add((Ojek)u);
        }
        return ojekDatabase;
    }
    
    public static ArrayList<Pelanggan> getPelangganDatabase(){
        ArrayList<Pelanggan> pelangganDatabase = new ArrayList<Pelanggan>();
        for(User u : userDatabase){
            if(u instanceof Pelanggan)
                pelangganDatabase.add((Pelanggan)u);
        }
        return pelangganDatabase;
    }
    
    /**
     * Mendapatkan informasi ojek
     * 
     * @param       none nothing
     * 
     * @return      ojekDatabase   ojek
     * 
     */
    public static Ojek getUserOjek(int id)
    {
        /* 
         * Method informasi ojek - ojek yang diwakili oleh ojekDatabase
         */
        for(Ojek ojek : getOjekDatabase()){
            if(ojek.getID() == id)
                return ojek;
        }
        return null;
    }
    
    /**
     * Mendapatkan informasi pelanggan
     * 
     * @param       none nothing
     * 
     * @return     pelangganDatabase pengguna ojek
     * 
     */
    public static Pelanggan getUserPelanggan(int id)
    {
        /* 
         * Method informasi pelanggan - pelanggan yang diwakili oleh pelangganDatabase
         */
        for(Pelanggan pengguna : getPelangganDatabase()){
            if(pengguna.getID() == id)
                return pengguna;
        }
        return null;
    }
    
    /**
     * Penghapusan pelanggan dari database
     * 
     * @param       id              identitas dari pelanggan
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean removePelanggan(int id)
    {
        /* 
         * Method melakukan dereferensi instance Pesanan melalui parameter pesan
         */
        for(Pelanggan pengguna : getPelangganDatabase()){
            if(pengguna.getID() == id){
                userDatabase.remove(pengguna);
                activeClients.remove(pengguna);
                return true;
            }
        }
        return false;
    }
      
    /**
     * Penghapusan ojek ke database
     * 
     * @param       id nomor identitas ojek
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean removeOjek(int id)
    {
        /* 
         * Method melakukan dereferensi instance Pesanan melalui parameter pesan
         */
        for(Ojek pelayan : getOjekDatabase()){
            if(pelayan.getID() == id){
                userDatabase.remove(pelayan);
                activeClients.remove(pelayan);
                return true;
            }
        }
        return false;
    }
    
    public static synchronized Boolean registerPelanggan(String uname, String password, String nama, String dob, String telefon, String email){
        try {
            return DatabaseConnector.updateData("insert into dataPelanggan (uname, password, nama, dob, telefon, email) VALUES ('" + uname + "', '" + password + "', '" + nama + "', to_date('" + dob + "', 'DD/MM/YYYY'), '" + telefon + "', '" + email + "')");
        }catch(Exception e){
            return false;
        }
    }
   
    public static synchronized Boolean registerOjek(String uname, String password, String nama, String dob, String telefon, String email, String noPlat){
        try {
            return DatabaseConnector.updateData("insert into dataOjek (uname, password, nama, dob, telefon, email, noplat) VALUES ('" + uname + "', '" + password + "', '" + nama + "', to_date('" + dob + "', 'DD/MM/YYYY'), '" + telefon + "', '" + email + "', '" + noPlat + "')");
        }catch(Exception e){
            return false;
        }
    }
    
    public static synchronized Pelanggan loginPengguna(String uname, String password){
        ArrayList<Object[]> data = DatabaseConnector.getData("Select * from dataPelanggan where uname='"+ uname +"' and password = '"+ password +"'");
        if(data.size() == 0)
            return null;
        else {
            Object[] obj = data.get(0);
            Pelanggan pelanggan = new Pelanggan((Integer)obj[0], (String)obj[1], (String)obj[3], (String)obj[5], (String)obj[6], (Date)obj[4]);
            return pelanggan;
        }
    }
    
    public static synchronized Ojek loginPelayan(String uname, String password){
        ArrayList<Object[]> data = DatabaseConnector.getData("Select * from dataOjek where uname='"+ uname +"' and password = '"+ password +"'");
        if(data.size() == 0)
            return null;
        else {
            Object[] obj = data.get(0);
            Ojek ojek = new Ojek((Integer)obj[0], (String)obj[1], (String)obj[3], (String)obj[5], (String)obj[6], (Date)obj[4], (String)obj[7], null);
            return ojek;
        }
    }
}
