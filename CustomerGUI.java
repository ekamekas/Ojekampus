import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JLabel titleLabel;
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel actionPanel;
    JButton registerButton;
    JButton pemesananButton;
    JButton menungguButton;
    public CustomerGUI(){
        super("Customer GUI");
        setSize( 300, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        titleLabel = new JLabel("Customer");
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        actionPanel = new JPanel();
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        registerButton = new JButton("Register");
        pemesananButton = new JButton("Pemesanan");
        menungguButton = new JButton("Menunggu");
        titlePanel.add(titleLabel);
        actionPanel.add(registerButton);
        actionPanel.add(pemesananButton);
        actionPanel.add(menungguButton);
        mainPanel.add(titlePanel);
        mainPanel.add(actionPanel);
        add(mainPanel);
        this.setVisible(true);
    }
}
