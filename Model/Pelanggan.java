package Model;

import java.util.regex.*;
import java.util.Date;

/**
 * Kelas Pelanggan menangani data user dari sistem ojeKampus
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class Pelanggan extends User
{

    /**
     * Konstruktor dari kelas Pelanggan
     * 
     * @param       id              nomor identitas pelanggan
     * @param       nama            Nama pelanggan
     * 
     * @return      none            nothing
     * 
     */
    public Pelanggan(int id, String uname, String nama)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super(id, uname, nama);
    }
    
    /**
     * Konstruktor dari kelas Pelanggan
     * 
     * @param       id              nomor identitas pelanggan
     * @param       nama            Nama pelanggan
     * 
     * @return      none            nothing
     * 
     */
    public Pelanggan(int id, String uname, String nama, String telefon)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super(id, uname, nama, telefon);
    }
    
    public Pelanggan(int id, String uname, String nama, String telefon, String email)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super(id, uname, nama, telefon, email);
    }
    
    public Pelanggan(int id, String uname, String nama, String telefon, String email, Date dob)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super(id, uname, nama, telefon, email, dob);
    }
    
    /**
     * Print informasi identitasdan nama pelanggan
     * 
     * @param        none           nothing
     * @return       none 
     */
    public String toString()
    {
        /* 
         * Method ini menampilkan nomor identitas dan nama dari pelanggan
         */
        return "Nama Pelanggan : " + getNama() + '\n' + "ID : " + getID() + '\n' + "No Telefon " + getTelefon() + '\n';
    }
}
