package MasEkaSetiawan_6;
/**
 * Class yang implementasikan Rank
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.4.6
 */
public class Damager implements Rank
{
    // instance variables - replace the example below with your own
    private String attackName;
    private int attackPower;
    private static double rank = 1.25;

    /**
     * Constructor for objects of class Damager
     */
    public Damager(String name, int power)
    {
        // initialise instance variables
        attackName = name;
        attackPower = power;
    }

    /**
     * Method setter kekuatan
     * 
     * @param  name   Nama Serangan 
     */
    public void setAttackName(String name){
        // put your code here
        attackName = name;
    }
    
    /**
     * Method setter kekuatan
     * 
     * @param  power   Kekuatan 
     */
    public void setAttackPower(int power){
        // put your code here
        attackPower = power;
    }
    
    /**
     * Method getter nama Serangan
     * 
     * @return  Nama Serangan 
     */
    public String getAttackName(){
        // put your code here
        return attackName;
    }
    
    /**
     * Method getter kekuatan
     * 
     * @return  Kekuatan 
     */
    public int getAttackPower(){
        // put your code here
        return attackPower;
    }
    
    /**
     * Method getter nilai rank
     * 
     * @return  Nilai rank 
     */
    public double getRank(){
        // put your code here
        return rank;
    }
}
