
/**
 * Kelas DatabaseUser menyimpan data setiap informasi Pelanggan dan Ojek yang dibuat sistem ojeKampus
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatabaseUser
{
    // setiap variabel hanya dapat diakses oleh DatabaseUser saja dan hanya dibuat sekali
    private static Pelanggan pelanggan_database;
    private static Ojek ojek_database;
    private static int id_ojek_terakhir = 1;
    private static int id_pelanggan_terakhir = 1;

    /**
     * Penambahan pelanggan ke database
     * 
     * @param       baru            Pengguna layanan ojeKampus
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean addPelanggan(Pelanggan baru)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
        pelanggan_database = baru;
        System.out.println("Penambahan pelanggan berhasil");
        return true;
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
        pelanggan_database = null;
        return true;
    }
    
    /**
     * Penambahan ojek ke database
     * 
     * @param       baru           instance ojek yang akan ditambahkan
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean addOjek(Ojek baru)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
        ojek_database = baru;
        System.out.println("Penambahan ojek berhasil");
        return true;
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
        ojek_database = null;
        return true;
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
    
    /**
     * Mendapatkan informasi ojek
     * 
     * @param       none nothing
     * 
     * @return      ojek_database   ojek
     * 
     */
    public static Ojek getUserOjek()
    {
        /* 
         * Method informasi ojek - ojek yang diwakili oleh ojek_database
         */
        return ojek_database;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public Pelanggan getOjekDatabase()
    {
        // put your code here
        return "";
    }*/
    
    /**
     * Mendapatkan informasi pelanggan
     * 
     * @param       none nothing
     * 
     * @return     pelanggan_database pengguna ojek
     * 
     */
    public static Pelanggan getUserPelanggan()
    {
        /* 
         * Method informasi pelanggan - pelanggan yang diwakili oleh pelanggan_database
         */
        return pelanggan_database;
    }
    
    /**
     * Penambahan pesanan baru ke dalam list
     * 
     * @param       none nothing
     * 
     * @return      - -
     * 
     */
    public String getPelangganDatabase()
    {
        // put your code here
        return "";
    }
}
