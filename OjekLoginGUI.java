import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OjekLoginGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JLabel titleLabel;
    JLabel idLabel;
    JLabel subTitleLabel;
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel actionPanel;
    JPanel inputId;
    JPanel inputPesanan;
    JTextArea idText;
    JTextArea pesananText;
    JButton enterButton;
    JButton terimaPesananButton;
    JButton batalPesananButton;
    public OjekLoginGUI(){
        super("Customer GUI");
        setSize( 300, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        titleLabel = new JLabel("Ojek Login : ");
        idLabel = new JLabel("ID : ");
        subTitleLabel = new JLabel("informasi Pesanan : ");
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        actionPanel = new JPanel();
        inputId = new JPanel();
        inputPesanan = new JPanel();
        enterButton = new JButton("Enter");
        terimaPesananButton = new JButton("Accept");
        batalPesananButton = new JButton("Decline");
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        idText = new JTextArea(2, 15);
        pesananText = new JTextArea(2, 15);
        inputId.add(idLabel);
        inputId.add(idText);
        inputId.add(enterButton);
        inputPesanan.add(subTitleLabel);
        inputPesanan.add(pesananText);
        inputPesanan.add(terimaPesananButton);
        inputPesanan.add(batalPesananButton);
        mainPanel.add(titleLabel);
        mainPanel.add(inputId);
        mainPanel.add(inputPesanan);
        //mainPanel.add(titlePanel);
        //mainPanel.add(actionPanel);
        add(mainPanel);
        this.setVisible(true);
    }
}
