
/**
 * Write a description of class PesananOlehPelangganDitemukanException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PesananOlehOjekTidakDitemukanException extends Exception
{
    // instance variables - replace the example below with your own
    private Ojek pelayanError;

    /**
     * Constructor for objects of class PesananOlehPelangganDitemukanException
     */
    public PesananOlehOjekTidakDitemukanException(Ojek pelayanInput)
    {
        // initialise instance variables
        super("Pesanan untuk ");
        this.pelayanError = pelayanInput;
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
        return super.getMessage() + this.pelayanError.getNama() + " tidak ditemukan";
    }
}
