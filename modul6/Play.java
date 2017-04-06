import java.util.Random;

/**
 * Class yang digunakan untuk menjalankan permainan
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.4.7
 */
public class Play
{
    // instance variables - replace the example below with your own
    private Hero player;
    private Monster enemy;
    private Random rand;
    private int enemyCount;

    /**
     * Constructor for objects of class Play
     */
    private Play()
    {
         initialize();

         System.out.println("War start!");
        
         for (int i = 1; !player.isDead(); i++)
         {
             print(i);
             System.out.println("\nHero = " + player.getName() + ", level = " + player.getLevel() + "\nEnemy = " + enemy.getName() + ", level = " + player.getLevel());
             if (enemy.isDead())
             {
                 System.out.println("Enemy died! Spawning new enemy!");
                 player.levelUp();
                 enemyCount = enemyCount + 1;
                 initializeEnemy();
                 System.out.println("Player level up! Level = " + player.getLevel());
             }
         }
        
         System.out.println("Hero mati pada level " + player.getLevel());
    }

    /**
     * Insialisasi objek player permainan
     * 
     */
    private void initialize()
    {
        rand = new Random();
        player = new Hero("Electron", 1);
        player.setRank(setRank("Small Mass", 30));
        player.setWeapon("Negative Charge", 20.0);
        player.setArmor("Negative Cloak", 25.0);
        enemyCount = 1;
        initializeEnemy();
    }
    
    /**
     * Insialisasi objek musuh permainan
     * 
     */
    private void initializeEnemy(){
            enemy = new Monster("Poring", enemyCount);
            enemy.setRank(setRank("Small Mass", rand.nextInt(100 - 50) + 50));
            enemy.setWeapon("Knive", rand.nextInt(25 - 5) + 5);
            enemy.setArmor("Hat", rand.nextInt(25 - 5) + 5);
    }

    /**
     * Display permainan dan mekanisme pergantian
     * 
     * @param i nilai ronde
     */
    private void print(int i){
        Entity attacker, defender;
        System.out.println("\nRound = " + i + "\nKill count = " + (enemyCount - 1) + "\nHero health = " + player.getHP() + ", Enemy health = " + enemy.getHP());
        if(i % 2 != 0){
            attacker = player;
            defender = enemy;
        } else {
            attacker = enemy;
            defender = player;
        }
        attacker.quote();
        attackTurn(attacker, defender);
    }
    
    /**
     * Method untuk set Rank dari objek karakter permainan
     * 
     * @param name Nama serangan
     * @param power kekuatan serangan
     * 
     * @return Rank
     * 
     */
    private Rank setRank(String name, int power){
        int levelRank = player.getLevel() % 3;
        Rank rank;
        if(levelRank == 1){
            rank = new Tank(name, power);
        } else if (levelRank == 2){
            rank = new Normal(name, power);
        } else {
            rank = new Damager(name, power);
        }
        return rank;
    }
    
    /**
     * Method untuk mekanisme serangan
     * 
     * @param attacker Entitas penyerang
     * @param defender Entitas bertahan
     * 
     */
    private void attackTurn(Entity attacker, Entity defender){
        int damage = attacker.getDamage(defender.getDefense(), defender.getRank().getRank());
        defender.setHP((double)damage);
        System.out.println("Serangan : " + damage);
    }
    
    public static void main(String[] args){
        Play main = new Play();
    }
}
