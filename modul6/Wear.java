
/**
 * Interface peralatan untuk Entitas karakter
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.7.6
 */
public interface Wear
{
    public void setWeapon(String name, double dmg);
    
    public void setArmor(String name, double def);
    
    public String getWeapon();
    
    public String getArmor();
    
    public double getWeaponDmg();
    
    public double getArmorDef();
}
