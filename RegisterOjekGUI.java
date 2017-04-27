import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegisterOjekGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JLabel titleLabel;
    JLabel inputNamaLabel;
    JLabel inputTelpLabel;
    JLabel inputEmailLabel;
    JLabel inputDobLabel;
    JLabel inputLokasiLabel;
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel actionPanel;
    JPanel inputNama;
    JPanel inputTelp;
    JPanel inputEmail;
    JPanel inputDob;
    JPanel inputPlat;
    JPanel inputLokasi;
    JTextArea namaText;
    JTextArea telpText;
    JTextArea emailText;
    JTextArea dobText;
    JTextArea lokasiXText;
    JTextArea lokasiYText;
    JTextArea lokasiNamaText;
    JTextArea lokasiKeteranganText;
    JButton registerButton;
    public RegisterOjekGUI(){
        super("Customer GUI");
        setSize( 300, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        titleLabel = new JLabel("Customer");
        inputNamaLabel = new JLabel("Nama : ");
        inputTelpLabel = new JLabel("Telp : ");
        inputEmailLabel = new JLabel("Email : ");
        inputDobLabel = new JLabel("DoB : ");
        inputLokasiLabel = new JLabel("Lokasi : ");
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        actionPanel = new JPanel();
        inputNama = new JPanel();
        inputTelp = new JPanel();
        inputEmail = new JPanel();
        inputDob = new JPanel();
        inputLokasi = new JPanel();
        registerButton = new JButton("Register");
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        namaText = new JTextArea(2, 15);
        telpText = new JTextArea(2, 15);
        emailText = new JTextArea(2, 15);
        dobText = new JTextArea(2, 15);
        lokasiXText = new JTextArea(2, 5);
        lokasiYText = new JTextArea(2, 5);
        lokasiNamaText = new JTextArea(2, 10);
        lokasiKeteranganText = new JTextArea(2, 10);
        inputNama.add(inputNamaLabel);
        inputNama.add(namaText);
        inputTelp.add(inputTelpLabel);
        inputTelp.add(telpText);
        inputEmail.add(inputEmailLabel);
        inputEmail.add(emailText);
        inputDob.add(inputDobLabel);
        inputDob.add(dobText);
        inputLokasi.add(inputLokasiLabel);
        inputLokasi.add(lokasiXText);
        inputLokasi.add(lokasiYText);
        inputLokasi.add(lokasiNamaText);
        inputLokasi.add(lokasiKeteranganText);
        mainPanel.add(titleLabel);
        mainPanel.add(inputNama);
        mainPanel.add(inputTelp);
        mainPanel.add(inputEmail);
        mainPanel.add(inputDob);
        mainPanel.add(inputLokasi);
        mainPanel.add(registerButton);
        //mainPanel.add(titlePanel);
        //mainPanel.add(actionPanel);
        add(mainPanel);
        this.setVisible(true);
    }
}
