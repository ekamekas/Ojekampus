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
    public Pelanggan(int id, String nama)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super.id = id;
        // this.nama merupakan nama dari pelanggan
        super.nama = nama;
        //
        super.telefon = "";
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
    public Pelanggan(int id, String nama, String telefon)
    {
        /* Konstruktor Pelanggan akan berperan sebagai inisiasi variabel ketika Objek Pelanggan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // this.id merupaakan nomor identitas yang merepresentasikan pelanggan
        super.id = id;
        // this.nama merupakan nama dari pelanggan
        super.nama = nama;
        //
        super.telefon = telefon;
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
        if(DatabasePesanan.getPesanan(this) == null){
            return "Nama Pelanggan : " + getNama() + '\n' + "ID : " + getID() + '\n' + "No Telefon " + getTelefon() + '\n';
        } else {
            return "Nama Pelanggan : " + getNama() + '\n' + "ID : " + getID() + '\n' + "No Telefon " + getTelefon() + '\n' + "Pelanggan Awal : " + DatabasePesanan.getPesanan(this).getPenggunaAwal() + '\n';
        }
    }
}
