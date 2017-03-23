
/**
 * Write a description of class Mahasiswa here.
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.23
 */
public class Mahasiswa
{
    // instance variables - replace the example below with your own
    private String nama;
    private int nilai;

    /**
     * Constructor for objects of class Mahasiswa
     */
    public Mahasiswa(String nama, int nilai)
    {
        // initialise instance variables
        this.nama = nama;
        this.nilai = nilai;
    }
    
     /**
     * Metod untuk mengembalikan String nama
     * @param  nama   deskripsi nama dari mahasiswa 
     */
    public void setNama(String nama){
        this.nama = nama;
    }
    
    /**
     * Metod untuk mengembalikan String nama
     * @param  nilai   deskripsi nilai dari mahasiswa 
     */
    public void setNilai(int nilai){
        this.nilai = nilai;
    }
    
    /**
     * Metod untuk mengembalikan String nama
     * @return     Nama dari Mahasiswa 
     */
    public String getNama(){
        return nama;
    }
    
    /**
     * Metod untuk mengembalikan String nama
     * @return     Nilai dari Mahasiswa 
     */
    public int getNilai(){
        return nilai;
    }
}
