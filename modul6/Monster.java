
/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Entity
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Monster
     */
    public Monster(String name, int level)
    {
        // initialise instance variables
        super(name, level);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public void quote(){
        // put your code here
        
    }
    
    @Override
    public void fullHP(){
        maxHP = level * level / 10 + 5;
        strength = (level * level / 10 + 5) / 2;
        setPower();
    }
}
