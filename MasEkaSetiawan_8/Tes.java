import java.util.Random;
import java.util.Arrays;
/**
 * Write a description of class Tes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tes
{
    public static void main(String[] args){
        int delays[] = {0, 0, 0};
        for(int i = 0; i < 3; i++){
            delays[i] = new Random().nextInt(((100 - 0) + 1) + 0);
        }
        Arrays.sort(delays);
        LombaHitung tomi = new LombaHitung("Tomi");
        tomi.setDelay(delays[2]);
        LombaHitung toma = new LombaHitung("Toma");
        toma.setDelay(delays[1]);
        LombaHitung tomo = new LombaHitung("Tomo"); 
        tomo.setDelay(delays[0]);
        tomi.start();
        toma.start();
        tomo.start();
    }
}
