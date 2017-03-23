import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class handler untuk parsing file
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.3.23
 */
public class TextParser
{

    /**
     * Metode untuk melakukan pengambilan data dari sebuah file
     * 
     * @param  filePath   Path letak file relative terhadap program
     * @return     ArrayList dari hasil parsing file 
     */
    public static ArrayList<String> textParser(String filePath)
    {
        ArrayList<String> parserLine = new ArrayList<String>();
        try{
            Scanner scanner = new Scanner(new File(filePath));
            while(scanner.hasNext()){
                parserLine.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
            System.out.println("[!] File tidak ditemukan");
        }
        
        return parserLine;
        
    }
}
