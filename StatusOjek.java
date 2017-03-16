
/**
 * Write a description of class StatusOjek here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum StatusOjek
{
    // instance variables - replace the example below with your own
    ANTAR("Mengantar"),
    IDLE("Idle"),
    JEMPUT("Menjemput");
    
    private String deskripsi;

    /**
     * Constructor for objects of class StatusOjek
     */
    StatusOjek(String deskripsi)
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
