
/**
 * Abstract class Entity - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Entity implements Wear
{
    // instance variables - replace the example below with your own
    protected String name;
    protected String weapon;
    protected String armor;
    protected int level;
    protected int health;
    protected int maxHP;
    protected int strength;
    protected double weaponDmg;
    protected double armorDef;
    protected double attack;
    protected double defense;
    protected boolean dead;
    protected Rank rank;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Entity(String name, int level)
    {
        // put your code here
        fullHP();
    }
    
    protected void levelUp(){
        level = level + 1;
        fullHP();
    }
    
    protected void setHP(double diff){
        health = health - (int)diff;
        if(health <= 0)
            dead = true;
    }
    
    protected int getDamage(double def, double opRank){
        int damage = 1;
        damage = (int)((1 + ((2 * level) / 5 + 2 ) * rank.getAttackPower() * (weaponDmg/def) / 50) * rank.getRank() * opRank);
        return damage;
    }
    
    protected void setPower(){
        attack = strength * (1 + (weaponDmg / 100));
        defense = strength * (1 + (armorDef / 100));
    }
    
    protected String getName(){
        return name;
    }
    
    protected int getLevel(){
        return level;
    }
    
    protected int getHP(){
        return health;
    }
    
    protected boolean isDead(){
        return dead;
    }
    
    protected void setRank(Rank rank){
        this.rank = rank;
    }
    
    protected Rank getRank(){
        return rank;
    }
    
    protected double getAttack(){
        return attack;
    }
    
    protected double getDefense(){
        return defense;
    }
    
    @Override
    public void setWeapon(String name, double dmg){
        this.name = name;
        this.weaponDmg = dmg;
        setPower();
    }
    
    @Override
    public String getWeapon(){
        return weapon;
    }
    
    @Override
    public void setArmor(String name, double def){
        this.name = name;
        this.armorDef = def;
        setPower();
    }
    
    @Override
    public String getArmor(){
        return armor;
    }
    
    @Override
    public double getWeaponDmg(){
        return 0.0;
    }
    
    @Override
    public double getArmorDef(){
        return 0.0;
    }
    
    protected abstract void fullHP();
    
    protected abstract void quote();
}
