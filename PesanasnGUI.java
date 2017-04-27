import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PesanasnGUI extends JFrame
{
    // instance variables - replace the example below with your own
    String[] tipeLayananString = { "AntarOrang", "AntarBarang", "BeliBarang"};
    JLabel titleLabel;
    JLabel inputIdLabel;
    JLabel inputTipeLayananLabel;
    JLabel inputLokasiAwalLabel;
    JLabel inputLokasiAkhirLabel;
    JLabel inputPenggunaAwalLabel;
    JLabel inputPenggunaAkhirLabel;
    JLabel inputBiayaLabel;
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel actionPanel;
    JPanel inputId;
    JPanel inputTipeLayanan;
    JPanel inputLokasiAwal;
    JPanel inputLokasiAkhir;
    JPanel inputPenggunaAwal;
    JPanel inputPenggunaAkhir;
    JPanel inputBiaya;
    JTextArea idText;
    JTextArea lokasiAwalXText;
    JTextArea lokasiAwalYText;
    JTextArea lokasiAwalNamaText;
    JTextArea lokasiAwalKeteranganText;
    JTextArea tipeLayananText;
    JTextArea lokasiAkhirXText;
    JTextArea lokasiAkhirYText;
    JTextArea lokasiAkhirNamaText;
    JTextArea lokasiAkhirKeteranganText;
    JTextArea penggunaAwalText;
    JTextArea penggunaAkhirText;
    JTextArea biayaText;
    JButton enterButton;
    JButton pesanButton;
    JComboBox tipeLayananList;
    public PesanasnGUI(){
        super("Customer GUI");
        setSize( 300, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        titleLabel = new JLabel("Customer");
        inputIdLabel = new JLabel("ID");
        inputTipeLayananLabel = new JLabel("Tipe Layanan");
        inputLokasiAwalLabel = new JLabel("Lokasi Awal");
        inputLokasiAkhirLabel = new JLabel("Lokasi Akhir");
        inputPenggunaAwalLabel = new JLabel("Pengguna Awal");
        inputPenggunaAkhirLabel = new JLabel("Penguna Akhir");
        inputBiayaLabel = new JLabel("Biaya");
        tipeLayananList = new JComboBox(tipeLayananString);
        tipeLayananList.setSelectedIndex(0);
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        actionPanel = new JPanel();
        inputId = new JPanel();
        inputTipeLayanan = new JPanel();
        inputLokasiAwal = new JPanel();
        inputLokasiAkhir = new JPanel();
        inputPenggunaAwal = new JPanel();
        inputPenggunaAkhir = new JPanel();
        inputBiaya = new JPanel();
        enterButton = new JButton("Enter");
        pesanButton = new JButton("Pesan");
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        idText = new JTextArea(2, 15);
        lokasiAwalXText = new JTextArea(2, 5);
        lokasiAwalYText = new JTextArea(2, 5);
        lokasiAwalNamaText = new JTextArea(2, 7);
        lokasiAwalKeteranganText = new JTextArea(2, 7);
        lokasiAkhirXText = new JTextArea(2, 5);
        lokasiAkhirYText = new JTextArea(2, 5);
        lokasiAkhirNamaText = new JTextArea(2, 7);
        lokasiAkhirKeteranganText = new JTextArea(2, 7);
        penggunaAwalText = new JTextArea(2, 15);
        penggunaAkhirText = new JTextArea(2, 15);
        biayaText = new JTextArea(2, 15);
        inputId.add(inputIdLabel);
        inputId.add(idText);
        inputId.add(enterButton);
        inputTipeLayanan.add(inputTipeLayananLabel);
        inputTipeLayanan.add(tipeLayananList);
        inputLokasiAwal.add(inputLokasiAwalLabel);
        inputLokasiAwal.add(lokasiAwalXText);
        inputLokasiAwal.add(lokasiAwalYText);
        inputLokasiAwal.add(lokasiAwalNamaText);
        inputLokasiAwal.add(lokasiAwalKeteranganText);
        inputLokasiAkhir.add(inputLokasiAkhirLabel);
        inputLokasiAkhir.add(lokasiAkhirXText);
        inputLokasiAkhir.add(lokasiAkhirYText);
        inputLokasiAkhir.add(lokasiAkhirNamaText);
        inputLokasiAkhir.add(lokasiAkhirKeteranganText);
        inputPenggunaAwal.add(inputPenggunaAwalLabel);
        inputPenggunaAwal.add(penggunaAwalText);
        inputPenggunaAkhir.add(inputPenggunaAkhirLabel);
        inputPenggunaAkhir.add(penggunaAkhirText);
        inputBiaya.add(inputBiayaLabel);
        inputBiaya.add(biayaText);
        mainPanel.add(titleLabel);
        mainPanel.add(inputId);
        mainPanel.add(inputTipeLayanan);
        mainPanel.add(inputLokasiAwal);
        mainPanel.add(inputLokasiAkhir);
        mainPanel.add(inputPenggunaAwal);
        mainPanel.add(inputPenggunaAkhir);
        mainPanel.add(inputBiaya);
        //mainPanel.add(titlePanel);
        //mainPanel.add(actionPanel);
        add(mainPanel);
        this.setVisible(true);
    }
}
