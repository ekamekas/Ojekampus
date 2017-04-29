import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OjekGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JButton registerButton;
    JButton loginButton;
    public OjekGUI(){
        super("Ojek GUI");
        setSize( 300, 300 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Ojek");
        registerButton = new JButton("Register");
        loginButton = new JButton("Login");
        add(titleLabel);
        mainPane.add(registerButton);
        mainPane.add(loginButton);
        // End components
        // Layout
        getContentPane().setLayout(new GridBagLayout());
        GroupLayout layout = new GroupLayout(mainPane);
        mainPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(loginButton,      GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
        );
        layout.linkSize(registerButton, loginButton);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(loginButton,      GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
        );
        // End layout
        // Listener
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new RegisterOjekGUI();
            }
        });
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new OjekLoginGUI();
            }
        });
        // End listener
        this.setVisible(true);
    }
}