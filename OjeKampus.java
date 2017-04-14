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
        registrasiOjek();
        registrasiPengguna();
//         beliBarang(DatabaseUser.getPelangganDatabase().get(0));
//         antarBarang(DatabaseUser.getPelangganDatabase().get(1));
        antarOrang(DatabaseUser.getPelangganDatabase().get(2));
        antarOrang(DatabaseUser.getPelangganDatabase().get(2));
        Administrasi.jalankanSistemPenugas();
//         Administrasi.jalankanSistemPenugas();
//         Administrasi.jalankanSistemPenugas();
//         System.out.println("Pengguna Membatalkan :");
//         Administrasi.printAllDatabase();
//         
//         penggunaMembatalkan(DatabaseUser.getPelangganDatabase().get(0));
//         System.out.println("Ojek Membatalkan :");
//         Administrasi.printAllDatabase();
//         
//         ojekMembatalkan(DatabasePesanan.getPesanan(DatabaseUser.getPelangganDatabase().get(1)).getPelayan());
//         System.out.println("Pengguna Membatalkan :");
//         Administrasi.printAllDatabase();
//         
//         ojekMengubahStatus(DatabasePesanan.getPesanan(DatabaseUser.getPelangganDatabase().get(2)).getPelayan());
//         System.out.println("Ojek Ubah Status :");
//         Administrasi.printAllDatabase();
//         
//         penggunaMenyelesaikanPesanan(DatabaseUser.getPelangganDatabase().get(2));
//         System.out.println("Pengguna Pesanan Selesai :");
//         Administrasi.printAllDatabase();
        
        penggunaMenghapusPesanan(DatabaseUser.getPelangganDatabase().get(2));
        penggunaMenghapusPesanan(DatabaseUser.getPelangganDatabase().get(2));
//         System.out.println("Pengguna Pesanan Selesai :");
//         Administrasi.printAllDatabase();
    }
    
    public static void antarBarang(Pelanggan pengguna){
        try {
            DatabasePesanan.addPesanan(new Pesanan(pengguna, TipeLayanan.ANTAR_BARANG, new Lokasi("Kampus UI", 33, 20, "Depok"), new Lokasi("Asrama Mahasiswa UI", 32, 11, "Lingkungan Kampus UI"), pengguna.getNama(), "Faris Abdurrahman Pabe"));
        } catch(PesananSudahAdaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void antarOrang(Pelanggan pengguna){
        try {
            DatabasePesanan.addPesanan(new Pesanan(pengguna, TipeLayanan.ANTAR_ORANG, new Lokasi("Asrama Mahasiswa UI", 32, 11, "Lingkungan Kampus UI"), new Lokasi("Kampus UI", 33, 20, "Depok"), pengguna.getNama()));
        } catch(PesananSudahAdaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void beliBarang(Pelanggan pengguna){
        try { DatabasePesanan.addPesanan(new Pesanan(pengguna, TipeLayanan.BELI_BARANG, new Lokasi("Go Satellite Showroom", 101, 202, "Satellite Coverage, Broadband Speed"), new Lokasi("Asrama Mahasiswa UI", 32, 11, "Lingkungan Kampus UI"), pengguna.getNama()));
        } catch(PesananSudahAdaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void ojekMembatalkan(Ojek pelayan){
        Administrasi.pesananDibatalkan(pelayan);
    }
    
    public static void ojekMengubahStatus(Ojek pelayan){
        pelayan.setStatus(StatusOjek.ANTAR);
    }
    
    public static void pembelianBarang(){
        
    }
    
    public static void penggunaMembatalkan(Pelanggan pengguna){
        Administrasi.pesananDibatalkan(pengguna);
    }
    
    public static void penggunaMenghapusPesanan(Pelanggan pengguna){
        try {
            DatabasePesanan.hapusPesanan(pengguna);
        } catch(PesananOlehPelangganTidakDitemukanException e) {
            System.out.println(e.getMessage());
        }
    }
            
    public static void penggunaMenyelesaikanPesanan(Pelanggan pengguna){
        Administrasi.pesananSelesai(pengguna);
    }
    
    public static void registrasiOjek(){
        DatabaseUser.addOjek(new Ojek(DatabaseUser.getIDOjekTerakhir(), "Mas Eka", new Lokasi("Komplek Pemda", 14, 06, "Cipocok Jaya, Kota Serang")));
        DatabaseUser.addOjek(new Ojek(DatabaseUser.getIDOjekTerakhir(), "Fajri", new Lokasi("Kost Andalas", 14, 06, "Kutek, Depok")));
        DatabaseUser.addOjek(new Ojek(DatabaseUser.getIDOjekTerakhir(), "Faris Abdurrahman", new Lokasi("Bogor", 14, 06, "Kota Hujan")));
    }
    
    public static void registrasiPengguna(){
        DatabaseUser.addPelanggan(new Pelanggan(DatabaseUser.getIDPelangganTerakhir(), "Setiawan", "081203040501"));
        DatabaseUser.addPelanggan(new Pelanggan(DatabaseUser.getIDPelangganTerakhir(), "Rahmadi", "0812847428484"));
        DatabaseUser.addPelanggan(new Pelanggan(DatabaseUser.getIDPelangganTerakhir(), "Pabe", "0823239389838"));
    }
}
