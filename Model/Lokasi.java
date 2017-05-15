package Model;

import java.io.Serializable;
/**
 * Kelas Lokasi menangani data geo-lokasi dari sistem ojeKampus
 * <br />
 * Kelas Lokasi menyimpan data x (lintang) dan y (bujur) beserta keterangan nama
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class Lokasi implements Serializable
{
    // Setiap variabel dan instance variabel hanya dapat diakses oleh class Pesanan saja
    // variabel x sebagai representasi koordinat axis horizontal dalam peta
    private double x;
    // variabel y sebagai representasi koordinat axis vertikal dalam peta
    private double y;
    // variabel namaLokasi merupakan nama dari lokasi yang direpresentasikan koorditat x, y
    private String namaLokasi;
    // variabel keteranganLokasi merupakan keterangan dari lokasi yang direpresentasikan koorditat x, y
    private String keteranganLokasi;

    /**
     * Konstruktor objek dari kelas Lokasi
     * 
     * @param       namaLokasi      nama dari lokasi yang direpresentasikan koorditat x, y
     * @param       x               koordinat axis horizontal dalam peta
     * @param       y               koordinat axis vertikal dalam peta
     * @param       keteranganLokasi keterangan dari lokasi yang direpresentasikan koorditat x, y   
     * 
     * @return      none            nothing
     * 
     */
    public Lokasi(String namaLokasi, double x, double y, String keteranganLokasi)
    {
        /* Konstruktor Lokasi akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Lokasi dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // nilai parameter namaLokasi akan di berikan ke variabel class this.namaLokasi
        this.namaLokasi = namaLokasi;
        // nilai parameter x akan di berikan ke variabel class this.x
        this.x = x;
        // nilai parameter y akan di berikan ke variabel class this.y
        this.y = y;
        // nilai parameter keteranganLokasi akan di berikan ke variabel class this.keteranganLokasi
        this.keteranganLokasi = keteranganLokasi;
    }

    /**
     * Getter koordinat x
     * 
     * @param       none            nothing
     * @return      x               representasi koordinat axis horizontal dalam peta 
     */
    public double getX()
    {
        // Method ini akan mengembalikan nilai variabel class x
        return x;
    }
    
    /**
     * Getter koordinat y
     * 
     * @param       none            nothing
     * @return      y               representasi koordinat axis vertikal dalam peta 
     */
    public double getY()
    {
        // Method ini akan mengembalikan nilai variabel class y
        return y;
    }
    
    /**
     * Getter nama lokasi koordinat
     * 
     * @param       none            nothing
     * @return      namaLokasi      merupakan nama dari lokasi yang direpresentasikan koorditat x, y 
     */
    public String getNama()
    {
        // Method ini akan mengembalikan nilai variabel class namaLokasi
        return namaLokasi;
    }
    
    /**
     * Getter keterangan lokasi koordinat
     * 
     * @param       none            nothing
     * @return      keteranganLokasi merupakan keterangan dari lokasi yang direpresentasikan koorditat x, y 
     */
    public String getKeteranganLokasi()
    {
        // Method ini akan mengembalikan nilai variabel class keteranganLokasi
        return keteranganLokasi;
    }
    
    /**
     * Setter koordinat x
     * 
     * @param       x               representasi koordinat axis horizontal dalam peta
     * @return      none            nothing 
     */
    public void setX(double x)
    {
        /* 
         * Method ini akan mem-passing parameter x ke variabel x
         * Nilai dari variabel class x akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.x merupakan penamaan alternatif dari variabel class x
        this.x = x;
    }
    
    /**
     * Setter koordinat y
     * 
     * @param       y               representasi koordinat axis vertikal dalam peta
     * @return      none            nothing 
     */
    public void setY(double y)
    {
        /* 
         * Method ini akan mem-passing parameter y ke variabel y
         * Nilai dari variabel class y akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.y merupakan penamaan alternatif dari variabel class y
        this.y = y;
    }
    
    /**
     * Setter nama lokasi koordinat
     * 
     * @param       namaLokasi      merupakan nama dari lokasi yang direpresentasikan koorditat x, y
     * @return      none            nothing 
     */
    public void setNama(String namaLokasi)
    {
        /* 
         * Method ini akan mem-passing parameter namaLokasi ke variabel namaLokasi
         * Nilai dari variabel class namaLokasi akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.namaLokasi merupakan penamaan alternatif dari variabel class namaLokasi
        this.namaLokasi = namaLokasi;
    }
    
    /**
     * Setter keterangan nama lokasi koordinat
     * 
     * @param       keteranganLokasi merupakan keterangan dari lokasi yang direpresentasikan koorditat x, y
     * @return      none            nothing 
     */
    public void setKeteranganLokasi(String keteranganLokasi)
    {
        /* 
         * Method ini akan mem-passing parameter keteranganLokasi ke variabel keteranganLokasi
         * Nilai dari variabel class keteranganLokasi akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.keteranganLokasi merupakan penamaan alternatif dari variabel class keteranganLokasi
        this.keteranganLokasi = keteranganLokasi;
    }
}
