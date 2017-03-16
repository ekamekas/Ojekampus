    
/**
 * Kelas Pelanggan menangani data user dari sistem ojeKampus
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class Pelanggan
{
    // variabel id hanya dapat diakses oleh Pelanggan
    private int id;
    // variabel nama hanya dapat diakses oleh Pelanggan
    private String nama, telefon, email, dob;

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
        this.id = id;
        // this.nama merupakan nama dari pelanggan
        this.nama = nama;
    }

    /**
     * Getter identitas pelanggan ojek
     * 
     * @param       none            nothing
     * @return      id              mengembalikan nilai nomor identitas
     */
    public int getID()
    {
       // Method ini akan mengembalikan nilai variabel class id
       // variabel id merupakan nomor identitas dari pelanggan
        return id;
    }    
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public String getDOB()
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        return dob;
    }
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public String getNama()
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        return nama;
    }
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public String getTelefon()
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        return telefon;
    }
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public String getEmail()
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        return email;
    }
    
    /**
     * Setter identitas pelanggan di ojek
     * 
     * @param       id              nilai id yang akan diset
     * @return      none            nothing 
     */
    public void setID(int id)
    {
        /* 
         * Method ini akan mem-passing parameter id ke variabel id
         * nilai this.id akan digantikan dengan nilai variabel id
         */
        // this.id merupakan penamaan alternatif dari variabel class id
        this.id = id;
    }    
    
    /**
     * Setter nama pelanggan ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public void setDOB(String dob)
    {
        /* 
         * Method ini akan mem-passing parameter id ke variabel nama
         * nilai this.nama akan digantikan dengan nilai variabel nama
         */
        // this.id merupakan penamaan alternatif dari variabel class nama   
        this.dob = dob;
    }
    
    /**
     * Setter nama pelanggan ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public void setNama(String nama)
    {
        /* 
         * Method ini akan mem-passing parameter id ke variabel nama
         * nilai this.nama akan digantikan dengan nilai variabel nama
         */
        // this.id merupakan penamaan alternatif dari variabel class nama   
        this.nama = nama;
    }
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public void setTelefon(String telefon)
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        this.telefon = telefon;
    }
    
    /**
     * Getter nama pelanggan ojek
     * 
     * @param       none             nothing
     * @return      nama             mengembalikan nama pengemudi ojek 
     */
    public void setEmail(String email)
    {
        // Method ini akan mengembalikan nilai variabel class nama berupa String
        // variabel nama merupakan nama dari pelanggan
        this.email = email;
    }
    
    /**
     * Print informasi identitasdan nama pelanggan
     * 
     * @param        none           nothing
     * @return       none 
     */
    public void printData()
    {
        /* 
         * Method ini menampilkan nomor identitas dan nama dari pelanggan
         */
        // this.id adalah variabel class yang menyimpan nomor identitas pelanggan
        System.out.println("ID : " + this.id);
        // this.nama adalah variabel class yang menyimpan nama pelanggan
        System.out.println("Nama : " + this.nama);
    }
}
