package ClientOjek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;

import Model.*;
import Controller.*;
public class Test{
        ClientConnectionHandler conn;
        Object data;
        Pesanan pesanan;
        Ojek ojek;
        GPS gps;
        public Test(){
            conn = new ClientConnectionHandler();
            conn.connect();
            gps = new GPS();
        }
        
        public Object testLoginOjek(){
            conn.sendCommand(ConnectionCommand.OJEK);
            conn.sendCommand(ConnectionCommand.LOGIN);
            conn.sendData("anis");
            conn.sendData("anis");
            data = conn.getData();
            ojek = null;
            if(data instanceof Ojek){
                ojek = (Ojek)data;
                ojek.setPosisi(gps.getData());
                conn.sendData(ojek);
            }
            return ojek;
        }
        
        public Boolean testLogutOjek(){
            conn.sendCommand(ConnectionCommand.OJEK);
            conn.sendCommand(ConnectionCommand.LOGOUT);
            conn.sendData(ojek);
            data = conn.getData();
            return (Boolean)data;
        }
            
        public void waiting(){
            Boolean terima = true;
            while(true){
                ConnectionCommand command = (ConnectionCommand)conn.getData();
                if(command.equals(ConnectionCommand.PESAN)){
                    pesanan = (Pesanan)conn.getData();
                    if(terima){
                        ojek.setPesanan(pesanan);
                        pesanan.setPelayan(ojek);
                    }
                    conn.sendCommand(ConnectionCommand.OJEK);
                    conn.sendCommand(ConnectionCommand.AMBIL);
                    conn.sendData(pesanan);
                    pesanan = (Pesanan)conn.getData();
                    ojek = pesanan.getPelayan();
                    break;
                }
            }
        }
                
        public void testSelesai(){
            conn.sendCommand(ConnectionCommand.OJEK);
            conn.sendCommand(ConnectionCommand.SELESAI);
            conn.sendData(ojek);
            ojek = (Ojek)conn.getData();
        }
        
        public void testBatal(){
            conn.sendCommand(ConnectionCommand.OJEK);
    		conn.sendCommand(ConnectionCommand.BATAL);
    		conn.sendData(ojek);
    		pesanan = (Pesanan)conn.getData();
    // 		ojek = pesanan.getPelayan();
        }
        
        public ArrayList<User> testDatabase(){
            ArrayList<User> list = new ArrayList<User>();
            conn.sendCommand(ConnectionCommand.UNKNOWN);
            data = conn.getData();
            list = (ArrayList<User>)data;
            return list;
        }
        
        public ArrayList<Pesanan> pesananDatabase(){
            ArrayList<Pesanan> list = new ArrayList<Pesanan>();
            conn.sendCommand(ConnectionCommand.UNKNOWN);
            data = conn.getData();
            list = (ArrayList<Pesanan>)data;
            return list;
        }
    }