package Controller;

/**
 * Enumeration class ConnectionCommand - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ConnectionCommand
{
    LOGIN("Login"),
    LOGOUT("Logout"),
    REGISTER("Register"),
    PENGGUNA("Pengguna"),
    OJEK("Ojek"),
    PESANAN("Pesanan"),
    PESAN("Pesan"),
    AMBIL("Ambil"),
    TOLAK("Tolak"),
    BATAL("Batal"),
    SELESAI("Selesai"),
    HAPUS("Hapus"),
    UNKNOWN("Lain"),;
    
    private String deskripsi;
    
    ConnectionCommand(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    @Override
    public String toString(){
        return deskripsi;
    }
}
