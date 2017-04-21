
/**
 * Write a description of class SistemPengawas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SistemPengawas implements Runnable
{
    // instance variables - replace the example below with your own
    private Thread t;
    private String threadName;
    private boolean programRun;
    private int waktuCek;
    
    /**
     * Constructor for objects of class SistemPengawas
     */
    public SistemPengawas(String name, int waktuCek)
    {
        // initialise instance variables
        threadName = name;
        this.waktuCek = waktuCek;
        programRun = true;
        System.out.println("Creating " + threadName);
     }
    
    public void run(){
        System.out.println("Running " + threadName);
        while(programRun){
            try {
                Thread.sleep(waktuCek);
                Administrasi.jalankanSistemPenugas();
            } catch(InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted");
            }
        }
        System.out.println("Thread " + threadName + " existing");
    }
    
    public void start(){
        System.out.println("Starting " + threadName);
        t = new Thread(this);
        t.start();
    }
    
    public void join(){
        try {
            t.join();
        } catch(InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted");
        }
    }
    
    public void exit(){
        programRun = false;
    }
}
