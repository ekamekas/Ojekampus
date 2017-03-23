import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Write a description of class Array here.
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.23
 */
public class Array
{
    // instance variables - replace the example below with your own
    private static ArrayList<Integer> listInt = new ArrayList<Integer>();
    private static int[] arrayInt = new int[1000];
    private static int temp;
    
    
    /**
     * Konstruktor untuk kelas Array
     */
    public Array(){
        ArrayList<String> tempString = TextParser.textParser("OOP_2016-2017_CS_5_Arrays.txt");
        for(int i = 0; i < tempString.size(); i++) {
    		temp = Integer.parseInt(tempString.get(i));
            listInt.add(temp);
            arrayInt[i] = temp;
        }
    }
    
    /**
     * Metod kelas Array untuk melakukan sorting dari kecil ke besar
     * 
     * @param  arrayInt   Sebuah array dari integer
     * @return     hasil pengurutan dari kecil ke besar 
     */
    public int[] sortArray(int[] arrayInt)
    {
        // Algoritma yang digunakan adalah Dial-Pivot oleh
        // Vladimir Yaroslavskiy
        // Jon Bentley
        // Joshua Block
        Arrays.sort(arrayInt);
        return arrayInt;
    }
    
    /**
     * Metod kelas Array untuk mengembalikan ArrayList Integer
     * 
     * @return     Kumpulan data Integer dalam ArrayList 
     */
    public ArrayList<Integer> getListInt(){
        Collections.sort(listInt);
        return listInt;
    }
    
    /**
     * Metod kelas Array untuk mengembalikan Array Integer
     * 
     * @return     Kumpulan data Integer dalam Array
     */
    public int[] getArrayInt(){
        Arrays.sort(arrayInt);
        return arrayInt;
    }
}
