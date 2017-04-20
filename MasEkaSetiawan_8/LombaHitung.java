/**
 * Write a description of class LombaHitung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LombaHitung implements Runnable
{
    // instance variables - replace the example below with your own
    private String nama;
    private int delay = 0;
    
    /**
     * Constructor for objects of class LombaHitung
     */
    public LombaHitung()
    {
        // initialise instance variables
        this.nama = "Anonymous";
    }
    
    /**
     * Constructor for objects of class LombaHitung
     */
    public LombaHitung(String nama)
    {
        // initialise instance variables
        this.nama = nama;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void run()
    {
        // put your code here
        printPesan(nama + " mulai berhitung");
        try{
            for(int angka = 0; angka < 24; angka++){
                printPesan("Kontestan " + nama + " menghitung " + angka);
                Thread.sleep(delay);
            }
            printPesan("Kontestan " + nama + " selesai menghitung");
        } catch(InterruptedException e){
            printPesan("Kontestan " + nama + " interrupted");
        }
    }
    
    public void start(){
        printPesan(nama + " hadir");
        Thread t = new Thread(this);
        printPesan(nama + " bersiap");
        t.start();
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setDelay(int delay){
        this.delay = delay;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public int getDelay(){
        return this.delay;
    }
    
    public void printPesan(String pesan){
        System.out.println(pesan);
    }
}
