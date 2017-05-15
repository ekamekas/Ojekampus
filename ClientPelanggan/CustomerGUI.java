package ClientPelanggan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Model.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.11
 */
public class CustomerGUI extends JFrame implements ActionListener
{
    // Thread
    WatchDog watchDog;
    // 
    Pelanggan user;
    // Components
    JButton loginButton;
    JButton registerButton;
    JButton pesananButton;
    JButton logoutButton;;
    /**
     * Constructor for objects of class OjekGUI
     */
    public CustomerGUI(Pelanggan user)
    {
        // Init super
        super("Pelanggan ojeKampus");
        setSize(400, 600);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setResizable(false);
        this.user = user;
        // Start watchDog
        watchDog = new WatchDog("WatchDog", 500);
        display();
    }
    
    /**
     * Constructor for objects of class MainMenuGUI
     */
    public CustomerGUI(Pelanggan user, WatchDog watchDog)
    {
        // Init super
        super("Pelanggan ojeKampus");
        setSize(400, 600);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setResizable(false);
        this.user = user;
        // Start watchDog
        this.watchDog = watchDog;
        display();
    }
    
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
            Thread.sleep(500);
                if(watchDog.logout(user)){
                    watchDog.exit();
                    new CustomerGUI(null);
                    dispose();
                }
            }catch(Exception bad){
                
            }
        } else if("pesanan".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
                Pesanan pesanan = watchDog.getPesanan();
                if(pesanan != null){
                    if(pesanan.getPelayan() == null)
                        new PesananGUI(this, null, watchDog);
                    else
                        new PesananGUI(this, pesanan, watchDog);
                } else {
                    new PesananGUI(this, null, watchDog);
                }
            }catch(Exception bad){
            
            }
        }
    }
    
    public static void main(String[] args){
        new CustomerGUI(null);
    }
}