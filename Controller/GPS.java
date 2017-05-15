package Controller;

import Model.Lokasi;
import java.util.Random;
/**
 * Write a description of class GPS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GPS
{
    // instance variables - replace the example below with your own
    Lokasi lokasi;
    Random rand = new Random();
    /**
     * Constructor for objects of class GPS
     */
    public GPS()
    {
        // initialise instance variables
        this.lokasi = new Lokasi("Indonesia", rand.nextInt((250 - 0) + 0), rand.nextInt((250 - 0) + 0), "");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void updateData()
    {
        // put your code here
        this.lokasi.setX(rand.nextInt((250 - 0) + 0));
        this.lokasi.setY(rand.nextInt((250 - 0) + 0));
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Lokasi getData()
    {
        // put your code here
        return lokasi;
    }
}
