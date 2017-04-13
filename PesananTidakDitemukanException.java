
/**
 * Write a description of class PesananTidakDitemukanException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PesananTidakDitemukanException extends Exception
{
    // instance variables - replace the example below with your own
    
    private Pesanan pesananError;
    
    /**
     * Constructor for objects of class PesananTidakDitemukanException
     */
    public PesananTidakDitemukanException(Pesanan pesananInput)
    {
        // initialise instance variables
        super("Pesanan yang dipesan oleh ");
        this.pesananError = pesananInput;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public String getMessage()
    {
        // put your code here
        return super.getMessage() + this.pesananError.getPelanggan().getNama() + " tidak ditemukan";
    }
}
