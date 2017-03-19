
/**
 * Kelas Pesanan menangani data pesanan yang dibuat akibat user dari sistem ojeKampus
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class Pesanan
{
    // Setiap variabel dan instance variabel hanya dapat diakses oleh class Pesanan saja
    // variabel pelayan merupakan instance dari class Ojek sebagai representasi pengemudi
    private Ojek pelayan = null;
    // variabel pengguna merupakan instance dari class Pengguna sebagai representasi user ojeKampus
    private Pelanggan pengguna;
    // variabel pelangganAwal merupakan representasi dari orang/benda saat ojek menjemput
    private String pelangganAwal;
    // variabel pelangganAkhir merupakan representasi dari orang/benda saat ojek selesai memberikan layanan
    private String pelangganAkhir;
    // variabel biaya nilai harga dari pesanan ojek
    private double biaya;
    // variabel layanan merupakan keterangan tipe layanan 
    private TipeLayanan layanan;
    // variabel lokasiAwal merupakan instance dari class Lokasi sebagai representasi posisi awal user
    private Lokasi lokasiAwal;
    // variabel lokasiAkhir merupakan instance dari class Lokasi sebagai representasi posisi tujuan user
    private Lokasi lokasiAkhir;
    // variabel diproses menentukan apakah pesanan sedang dalam proses atau tidak
    private boolean diproses = false;
    // variabel dibatalkan menentukan apakah pesanan dibatalkan atau tidak
    private boolean selesai = false;
    // variabel dibatalkan menentukan apakah pesanan dibatalkan atau tidak
    private boolean dibatalkan = false;

    /**
     * Kontruktor kelas Pesanan
     * 
     * @param       pengguna        User yang memesan layanan ojek
     * @param       layanan         Tipe layanan yang dipesan
     * @param       lokasiAwal      Lokasi awal pesanan
     * @param       lokasiAkhir     Lokasi tujuan pesanan
     * @param       pelangganAwal   representasi dari orang/benda saat ojek menjemput  
     * @param       pelangganAkhir  representasi dari orang/benda saat ojek selesai memberikan layanan
     * @param       biaya           harga pesanan yang ditawarkan   
     * 
     * @return      none            nothing
     * 
     */
    public Pesanan(Pelanggan pengguna, TipeLayanan layanan, Lokasi lokasiAwal, Lokasi lokasiAkhir, String pelangganAwal)
    {
        /* Konstruktor Pesanan akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Pesanan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // nilai parameter pengguna akan di berikan ke variabel class this.pengguna
        this.pengguna = pengguna;
        // nilai parameter layanan akan di berikan ke variabel class this.layanan
        this.layanan = layanan;
        // nilai parameter lokasiAwal akan di berikan ke variabel class this.lokasiAwal
        this.lokasiAwal = lokasiAwal;
        // nilai parameter lokasiAkhir akan di berikan ke variabel class this.lokasiAkhir
        this.lokasiAkhir = lokasiAkhir;
        // nilai parameter pelangganAwal akan di berikan ke variabel class this.pelangganAwal
        this.pelangganAwal = pelangganAwal;
        //
        this.pelangganAkhir = "";
        //
        this.biaya = 0;
    }
    
    /**
     * Kontruktor kelas Pesanan
     * 
     * @param       pengguna        User yang memesan layanan ojek
     * @param       layanan         Tipe layanan yang dipesan
     * @param       lokasiAwal      Lokasi awal pesanan
     * @param       lokasiAkhir     Lokasi tujuan pesanan
     * @param       pelangganAwal   representasi dari orang/benda saat ojek menjemput  
     * @param       pelangganAkhir  representasi dari orang/benda saat ojek selesai memberikan layanan
     * @param       biaya           harga pesanan yang ditawarkan   
     * 
     * @return      none            nothing
     * 
     */
    public Pesanan(Pelanggan pengguna, TipeLayanan layanan, Lokasi lokasiAwal, Lokasi lokasiAkhir, String pelangganAwal, String pelangganAkhir)
    {
        /* Konstruktor Pesanan akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Pesanan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // nilai parameter pengguna akan di berikan ke variabel class this.pengguna
        this.pengguna = pengguna;
        // nilai parameter layanan akan di berikan ke variabel class this.layanan
        this.layanan = layanan;
        // nilai parameter lokasiAwal akan di berikan ke variabel class this.lokasiAwal
        this.lokasiAwal = lokasiAwal;
        // nilai parameter lokasiAkhir akan di berikan ke variabel class this.lokasiAkhir
        this.lokasiAkhir = lokasiAkhir;
        // nilai parameter pelangganAwal akan di berikan ke variabel class this.pelangganAwal
        this.pelangganAwal = pelangganAwal;
        // nilai parameter pelangganAkhir akan di berikan ke variabel class this.pelangganAkhir
        this.pelangganAkhir = pelangganAkhir;
        //
        this.biaya = 0;
    }
    
    /**
     * Kontruktor kelas Pesanan
     * 
     * @param       pengguna        User yang memesan layanan ojek
     * @param       layanan         Tipe layanan yang dipesan
     * @param       lokasiAwal      Lokasi awal pesanan
     * @param       lokasiAkhir     Lokasi tujuan pesanan
     * @param       pelangganAwal   representasi dari orang/benda saat ojek menjemput  
     * @param       pelangganAkhir  representasi dari orang/benda saat ojek selesai memberikan layanan
     * @param       biaya           harga pesanan yang ditawarkan   
     * 
     * @return      none            nothing
     * 
     */
    public Pesanan(Pelanggan pengguna, TipeLayanan layanan, Lokasi lokasiAwal, Lokasi lokasiAkhir, String pelangganAwal, String pelangganAkhir, double biaya)
    {
        /* Konstruktor Pesanan akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Pesanan dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */
        // nilai parameter pengguna akan di berikan ke variabel class this.pengguna
        this.pengguna = pengguna;
        // nilai parameter layanan akan di berikan ke variabel class this.layanan
        this.layanan = layanan;
        // nilai parameter lokasiAwal akan di berikan ke variabel class this.lokasiAwal
        this.lokasiAwal = lokasiAwal;
        // nilai parameter lokasiAkhir akan di berikan ke variabel class this.lokasiAkhir
        this.lokasiAkhir = lokasiAkhir;
        // nilai parameter pelangganAwal akan di berikan ke variabel class this.pelangganAwal
        this.pelangganAwal = pelangganAwal;
        // nilai parameter pelangganAkhir akan di berikan ke variabel class this.pelangganAkhir
        this.pelangganAkhir = pelangganAkhir;
        // nilai parameter biaya akan di berikan ke variabel class this.biaya
        this.biaya = biaya;
    }

    /**
     * Getter status dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      Boolean         false
     * 
     */
    public boolean getStatusPesanan()
    {
        /* 
         * Method ini memberikan informasi mengenai status dari pesanan 
         */
        return false;
    }

    /**
     * Getter status dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      Boolean         false
     * 
     */
    public boolean getStatusDiproses()
    {
        /* 
         * Method ini memberikan informasi mengenai status dari pesanan 
         */
        return diproses;
    }
    
    /**
     * Getter status dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      Boolean         false
     * 
     */
    public boolean getStatusSelesai()
    {
        /* 
         * Method ini memberikan informasi mengenai status dari pesanan 
         */
        return selesai;
    }
    
    /**
     * Melakukan reserve dari permintaan pesanan yang dilakukan oleh ojek
     * 
     * @param       pelayan         instance dari class Ojek sebagai representasi pengemudi 
     * 
     * @return      none            nothing
     * 
     */
    public void pesananDiambil(Ojek pelayan)
    {
        /* 
         * Melakukan reserve dari permintaan pesanan yang dilakukan oleh ojek 
         */
    }
    
    /**
     * Getter pelanggan dari instance pengguna
     * 
     * @param       none            nothing 
     * 
     * @return      pengguna        instance dari class Pengguna sebagai representasi user ojeKampus
     * 
     */
    public Pelanggan getPelanggan()
    {
        /* 
         * Method ini mengembalikan instance Pelanggan dari pesanan 
         */
        return pengguna;
    }
    
    /**
     * Getter ojek dari instance pelayan
     * 
     * @param       none            nothing 
     * 
     * @return      pelayan         instance dari class Ojek sebagai representasi pengemudi
     * 
     */
    public Ojek getPelayan()
    {
        /* 
         * Method ini mengembalikan instance Ojek dari pesanan 
         */
        return pelayan;
    }
    
    /**
     * Pembatalan pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      none            nothing
     * 
     */
    public void pesananDibatalkan()
    {
        /* 
         * Method ini melakukan pembatalan pesanan
         * variabel dibatalkan akan dirubah nilainya menjadi true
         */
    }
    
    /**
     * Getter LokasiAwal dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      lokasiAwal      Lokasi awal pesanan
     * 
     */
    public Lokasi getLokasiAwal()
    {
        /* 
         * Method ini mengembalikan instance Lokasi dari pesanan sebagai representasi posisi awal pesanan
         */
        return lokasiAwal;
    }
    
    /**
     * Getter LokasiAwal dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      lokasiAwal      Lokasi akhir pesanan
     * 
     */
    public Lokasi getLokasiAkhir()
    {
        /* 
         * Method ini mengembalikan instance Lokasi dari pesanan sebagai representasi posisi akhir pesanan
         */
        return lokasiAkhir;
    }
    
    /**
     * Getter layanan dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      layanan         Tipe layanan yang dipesan
     * 
     */
    public TipeLayanan getTipeLayanan()
    {
        /* 
         * Method ini mengembalikan tipe layanan dari pesanan
         * Apakah itu antarBarang, antarOrang, atau beliBarang  
         */
        return layanan;
    }
    
    /**
     * Getter pengguna awal dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      pelangganAwal   representasi dari orang/benda saat ojek menjemput
     * 
     */
    public String getPenggunaAwal()
    {
        /* 
         * Method ini mengembalikan string pengguna awal dari pesanan  
         */
        return pelangganAwal;
    }
    
    /**
     * Getter pengguna akhir dari pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      pelangganAkhir   representasi dari orang/benda saat ojek selesai memberikan layanan
     * 
     */
    public String getPenggunaAkhir()
    {
        /* 
         * Method ini mengembalikan string pengguna akhir dari pesanan  
         */
        return pelangganAkhir;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public double getBiaya()
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        return biaya;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setPelayan(Ojek pelayan)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.pelayan = pelayan;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setPelanggan(Pelanggan pengguna)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.pengguna = pengguna;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setPenggunaAwal(String pelangganAwal)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.pelangganAwal = pelangganAwal;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setPenggunaAkhir(String pelangganAkhir)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.pelangganAkhir = pelangganAkhir;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setBiaya(double biaya)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.biaya = biaya;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setTipeLayanan(TipeLayanan layanan)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.layanan = layanan;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setLokasiAwal(Lokasi lokasiAwal)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.lokasiAwal = lokasiAwal;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setLokasiAkhir(Lokasi lokasiAkhir)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.lokasiAkhir = lokasiAkhir;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setStatusDiproses(Boolean diproses)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.diproses = diproses;
    }
    
    /**
     * Getter biaya pesanan
     * 
     * @param       none            nothing 
     * 
     * @return      biaya           nilai harga dari pesanan ojek
     * 
     */
    public void setStatusSelesai(Boolean selesai)
    {
        /* 
         * Method ini mengembalikan nilai biaya dari pesanan  
         */
        this.selesai = selesai;
    }
    
    /**
     * Method ini menampilkan nama lokasi awal, nama lokasi akhir dan tipe layanan
     * 
     * @param        none           nothing
     * @return       none 
     */
    public String toString()
    {
        /*
         * Method ini menampilkan nama lokasi awal, nama lokasi akhir dan tipe layanan 
         */
        String final_status = "KOSONG";
        // 
        /*System.out.println("Nama pelanggan awal : " + pelangganAwal);
        //
        System.out.println("Nama pelanggan akhir : " + pelangganAkhir);
        // method dari instance lokasiAwal akan mengembalikan nama lokasi sebagai input argumen dari method print
        System.out.println("Lokasi pelanggan awal : " + lokasiAwal.getNama());
        // method dari instance lokasiAkhir akan mengembalikan nama lokasi sebagai input argumen dari method print
        System.out.println("Lokasi pelanggan akhir : " + lokasiAkhir.getNama());
        // variabel layanan akan memberikan nilai tipe layanan yang digunakan
        System.out.println("Tipe layanan : " + layanan);
        //
        if(getStatusSelesai()){
            System.out.println("[+] Pesanan sudah selesai");
        } else if(getStatusDiproses()){
            System.out.println("[+] Pesanan sedang diproses");
        }
        return "";*/
        if(getStatusDiproses() == true && getStatusSelesai() == false){
            final_status = "DIPROSES";
        } else if(getStatusDiproses() == false && getStatusSelesai() == false){
            final_status = "KOSONG";
        } else if(getStatusDiproses() == false && getStatusSelesai() == true){
            final_status = "SELESAI";
        }
        
        if(pelayan == null){
            if(!getPenggunaAkhir().isEmpty()){
                return "Dibuat oleh " + pengguna.getNama() + '\n' + "untuk " + getPenggunaAwal() + " di " + getLokasiAwal().getNama() + " ke " + getPenggunaAkhir() + " di " + getLokasiAkhir().getNama() + " dengan layanan " + getTipeLayanan() + " status " + final_status + "||\n";
            } else {
                return "Dibuat oleh " + pengguna.getNama() + '\n' + "untuk " + getPenggunaAwal() + " di " + getLokasiAwal().getNama() + " ke " + getLokasiAkhir().getNama() + " dengan layanan " + getTipeLayanan() + " status " + final_status + "||\n";
            }
        } else {
            if(!getPenggunaAkhir().isEmpty()){
                return "Dibuat oleh " + pengguna.getNama() + '\n' + "untuk " + getPenggunaAwal() + " di " + getLokasiAwal().getNama() + " ke " + getPenggunaAkhir() + " di " + getLokasiAkhir().getNama() + " dengan layanan " + getTipeLayanan() + " status " + final_status + "||\n" + "Diproses oleh " + getPelayan().getNama() + '\n';
            } else {
                return "Dibuat oleh " + pengguna.getNama() + '\n' + "untuk " + getPenggunaAwal() + " di " + getLokasiAwal().getNama() + " ke " + getLokasiAkhir().getNama() + " dengan layanan " + getTipeLayanan() + " status " + final_status + "||\n" + "Diproses oleh " + getPelayan().getNama() + '\n';
            }
        }
    }
}
