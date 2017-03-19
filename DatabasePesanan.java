
/**
 * Kelas DatabasePesanan menyimpan data setiap pesanan yang dibuat akibat user dari sistem ojeKampus
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class DatabasePesanan
{
    // setiap variabel hanya dapat diakses oleh DatabasePesanan saja
    // listPesanan menyimpan data - data dari seluruh instance pesanan yang ditambahkan
    private static Pesanan listPesanan;

    /**
     * Penambahan pesanan baru ke dalam list
     * 
     * @param       pesan           pesanan layanan ojek
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean addPesanan(Pesanan pesan)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
        listPesanan = pesan;
        return true;
    }
    
    /**
     * Penghapusan pesanan dari dalam list
     * 
     * @param       pesan           pesanan layanan ojek
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean hapusPesanan(Pesanan pesan)
    {
        /* 
         * Method melakukan dereferensi instance Pesanan melalui parameter 
         */
        listPesanan = null;
        return true;
    }
    
    /**
     * Getter pesanan - pesanan melalui list
     * 
     * @param       none            nothing
     * 
     * @return      listPesanan     menyimpan data - data dari seluruh instance pesanan yang ditambahkan
     * 
     */
    public static Pesanan getPesanan()
    {
        /* 
         * Method mengembalikan daftar pesanan 
         */
        return listPesanan;
    }
    
    /**
     * Getter database
     * 
     * @param       none            nothing
     * 
     * @return      -               -
     * 
     */
    public String getDatabase()
    {
        // put your code here
        return "";
    }
    
    /**
     * Membatalkan pesanan
     * 
     * @param       none            nothing
     * 
     * @return      -               -
     * 
     */
    public void pesananDibatalkan(Pesanan pesan)
    {
        // put your code here
    }
    
    /**
     * Membatalkan pesanan dari sisi pengguna
     * 
     * @param       none            nothing
     * 
     * @return      -               -
     * 
     */
    public void pesananDibatalkan(Pelanggan pengguna)
    {
        // put your code here
    }
    
    /**
     * 
     * 
     * @param       
     * 
     * @return      
     * 
     */
    public static void printData()
    {
        /* 
         * Method melakukan dereferensi instance Pesanan melalui parameter 
         */
        System.out.println(listPesanan.getPenggunaAwal() + " di " + listPesanan.getLokasiAwal().getNama() + " | " + listPesanan.getPenggunaAkhir() + " di " + listPesanan.getLokasiAkhir().getNama() + " dengan layanan " + listPesanan.getTipeLayanan());
        if(listPesanan.getStatusSelesai()){
            System.out.println("STATUS : Selesai");
        } else if(listPesanan.getStatusDiproses()){
            System.out.println("STATUS : Diproses");
        }
    }
}
