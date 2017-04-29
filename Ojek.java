import java.util.regex.*;
import java.util.Date;

/**
 * Kelas Ojek menangani data ojek dari sistem ojeKampus
 * <br />
 * Kelas Ojek membuat instance dari kelas Lokasi untuk menentukan posisi driver
 * <br />
 * Kelas Ojek membuat instance dari kelas Pesanan untuk menentukan informasi pesanan oleh user
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.3
 */
public class Ojek extends User
{
    // setiap variabel hanya dapat diakses oleh Ojek saja
    // status menentukan apakah ojek sudah di-book atau tidak
    private StatusOjek status = StatusOjek.IDLE;
    // posisiSekarang merepresentasikan lokasi ojek saat ini
    private Lokasi posisiSekarang;
    // pesanan_sekarang menyimpan informasi pesanan yang sedang diambil oleh ojek
    private Pesanan pesanan_sekarang = null;
    
    private String noPlat;

    /**
     * Kontruktor kelas ojek
     * 
     * @param       id              nomor identitas pengemudi ojek
     * @param       nama            Nama pengemudi ojek
     * @param       posisiSekarang  Lokasi pengemudi sekarang
     * 
     * @return      none            nothing
     * 
     */
    public Ojek(int id, String nama, Lokasi posisiSekarang)
    {
        /* Konstruktor Ojek akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Ojek dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */ 
        // this.id merupaakan nomor identitas yang merepresentasikan ojek
        super.id = id;
        // this.nama merupakan nama dari ojek
        super.nama = nama;
        // this.posisiSekarang merupaakan instance variabel dari kelas Lokasi yang merepresentasikan posisi ojek saat ini
        this.posisiSekarang = posisiSekarang;
    }
    
    public Ojek(int id, String nama, String telefon, String email, Date date, String noPlat, Lokasi posisiSekarang)
    {
        /* Konstruktor Ojek akan berperan sebagai inisiasi variabel dan instance Lokasi ketika Objek Ojek dibuat
         * Konstrukter akan melakukan inisiasi nilai variabel class dengan nilai parameter
         * Setiap parameter harus diisi dengan nilai paling tidak null atau 0
         * Setiap parameter akan memberikan nilai ke field class akesor private
         */ 
        // this.id merupaakan nomor identitas yang merepresentasikan ojek
        super.id = id;
        // this.nama merupakan nama dari ojek
        super.nama = nama;
        //
        super.telefon = telefon;
        super.email = email;
        super.dob = date;
        //
        this.noPlat = noPlat;

        // this.posisiSekarang merupaakan instance variabel dari kelas Lokasi yang merepresentasikan posisi ojek saat ini
        this.posisiSekarang = posisiSekarang;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public String getNoPlat()
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        return noPlat;
    }
    
    /**
     * Getter pesanan untuk pengemudi ojek
     * 
     * @param       none              nothing
     * @return      pesanan_sekarang  mengembalikan nilai objek Pesanan 
     */
    public Pesanan getPesanan()
    {
        // Method ini akan mengembalikan nilai instance variabel class pesanan_sekarang 
        return pesanan_sekarang;
    }
    
    /**
     * Getter lokasi sekarang pengemudi ojek
     * 
     * @param       none            nothing
     * @return      posisiSekarang  mengembalikan Objek Lokasi yang memiliki informasi posisi pengemudi ojek sekarang 
     */
    public Lokasi getPosisi()
    {
        // Method ini akan mengembalikan nilai instance variabel class posisiSekarang 
        return posisiSekarang;
    }
    
    /**
     * Getter status dari ojek
     * 
     * @param       none            nothing
     * @return      status          mengembalikan kondisi status dari pengemudi ojek
     */
    public StatusOjek getStatus()
    {
        // Method ini akan mengembalikan nilai variabel class status 
        return status;
    }
    
    /**
     * Setter nama pengemudi ojek
     * 
     * @param       nama            nama pengemudi yang akan diset
     * @return      none            nothing 
     */
    public boolean setNoPlat(String noPlat)
    {
        /* 
         * Method ini akan mem-passing parameter nama ke variabel nama
         * Nilai dari variabel class nama akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // this.nama merupakan penamaan alternatif dari variabel class nama 
        Pattern pattern = Pattern.compile("[A-Z]{1,2}[0-9]{1,4}[A-Z]{1,2}");
        Matcher matcher = pattern.matcher(noPlat);
        if(matcher.matches()){
            this.noPlat = noPlat;
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Setter pesanan untuk pengemudi ojek
     * 
     * @param       pesan           Objek Pesanan yang diset
     * @return      none            nothing 
     */
    public void setPesanan(Pesanan pesan)
    {
        /* 
         * Method ini akan mem-passing parameter pesan ke variabel instance Pesanan
         * Nilai dari variabel class pesanan_sekarang akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // pesan_sekarang merupakan instance dari objek Pesanan yang merepresentasikan pesanan ojek sekarang 
        pesanan_sekarang = pesan;
    }
    
    /**
     * Setter lokasi sekarang pengemudi ojek
     * 
     * @param       sekarang        Objek Lokasi untuk informasi posisi
     * @return      none            nothing 
     */
    public void setPosisi(Lokasi sekarang)
    {
        /* 
         * Method ini akan mem-passing parameter sekarang ke variabel instance Lokasi posisiSekarang
         * Nilai dari variabel class posisiSekarang akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        // posisiSekarang merupakan instance dari objek Lokasi yang merepresentasikan posisi ojek sekarang 
        posisiSekarang = sekarang;
    }
    
    /**
     * Setter status pengemudi ojek
     * 
     * @param       status          Status pengemudi ojek
     * @return      none            nothing 
     */
    public void setStatus(StatusOjek status)
    {
        /* 
         * Method ini akan mem-passing parameter status ke variabel status
         * Nilai dari variabel class posisiSekarang akan dirubah oleh nilai apapun yang di pass lewat parameter
         */
        this.status = status;
    }   
    
    /**
     * Print informasi identitas, nama, dan status dari ojek
     * 
     * @param        none           nothing
     * @return       none 
     */
    public String toString()
    {
        /*
         * Method ini menampilkan nomor identitas, nama dan status dari 
         */
        // this.id adalah variabel class yang menyimpan nomor identitas ojek
        if(pesanan_sekarang == null){
            return "Nama Ojek : " + getNama() + '\n' + "ID : " + getID() + '\n' + "Plat : " + getNoPlat() + '\n' + "Status : " + getStatus() + '\n';
        } else {
            return "Nama Ojek : " + getNama() + '\n' + "ID : " + getID() + '\n' + "Plat : " + getNoPlat() + '\n' + "Status : " + getStatus() + '\n' + "Nama Pelanggan : " + pesanan_sekarang.getPelanggan().getNama() + '\n';
        }
    }
}
