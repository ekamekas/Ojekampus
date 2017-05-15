package ClientOjek;

import Model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.NullPointerException;
/**
 * Antarmuka untuk melakukan proses autentikasi untuk program ClientOjek
 * Dalam antar muka ini, user dapat melakukan aksi seperti :
 * > Mengisi data untuk proses autentikasi dengan server
 * > Melakukan autentikasi dengan server
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.11
 */
public class OjekGUI extends JFrame implements ActionListener
{
    // WatchDog
    WatchDog watchDog;
    //
    Ojek user = null;
    //Container
    JPanel mainPane;
    JPanel formPanel;
    JPanel buttonPanel;
    // Component
    JLabel inputUsernameLabel;
    JLabel inputPasswordLabel;
    JLabel badLabel;
    JLabel namaLabel;
    JLabel emailLabel;
    JLabel statusOjekLabel;
    
    JTextField inputUsernameText;
    JPasswordField inputPasswordText;
    
    JButton loginButton;
    JButton pesananButton;
    JButton registerButton;
    JButton logoutButton;;
    /**
     * Konstruktor objek antarmuka LoginGUI
     * 
     * @param   JFrame      Panel utama dari main program
     * @param   WatchDog    Objek program monitoring
     */
    public OjekGUI(Ojek user)
    {
        // Init super
        super("Pelayan ojeKampus");
        setSize(400, 600);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.user = user;
        // Start watchDog
        watchDog = new WatchDog("WatchDog", 500, this);
        display();
    }
    
    /**
     * Konstruktor objek antarmuka LoginGUI
     * 
     * @param   JFrame      Panel utama dari main program
     * @param   WatchDog    Objek program monitoring
     */
    public OjekGUI(Ojek user, WatchDog watchDog)
    {
        // Init super
        super("Pelayan ojeKampus");
        setSize(400, 600);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.user = user;
        // Start watchDog
        this.watchDog = watchDog;
        display();
    }
    
    public void display(){
        // Setup Container
        formPanel = new JPanel();
        mainPane = new JPanel();
        buttonPanel = new JPanel();
        Container container = getContentPane();
        // Setup Components
        inputUsernameLabel = new JLabel("username");
        inputPasswordLabel = new JLabel("password");
        badLabel = new JLabel("Username atau password salah");
        JLabel namaLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        JLabel statusOjekLabel = new JLabel();
        inputUsernameText = new JTextField("ekamekas", 10);
        inputPasswordText = new JPasswordField("******");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        pesananButton = new JButton("Pesanan");
        logoutButton = new JButton("Logout");
        // Setup Listener
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        registerButton.setActionCommand("register");
        registerButton.addActionListener(this);
        pesananButton.setActionCommand("pesanan");
        pesananButton.addActionListener(this);
        logoutButton.setActionCommand("logout");
        logoutButton.addActionListener(this);
        inputUsernameText.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                inputUsernameText.setText("");
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(inputUsernameText.getText().equals(""))
                    inputUsernameText.setText("username");
            }
        });
        inputPasswordText.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                inputPasswordText.setText("");
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(String.valueOf(inputPasswordText.getPassword()).equals(""))
                    inputPasswordText.setText("******");
            }
        });
        // Setup Layout
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        GroupLayout layout = new GroupLayout(formPanel);
        formPanel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.linkSize(inputUsernameLabel, inputPasswordLabel);
        layout.linkSize(inputUsernameText, inputPasswordText);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputUsernameLabel)
                    .addComponent(inputUsernameText,    GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPasswordLabel)
                    .addComponent(inputPasswordText)
                )
                .addComponent(badLabel)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputUsernameLabel)
                    .addComponent(inputUsernameText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPasswordLabel)
                    .addComponent(inputPasswordText)
                )
                .addComponent(badLabel)
        );
        layout = new GroupLayout(mainPane);
        mainPane.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.linkSize(namaLabel, emailLabel, statusOjekLabel);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(namaLabel)
                .addComponent(emailLabel)
                .addComponent(statusOjekLabel)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(namaLabel)
                .addComponent(emailLabel)
                .addComponent(statusOjekLabel)
        );
        layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.linkSize(loginButton, registerButton, pesananButton, logoutButton);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(loginButton)
                .addComponent(registerButton)
                .addComponent(pesananButton)
                .addComponent(logoutButton)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addComponent(loginButton)
                .addComponent(registerButton)
                .addComponent(pesananButton)
                .addComponent(logoutButton)
        );
        // Add Components
        formPanel.add(inputUsernameLabel);
        formPanel.add(inputPasswordLabel);
        formPanel.add(inputUsernameText);
        formPanel.add(inputPasswordText);
        formPanel.add(badLabel);
        mainPane.add(namaLabel);
        mainPane.add(emailLabel);
        mainPane.add(statusOjekLabel);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(pesananButton);
        buttonPanel.add(logoutButton);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        add(formPanel, constraint);
        constraint.fill = GridBagConstraints.REMAINDER;
        constraint.gridwidth = 2;
        add(mainPane, constraint);
        constraint.fill = GridBagConstraints.SOUTHEAST;
        constraint.gridwidth = 2;
        add(buttonPanel, constraint);
        // Visibility
        badLabel.setVisible(false);
        setVisible(true);
        if(user == null){
            mainPane.setVisible(false);
            logoutButton.setVisible(false);
            pesananButton.setVisible(false);
        }
        else {
            formPanel.setVisible(false);
            namaLabel.setText("nama : " + user.getNama());
            emailLabel.setText("email : " + user.getEmail());
            statusOjekLabel.setText("status : " + user.getStatus());
            loginButton.setVisible(false);
            registerButton.setVisible(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("login".equals(e.getActionCommand())){
            user = watchDog.login(inputUsernameText.getText(), String.valueOf(inputPasswordText.getPassword()));
            if(user != null){
                watchDog.start();
                new OjekGUI(user, watchDog);
                dispose();
            } else {
                badLabel.setVisible(true);
            }
        } else if("register".equals(e.getActionCommand())){
            new RegisterGUI(this, watchDog);
        } else if("logout".equals(e.getActionCommand())){
            try{
            Thread.sleep(500);;
                if(watchDog.logout(user)){
                    watchDog.exit();
                    dispose();
                    new OjekGUI(null);
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
        new OjekGUI(null);
    }
}
