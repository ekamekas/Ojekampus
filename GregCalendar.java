import java.util.GregorianCalendar;
import java.util.Date;
/**
 * Write a description of class GregorianCalendar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GregCalendar
{
    // instance variables - replace the example below with your own
    
    public static Date calendar;
    
    /**
     * Constructor for objects of class GregorianCalendar
     */
    public GregCalendar(int tahun, int bulan, int hari)
    {
        // initialise instance variables
        calendar = new GregorianCalendar(tahun, bulan-1, hari).getTime();
    }
}
