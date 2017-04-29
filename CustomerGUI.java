import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JButton registerButton;
    JButton pemesananButton;
    JButton menungguButton;
    public CustomerGUI(){
        super("Customer GUI");
        setSize( 300, 300 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Customer");
        registerButton = new JButton("Register");
        pemesananButton = new JButton("Pemesanan");
        menungguButton = new JButton("Menunggu");
        add(titleLabel);
        mainPane.add(registerButton);
        mainPane.add(pemesananButton);
        mainPane.add(menungguButton);
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
                .addComponent(pemesananButton,  GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(menungguButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
        );
        layout.linkSize(registerButton, pemesananButton, menungguButton);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(pemesananButton,  GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(menungguButton,    GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
        );
        // Create Listener
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new RegisterCustomerGUI();
            }
        });
        pemesananButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new PesananGUI();
            }
        });
        menungguButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new TungguGUI();
            }
        });
        this.setVisible(true);
    }
}
