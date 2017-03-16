
/**
 * Write a description of class TipeLayanan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum TipeLayanan
{
    // instance variables - replace the example below with your own
    ANTAR_ORANG("Antar Orang"),
    ANTAR_BARANG("Antar Barang"),
    BELI_BARANG("Beli Barang");
        
    private String deskripsi;

    /**
     * Constructor for objects of class TipeLayanan
     */
    TipeLayanan(String deskripsi)
    {
        // initialise instance variables
        this.deskripsi = deskripsi;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String toString()
    {
        // put your code here
        return deskripsi;
    }
}
