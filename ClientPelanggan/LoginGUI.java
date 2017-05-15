package ClientPelanggan;

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
public class LoginGUI extends JDialog implements ActionListener
{
    // WatchDog
    WatchDog watchDog;
    // instance variables - replace the example below with your own
    Pelanggan pelanggan = null;
    //
    JPanel formPanel;
    JLabel inputUsernameLabel;
    JLabel inputPasswordLabel;
    JLabel badLabel;
    JTextField inputUsernameText;
    JPasswordField inputPasswordText;
    JButton loginButton;
    /**
     * Konstruktor objek antarmuka LoginGUI
     * 
     * @param   JFrame      Panel utama dari main program
     * @param   WatchDog    Objek program monitoring
     */
    public LoginGUI(JFrame frame, WatchDog watchDog)
    {
        // Init Super
        super(frame, "Login", Dialog.ModalityType.APPLICATION_MODAL);
        setSize(300, 200);
        // Create thread
        this.watchDog = watchDog;
        // Setup Container
        formPanel = new JPanel();
        Container container = getContentPane();
        // Setup Components
        inputUsernameLabel = new JLabel("username");
        inputPasswordLabel = new JLabel("password");
        badLabel = new JLabel("Username atau password salah");
        inputUsernameText = new JTextField("ekamekas", 10);
        inputPasswordText = new JPasswordField("******");
        loginButton = new JButton("Login");
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        // Setup Listener
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
        GroupLayout layout = new GroupLayout(formPanel);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
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
        // Add Components
        formPanel.add(inputUsernameLabel);
        formPanel.add(inputPasswordLabel);
        formPanel.add(inputUsernameText);
        formPanel.add(inputPasswordText);
        formPanel.add(badLabel);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        add(formPanel, constraint);
        constraint.fill = GridBagConstraints.SOUTHEAST;
        constraint.gridwidth = 2;
        add(loginButton, constraint);
        // Visibility
        badLabel.setVisible(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("login".equals(e.getActionCommand()))
            pelanggan = watchDog.login(inputUsernameText.getText(), String.valueOf(inputPasswordText.getPassword()));
            if(pelanggan != null){
                watchDog.start();
                Window window = SwingUtilities.getWindowAncestor(this);
                window.dispose();
                new CustomerGUI(pelanggan, watchDog);
                this.dispose();
            } else {
                badLabel.setVisible(true);
            }
    }
}
