package Server;

import Model.*;
import java.util.ListIterator;
/**
 * Write a description of class Administrasi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */public class Administrasi
{
    // instance variables - replace the example below with your 
    private static final int PER_BIAYA = 100;
//     
//     public static Pesanan cariPesananIdle(){
//         for(Pesanan pesan : DatabasePesanan.getDatabase()){
//             if(!pesan.getStatusDiproses() && !pesan.getStatusSelesai())
//                 return pesan;
//         }
//         return null;
//     }
//     
//     public static void jalankanSistemPenugas(){
//         Pesanan pesan = cariPesananIdle();
//         Ojek pelayan = temukanOjekTerdekat(pesan);
//         ojekAmbilPesanan(pesan, pelayan);
//     }
           
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    protected static void ojekAmbilPesanan(Pesanan pesan, Ojek pelayan)
    {
        // put your code here
        if(pesan != null && pelayan != null){
            pelayan.setStatus(StatusOjek.JEMPUT);
            pelayan.setPesanan(pesan);
            pesan.setPelayan(pelayan);
            pesan.setStatusDiproses(true);
            pesan.setStatusSelesai(false);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
        public static void ojekLepasPesanan(Ojek pelayan)
    {
        // put your code here
        pelayan.setStatus(StatusOjek.IDLE);
        pelayan.getPesanan().setPelayan(null);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setPelayan(null);
        pelayan.setPesanan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDibatalkan(Ojek pelayan)
    {
        // put your code here
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusSelesai(false);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusDibatalkan(true);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusDiproses(false);
        ojekLepasPesanan(pelayan);
        pelayan.setPesanan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDibatalkan(Pelanggan pengguna)
    {
        // put your code here
        ojekLepasPesanan(DatabasePesanan.getPesanan(pengguna).getPelayan());
        DatabasePesanan.getPesanan(pengguna).setStatusSelesai(false);
        DatabasePesanan.getPesanan(pengguna).setStatusDibatalkan(true);
        DatabasePesanan.getPesanan(pengguna).setStatusDiproses(false);
        DatabasePesanan.getPesanan(pengguna).setPelayan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDibatalkan(Pesanan pesan)
    {
        // put your code here
        ojekLepasPesanan(pesan.getPelayan());
        pesan.setStatusSelesai(false);
        pesan.setStatusDibatalkan(true);
        pesan.setStatusDiproses(false);
        pesan.setPelayan(null);
    }
                    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananDitugaskan(Pesanan pesan, Ojek pelayan)
    {
        // put your code here
        pesan.setStatusSelesai(false);
        pesan.setStatusDibatalkan(false);
        pesan.setStatusDiproses(true);
        pesan.setPelayan(pelayan);
        ojekAmbilPesanan(pesan, pelayan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananSelesai(Ojek pelayan)
    {
        // put your code here
        pelayan.getPesanan().setStatusSelesai(true);
        pelayan.getPesanan().setStatusDiproses(false);
        pelayan.getPesanan().setStatusDibatalkan(false);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusSelesai(true);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusDibatalkan(false);
        DatabasePesanan.getPesanan(pelayan.getPesanan().getPelanggan()).setStatusDiproses(false);
        pelayan.setPesanan(null);
        ojekLepasPesanan(pelayan);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananSelesai(Pelanggan pengguna)
    {
        // put your code here
        ojekLepasPesanan(DatabasePesanan.getPesanan(pengguna).getPelayan());
        DatabasePesanan.getPesanan(pengguna).setStatusSelesai(true);
        DatabasePesanan.getPesanan(pengguna).setStatusDibatalkan(false);
        DatabasePesanan.getPesanan(pengguna).setStatusDiproses(false);
        DatabasePesanan.getPesanan(pengguna).setPelayan(null);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void pesananSelesai(Pesanan pesan)
    {
        // put your code here
        ojekLepasPesanan(DatabaseUser.getUserOjek(pesan.getPelayan().getID()));
        pesan.setStatusSelesai(true);
        pesan.setStatusDiproses(false);
        pesan.setStatusDiproses(false);
        pesan.setPelayan(null);
    }
    
    /**
     * 
     */
    public static void printAllDatabase(){
        printOjekDatabase();
        printPelangganDatabase();
        printPesananDatabase();
    }
    
    /**
     * 
     */
    public static void printOjekDatabase(){
        System.out.println("Database Ojek : ");
        for(Ojek pelayan : DatabaseUser.getOjekDatabase()){
            System.out.println(pelayan);
        }
    }
    
    /**
     * 
     */
    public static void printPelangganDatabase(){
        System.out.println("Database Pelanggan : ");
        for(Pelanggan pengguna : DatabaseUser.getPelangganDatabase()){
            System.out.println(pengguna);
        }
    }
    
    /**
     * 
     */
    public static void printPesananDatabase(){
        System.out.println("Database Pesanan : ");
        for(Pesanan pesan : DatabasePesanan.getDatabase()){
            System.out.println(pesan);
        }
    }
    
    /**
     * 
     */
    protected static Ojek temukanOjekTerdekat(Pesanan pesan){
        Ojek ojekTerdekat = null;
        if(!DatabaseUser.getOjekDatabase().isEmpty() && pesan != null){
            Ojek currentOjek = null;
            ListIterator<Ojek> listIterator = DatabaseUser.getOjekDatabase().listIterator();
            double jarak;
            while(listIterator.hasNext()){
                currentOjek = listIterator.next();
                if(currentOjek.getStatus().equals(StatusOjek.IDLE))
                    break;
            }
            ojekTerdekat = currentOjek;
            double jarakTerdekat = Math.sqrt((Math.pow(ojekTerdekat.getPosisi().getX(), 2) - Math.pow(pesan.getLokasiAwal().getX(), 2)) + (Math.pow(ojekTerdekat.getPosisi().getY(), 2) - Math.pow(pesan.getLokasiAwal().getY(), 2)));
            while(listIterator.hasNext()){
                while(listIterator.hasNext()){
                    currentOjek = listIterator.next();
                    if(currentOjek.getStatus().equals(StatusOjek.IDLE))
                        break;
                }
                jarak = Math.sqrt((Math.pow(currentOjek.getPosisi().getX(), 2) - Math.pow(pesan.getLokasiAwal().getX(), 2)) + (Math.pow(currentOjek.getPosisi().getY(), 2) - Math.pow(pesan.getLokasiAwal().getY(), 2)));
                    if(jarak < jarakTerdekat){
                       jarakTerdekat = jarak;
                       ojekTerdekat = currentOjek;
                    }
            }
            return ojekTerdekat;
        } else {
            return null;
        }
    }
    
    protected static int hitungBiaya(Pesanan pesanan){
        int jarak = (int)Math.sqrt((Math.pow(pesanan.getLokasiAwal().getX() - pesanan.getLokasiAkhir().getX(), 2)) + Math.pow(pesanan.getLokasiAwal().getY() - pesanan.getLokasiAkhir().getY(), 2));
        return jarak * PER_BIAYA;
    }
}
