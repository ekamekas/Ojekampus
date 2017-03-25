import java.util.ArrayList;

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
    private static ArrayList<Pesanan> listPesanan = new ArrayList<Pesanan>();

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
        if(listPesanan != null){
            for(Pesanan listPesan : listPesanan){
                if(listPesan.getPelanggan() == pesan.getPelanggan()){
                    return false;
                }
            }
        }
        listPesanan.add(pesan);
        return true;
    }   
    
    /**
     * Getter database
     * 
     * @param       none            nothing
     * 
     * @return      -               -
     * 
     */
    public static ArrayList<Pesanan> getDatabase()
    {
        // put your code here
        return listPesanan;
    }
    
    /**
     * Getter pesanan - pesanan melalui list
     * 
     * @param       none            nothing
     * 
     * @return      listPesanan     menyimpan data - data dari seluruh instance pesanan yang ditambahkan
     * 
     */
    public static Pesanan getPesanan(Pelanggan pengguna)
    {
        /* 
         * Method mengembalikan daftar pesanan 
         */
        if(listPesanan != null){
            for(Pesanan pesan : listPesanan){
                if(pesan.getPelanggan() == pengguna)
                    return pesan;
            }
        }
        return null;
    }
    
    /**
     * Penghapusan pesanan dari dalam list
     * 
     * @param       pesan           pesanan layanan ojek
     * 
     * @return      boolean         merepresentasikan keberhasilan / tidaknya proses penambahan pesanan
     * 
     */
    public static boolean hapusPesanan(Pelanggan pengguna)
    {
        /* 
         * Method melakukan dereferensi instance Pesanan melalui parameter 
         */
        if(!listPesanan.isEmpty()){
            for(Pesanan listPesan : listPesanan){
                if(listPesan.getPelanggan() == pengguna){
                    if(listPesan.getPelayan() != null){
                        Administrasi.pesananSelesai(pengguna);
                        return true;
                    }
                }
            }
        }
        return false;
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
        if(!listPesanan.isEmpty()){
            for(Pesanan listPesan : listPesanan){
                if(pesan == listPesan){
                    if(listPesan.getPelayan() != null){
                        Administrasi.pesananSelesai(pesan);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
