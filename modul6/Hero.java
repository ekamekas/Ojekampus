
/**
 * Class karakter player
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.4.7
 */
public class Hero extends Entity
{
    /**
     * Constructor for objects of class Monster
     */
    public Hero(String name, int level)
    {
        // initialise instance variables
        super(name, level);
    }
    
    /**
     * Method yang menampilkan ucapan unik dari karakter hero
     *
     */
    @Override
    public void quote(){
        System.out.println("La mana ba saka!");
    }
    
    /**
     * Method yang menaikan kekuatan dan health dari karakter hero
     *
     */
    @Override
    public void fullHP(){
        super.maxHP = (15 * level + 5) / 4;
        super.strength = (15 * level + 5) / 8;
        health = maxHP;
        setPower();
    }
}
