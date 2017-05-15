package Server;

import Model.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Kelas ini berfungsi sebagai konektor aplikasi dengan database
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.8
 */
public class DatabaseConnector
{
    // Variable yang digunakan dalam menghubungkan dengan database
    private static final String url = "jdbc:postgresql://localhost:5432/ojekampus";
    private static final String user = "pg_masekasetiawan";
    private static final String password = "postgres";
    
    // Variable for connection state
    static Connection conn;
    /**
     * Kelas untuk membuat hubungan dengan database
     */
    public static void connect()
    {
        conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Server Successfully.");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Kelas untuk memutus hubungan dengan database
     */
    public static void disconnect(){
        if(conn != null)
            try{
                conn.close();
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    
    public static Boolean updateData(String query){
        // Hasil query yang merepresentasikan baris data
        int affectedRow = 0;
        connect();
        try{
            Statement stm = conn.createStatement();
            affectedRow = stm.executeUpdate(query);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        disconnect();
        if(affectedRow == 0)
            return false;
        else
            return true;
    }
    
    public static ArrayList<Object[]> getData(String query){
        // Hasil query yang merepresentasikan baris data
        ArrayList<Object[]> resultList = new ArrayList<Object[]>();
        ResultSet result;
        ResultSetMetaData rsmd;
        connect();
        try{
            Statement stm = conn.createStatement();
            result = stm.executeQuery(query);
            rsmd = result.getMetaData();
            Object[] obj = new Object[rsmd.getColumnCount()];
            while(result.next()){
                for(int col = 1; col < rsmd.getColumnCount(); col++){
                    obj[col-1] = result.getObject(col);
                }
                resultList.add(obj);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        disconnect();
        return resultList;
    }
}
