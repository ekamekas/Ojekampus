
/**
 * Abstract class Entity - Perilaku dari sebuah karakter
 * 
 * @author Mas Eka Setiawan
 * @version 2017.4.7
 */
public abstract class Entity implements Wear
{
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
     * Konstruktor dari sebuah kelas
     * 
     * @param  name    Nama dari sebuah entitas
     * @param  level    Level dari sebuah entitas
     */
    public Entity(String name, int level)
    {
        this.name = name;
        this.level = level;
        fullHP();
    }
    
    /**
     * Method menaikan level dari karakter
     * 
     */
    protected void levelUp(){
        level = level + 1;
        fullHP();
    }
    
    /**
     * Method kalkualasi health karakter
     * 
     * @param  diff    Selisih health akibat pertempuran
     */
    protected void setHP(double diff){
        health = health - (int)diff;
        if(health <= 0)
            dead = true;
    }
    
    /**
     * Method kalkulasi serangan yang diberikan karakter
     * 
     * @param  def    Defensif dari karkater oposisi
     * @param  opRank    Nilai rank dari karakter oposisi
     * 
     * @return          Damage dari karakter
     */
    protected int getDamage(double def, double opRank){
        int damage = 1;
        damage = (int)((1 + ((2 * level) / 5 + 2 ) * rank.getAttackPower() * (weaponDmg/def) / 50) * rank.getRank() * opRank);
        return damage;
    }
    
    /**
     * Method untuk set kekuatan karakter
     * 
     */
    protected void setPower(){
        attack = strength * (1 + (weaponDmg / 100));
        defense = strength * (1 + (armorDef / 100));
    }
    
    /**
     * Method getter nama karakter
     * 
     * @return      Nama karakter
     */
    protected String getName(){
        return name;
    }
    
    /**
     * Method getter level karakter
     * 
     * @return      level karakter
     */
    protected int getLevel(){
        return level;
    }
    
    /**
     * Method getter health karakter
     * 
     * @return      health dari karakter
     */
    protected int getHP(){
        return health;
    }
    
    /**
     * Method getter status karakter
     * 
     * @return      Status kehidupan karakter
     */
    protected boolean isDead(){
        return dead;
    }
    
    /**
     * Method setter Rank karakter
     * 
     * @param  rank    Rank dari sebuah karakter
     */
    protected void setRank(Rank rank){
        this.rank = rank;
    }
    
    /**
     * Method getter Rank karakter
     * 
     * @return      Rank dari sebuah karakter
     */
    protected Rank getRank(){
        return rank;
    }
    
    /**
     * Method getter kekuatan serangan karkater
     * 
     * @return      Kekuatan serangan karakter
     */
    protected double getAttack(){
        return attack;
    }
    
    /**
     * Method getter kekuatan defensif karakter
     * 
     * @return      Kekuatan defensif karakter
     */
    protected double getDefense(){
        return defense;
    }
    
    /**
     * Method override set senjata
     * 
     * @param  name    Nama dari sebuah senjata entitas
     * @param  dmg    Serangan dari sebuah senjata entitas
     */
    @Override
    public void setWeapon(String name, double dmg){
        this.weapon = name;
        this.weaponDmg = dmg;
        setPower();
    }
    
    /**
     * Method override getter senjata
     * 
     * @return      Senjata dari karakter
     */
    @Override
    public String getWeapon(){
        return weapon;
    }
    
    /**
     * Method override set armor
     * 
     * @param  name    Nama dari sebuah armor entitas
     * @param  dmg    Defensif dari sebuah armor entitas
     */
    @Override
    public void setArmor(String name, double def){
        this.armor = name;
        this.armorDef = def;
        setPower();
    }
    
    /**
     * Method override getter armor
     * 
     * @return  Armor dari karakter
     */
    @Override
    public String getArmor(){
        return armor;
    }
    
    /**
     * Method override getter serangan senjata
     * 
     * @return  Serangan senjata dari karakter
     */
    @Override
    public double getWeaponDmg(){
        return weaponDmg;
    }
    
    /**
     * Method override getter defensif armor
     * 
     * @return  defensif armor dari karakter
     */
    @Override
    public double getArmorDef(){
        return armorDef;
    }
    
    /**
     * Method abstract
     * 
     */
    protected abstract void fullHP();
    
    /**
     * Method abstract
     * 
     */
    protected abstract void quote();
}
