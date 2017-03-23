import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Write a description of class OOP here.
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.23
 */
public class OOP
{
    // instance variables - replace the example below with your own
    private ArrayList<Mahasiswa> siswa = new ArrayList<Mahasiswa>();

    /**
     * Constructor for objects of class OOP
     */
    public OOP()
    {
        // initialise instance variables
        Scanner consoleScanner = new Scanner(System.in);
        String nama;
        int nilai;
        while(true){
            System.out.print("> ");
            nama = consoleScanner.nextLine();
            if(nama.equals("q"))
                break;
            nilai = Integer.parseInt(consoleScanner.nextLine());
            siswa.add(new Mahasiswa(nama, nilai));
        }
        sortingMahasiswa();
        printData();
    }
    
    /**
     * Method untuk melakukan sorting List yang berisi Objek mahasisw
     */
    public void sortingMahasiswa(){
        Collections.sort(siswa, new MahasiswaComparator());
    }
   
    /**
     * Getter List siswa
     */
    public ArrayList<Mahasiswa> getMahasiswa(){
        return siswa;
    }
    
    /**
     * Method untuk menampilkan data objek Mahasiswa yang ada dalam List siswa
     */
    public void printData(){
        System.out.println("Data siswa : ");
        for(int i = 0; i < siswa.size(); i++){
            System.out.println(siswa.get(i).getNama());
            System.out.println(siswa.get(i).getNilai());
        }
    }
    
}
