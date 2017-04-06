
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Entity
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Hero
     */
    public Hero(String name, int level)
    {
        // initialise instance variables
        super(name, level);
    }
    
    @Override
    public void quote(){
        System.out.println("La mana ba saka!");
    }
    
    @Override
    public void fullHP(){
        maxHP = (15 * level + 5) / 4;
        strength = (15 * level + 5) / 8;
        setPower();
    }
}
