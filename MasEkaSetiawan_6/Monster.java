package MasEkaSetiawan_6;
/**
 * Class karakter player
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.4.7
 */
public class Monster extends Entity
{
    /**
     * Constructor for objects of class Monster
     */
    public Monster(String name, int level)
    {
        // Melakukan invoke kontruktor dari superclass
        super(name, level);
    }

    /**
     * Method yang menampilkan ucapan unik dari karakter monster
     *
     */
    @Override
    public void quote(){
        // put your code here
        System.out.println("Puka");
    }
    
    /**
     * Method yang menaikan kekuatan dan health dari karakter monster
     *
     */
    @Override
    public void fullHP(){
        maxHP = (level * level / 10) + 5;
        strength = (level * level / 10 + 5) / 2;
        health = maxHP;
        setPower();
    }
}
