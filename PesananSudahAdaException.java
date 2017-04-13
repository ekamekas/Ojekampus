
/**
 * Write a description of class PesananSudahAdaException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PesananSudahAdaException extends Exception
{
    // instance variables - replace the example below with your own
    private Pesanan pesananError;

    /**
     * Constructor for objects of class PesananSudahAdaException
     */
    public PesananSudahAdaException(Pesanan pesananInput)
    {
        // initialise instance variables
        super("Pelanggan dengan nama ");
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
        return super.getMessage() + this.pesananError.getPelanggan().getNama() + " sudah melakukan pemesanan dengan tipe layanan " + this.pesananError.getTipeLayanan();
    }
}
