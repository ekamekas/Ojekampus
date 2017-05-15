package ClientOjek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Model.*;
/**
 * Antarmuka utama dalam program ClientOjek untuk oleh user ojek
 * Dalam antar muka ini, user dapat melakukan aksi seperti :
 * > Proses login
 * > Proses logout
 * > Melihat pesanan
 * > Membatalkan pesanan
 * > Menungggu pesanan datang
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.12
 */
public class BOjekGUI extends JFrame implements ActionListener
{
    // Thread
    WatchDog watchDog;
    // 
    Ojek user;
    // Components
    JButton loginButton;
    JButton registerButton;
    JButton pesananButton;
    JButton logoutButton;;
    /**
     * Konstruktor objek antarmuka OjekGUI
     * 
     * @param   Ojek        Objek user untuk panel utama
     */
    public BOjekGUI(Ojek user)
    {
        // Init super
        super("Pelayan ojeKampus");
        setSize(400, 400);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setResizable(false);
        this.user = user;
        // Start watchDog
        watchDog = new WatchDog("WatchDog", 500, this);
        display();
    }
    
    /**
     * Konstruktor objek antarmuka OjekGUI
     * 
     * @param   Ojek        Objek user untuk panel utama
     * @param   WatchDog    Objek program monitoring
     */
    public BOjekGUI(Ojek user, WatchDog watchDog)
    {
        // Init super
        super("Pelayan ojeKampus");
        setSize(800, 600);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setResizable(false);
        this.user = user;
        // Start watchDog
        this.watchDog = watchDog;
        display();
    }
    
    /**
     * Metode ini digunakan untuk melakukan proses yang berkaitan dengan penampilan
     * Dalam metode ini dilakukan setting up kontainer, komponen yang digunakan, layouting
     */
    public void display(){
        // Setup container
        Container container = getContentPane();
        container.setPreferredSize(getSize());
        // Setup Component
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        pesananButton = new JButton("Pesanan");
        logoutButton = new JButton("Logout");
        // Setup listerner
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        registerButton.setActionCommand("register");
        registerButton.addActionListener(this);
        pesananButton.setActionCommand("pesanan");
        pesananButton.addActionListener(this);
        logoutButton.setActionCommand("logout");
        logoutButton.addActionListener(this);
        // Setup Layout
        GroupLayout layout = new GroupLayout(container);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        container.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(logoutButton)
                .addComponent(registerButton)
                .addComponent(pesananButton)
                .addComponent(loginButton)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(logoutButton)
                .addComponent(registerButton)
                .addComponent(pesananButton)
                .addComponent(loginButton)
        );
        // Add component
        container.add(loginButton);
        container.add(registerButton);
        container.add(pesananButton);
        container.add(logoutButton);
        // Visibility
        setVisible(true);
        if(user == null){
            logoutButton.setVisible(false);
            pesananButton.setVisible(false);
        }
        else {
            loginButton.setVisible(false);
            registerButton.setVisible(false);
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("login".equals(e.getActionCommand())){
            new LoginGUI(this, watchDog);
        } else if("register".equals(e.getActionCommand())){
            new RegisterGUI(this, watchDog);
        } else if("logout".equals(e.getActionCommand())){
            try{
            Thread.sleep(500);;
                if(watchDog.logout(user)){
                    watchDog.exit();
                    new BOjekGUI(null);
                    this.dispose();
                }
            }catch(Exception bad){
                
            }
        } else if("pesanan".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
                Pesanan pesanan = watchDog.getPesanan();
                if(pesanan != null){
                    new PesananGUI(this, pesanan, watchDog);
                } else {
                    System.out.println("Sabar ya, rezeki sudah diatur");
                }
            }catch(Exception bad){
            
            }
        }
    }
    
    /**
     * Main metode
     */
    public static void main(String[] args){
        new BOjekGUI(null);
    }
}