import java.util.GregorianCalendar;

/**
 * OjeKampus adalah sebuah kelas untuk menjalankan sistem ojek
 * <br />
 * Kelas ini digunakan untuk menjalankan program ojek secara umum
 * <br />
 * Kelas OjeKampus menjalankan method main()
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class OjeKampus
{
    // setiap variabel hanya dapat diakses oleh ojeKampus saja
    // Membuat instance Ojek dengan nama ojek_mas
    private static Ojek ojek_mas;
    // Membuat instance Pelanggan dengan nama p_setiawan
    private static Pelanggan p_setiawan;
    // Membuat instance Lokasi dengan nama per_setiawan_awal
    private static Lokasi per_setiawan_awal;
    // Membuat instance Lokasi dengan nama per_setiawan_akhir
    private static Lokasi per_setiawan_akhir;
    // Membuat instance Pesanan dengan nama pes_setiawan
    private static Pesanan pes_setiawan;
    /**
     * Constructor for objects of class OjeKampus
     */
    public OjeKampus()
    {
        // initialise instance variables
    }

    /**
     * Fungsi utama dari program ojeKampus
     * 
     * @param  args   Array string yang dapat menjadi argumen, default : null
     * @return     none 
     */
    public static void main(String[] args)
    {
        /* 
         * Method main akan menjalankan program dengan melakukan pembuatan masing - masing objek
         * Dalam program ini data dalam database akan ditambahkan objek - objek yang bersangkutan
         * Terdapat perubahan data yang dilakukan oleh objek
         */
        // Pembuatan objek
        ojek_mas = new Ojek(DatabaseUser.getIDOjekTerakhir(), "Mas Eka", new Lokasi("Kota tentram", 14, 06, "Cipocok Jaya, Kota Serang"), (new GregorianCalendar(1997, 05, 12).getTime()), "B123UA");
        p_setiawan = new Pelanggan(DatabaseUser.getIDPelangganTerakhir(), "Setiawan", (new GregorianCalendar(1927, 11, 28).getTime()), "081203040501");
        per_setiawan_awal = new Lokasi("Geffen", 6, 0, "Kota penyihir");
        per_setiawan_akhir = new Lokasi("Morroc", 5, 4, "Kota pencuri");
        pes_setiawan = new Pesanan(p_setiawan, TipeLayanan.ANTAR_BARANG, per_setiawan_awal, per_setiawan_akhir, "Fajri", "Pabe");
        // Penambahan objek ke database
        DatabaseUser.addPelanggan(p_setiawan);
        DatabaseUser.addOjek(ojek_mas);
        DatabasePesanan.addPesanan(pes_setiawan);
        
        //Administrasi.pesananDitugaskan(pes_setiawan, ojek_mas);
        //Administrasi.pesananSelesai(pes_setiawan);
        
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+");
        
        // Menampilakan informasi pada Pelayan
        System.out.printf("%1$te %1$tb,%1$tY\n", ojek_mas.getDOB());
        System.out.printf("%1$te %1$tb,%1$tY\n", p_setiawan.getDOB());
    }
}
