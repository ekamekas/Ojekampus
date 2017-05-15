package ClientPelanggan;

import java.io.*; 
import java.net.*;
import java.util.ArrayList;

import Model.*;
import Controller.*;
/**
 * Kelas ini berfungsi untuk mengatasi sebagai proses yang berkaitan dengan socket
 * Kelas ini digunakan untuk mengirimkan dan menerima data dari/ke server dan client
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.12
 */
public class ClientConnectionHandler
{
    // instance variables - replace the example below with your own
    Socket sock;
    
    /**
     * Metode ini untuk membuat hubungan socket dengan remote program
     */
    protected void connect(){
        try{      
            sock = new Socket("localhost",6666);  
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Metode ini untuk memutuskan hubungan socket dengan remote program
     */
    protected void disconnect(){
        try{      
            sendData(null);
            sock.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Metode ini untuk mengirimkan data berupa komando yang telah didefinisikan
     * 
     * @param   ConnectionCommand   Komando yang akan dikirimkan ke remote
     * @see     Controller.ConnectionCommand
     */
    protected void sendCommand(ConnectionCommand command){
        sendData(command);
    }
    
    /**
     * Metode ini untuk mengirimkan data secara umum
     * 
     * @param   Object   data yang akan dikirimkan ke remote
     * @see     Object
     */
    protected void sendData(Object data){
        try{      
            ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
            out.writeObject(data);
            out.flush();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Metode ini untuk menerima data secara umum
     * 
     * @return   Object   data yang diterima dari remote
     * @see     Object
     */
    protected Object getData(){
        Object data = null;
        try{
            ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
	        data = in.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
}
