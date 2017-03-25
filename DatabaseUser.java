import java.util.ArrayList;

/**
 * Kelas DatabaseUser menyimpan data setiap informasi Pelanggan dan Ojek yang dibuat sistem ojeKampus
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatabaseUser
{
    // setiap variabel hanya dapat diakses oleh DatabaseUser saja dan hanya dibuat sekali
    private static ArrayList<Pelanggan> pelangganDatabase = new ArrayList<Pelanggan>();;
    private static ArrayList<Ojek> ojekDatabase = new ArrayList<Ojek>();
    private static int id_ojek_terakhir = 1;
    private static int id_pelanggan_terakhir = 1;

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
       if(!ojekDatabase.isEmpty() && ojekDatabase.contains(baru)){
           return false;
       } else {
           ojekDatabase.add(baru);
           id_ojek_terakhir += 1;
           System.out.println("Penambahan ojek berhasil");
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
    public static boolean addPelanggan(Pelanggan baru)
    {
        /* 
         * Method melakukan referensi instance Pesanan melalui parameter pesan
         */
       if(!pelangganDatabase.isEmpty() && pelangganDatabase.contains(baru)){
           return false;
       } else {
           pelangganDatabase.add(baru);
           id_pelanggan_terakhir += 1;
           System.out.println("Penambahan pelanggan berhasil");
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
    
    public static ArrayList<Ojek> getOjekDatabase(){
        return ojekDatabase;
    }
    
    public static ArrayList<Pelanggan> getPelangganDatabase(){
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
        for(Ojek ojek : ojekDatabase){
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
        for(Pelanggan pengguna : pelangganDatabase){
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
        for(Pelanggan pengguna : pelangganDatabase){
            if(pengguna.getID() == id){
                pelangganDatabase.remove(pengguna);
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
        for(Ojek pelayan : ojekDatabase){
            if(pelayan.getID() == id){
                ojekDatabase.remove(pelayan);
                return true;
            }
        }
        return false;
    }
}
