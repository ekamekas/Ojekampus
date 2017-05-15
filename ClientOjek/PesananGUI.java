package ClientOjek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Model.*;
import Controller.*;
/**
 * Antarmuka informasi pesanan yang dimiliki oleh user ojek
 * Dalam antar muka ini, user dapat melakukan aksi seperti :
 * > Membatalkan pesanan
 * > Melihat informasi pesanan
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.12
 */
public class PesananGUI extends JDialog implements ActionListener
{
    // Thread
    WatchDog watchDog;
    // 
    Pesanan pesanan;
    // Components
    JLabel titleLabel;
    JLabel tipeLayananLabel;
    JLabel lokasiAwalLabel;
    JLabel lokasiAkhirLabel;
    JLabel penggunaAwalLabel;
    JLabel penggunaAkhirLabel;
    JLabel biayaLabel;
    JLabel statusOjekLabel;
    
    JLabel lokasiAwalXText;
    JLabel lokasiAwalYText;
    JLabel lokasiAwalNamaText;
    JLabel lokasiAkhirXText;
    JLabel lokasiAkhirYText;
    JLabel lokasiAkhirNamaText;
    JLabel penggunaAwalText;
    JLabel penggunaAkhirText;
    JLabel biayaText;
    JLabel tipeLayananText;
    JLabel statusOjekText;
    
    JButton batalButton;
    
    /**
     * Konstruktor objek antarmuka PesananGUI
     * 
     * @param   JFrame      Panel utama dari main program
     * @param   Pesanan     Pesanan panel utama dari main program
     * @param   WatchDog    Objek program monitoring
     */
    public PesananGUI(JFrame frame, Pesanan pesanan, WatchDog watchDog)
    {
        // Init super
        super(frame, "ojeKampus");
        setSize(400, 400);
        setIconImage(new ImageIcon("E:/MasEka/Veritas. Probitas. Iustitia/Tugas/Object-Oriented Programming/onlineShop/resources/image/icon.png").getImage());
        setResizable(false);
        this.pesanan = pesanan;
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
        titleLabel = new JLabel("Pesanan");
        tipeLayananLabel = new JLabel("Tipe Layanan : ");
        lokasiAwalLabel = new JLabel("Lokasi Awal : ");
        lokasiAkhirLabel = new JLabel("Lokasi Akhir : ");
        penggunaAwalLabel = new JLabel("Pengguna Awal : ");
        penggunaAkhirLabel = new JLabel("Pengguna Akhir : ");
        biayaLabel = new JLabel("Biaya : ");
        JLabel statusOjekLabel = new JLabel("Status : ");
        
        penggunaAwalText = new JLabel("Pengguna Awal");
        penggunaAkhirText = new JLabel("Pengguna Akhir");
        biayaText = new JLabel("Biaya");
        tipeLayananText = new JLabel("Tipe");
        lokasiAwalXText = new JLabel(Integer.toString(0));
        lokasiAwalYText = new JLabel(Integer.toString(0));
        lokasiAwalNamaText = new JLabel("void");
        lokasiAkhirXText = new JLabel(Integer.toString(0));
        lokasiAkhirYText = new JLabel(Integer.toString(0));
        lokasiAkhirNamaText = new JLabel("void");
        JLabel statusOjekText = new JLabel("IDLE");;
        
        batalButton = new JButton("Batal");
        // Setup listerner
        batalButton.setActionCommand("batal");
        batalButton.addActionListener(this);
        // Setup Layout
        GroupLayout layout = new GroupLayout(container);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        container.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(titleLabel)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tipeLayananLabel)
                    .addComponent(tipeLayananText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lokasiAwalLabel)
                    .addComponent(lokasiAwalXText)
                    .addComponent(lokasiAwalYText)
                    .addComponent(lokasiAwalNamaText)                 
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lokasiAkhirLabel)
                    .addComponent(lokasiAkhirXText)
                    .addComponent(lokasiAkhirYText)
                    .addComponent(lokasiAkhirNamaText)                
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(penggunaAwalLabel)
                    .addComponent(penggunaAwalText)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(penggunaAkhirLabel)
                    .addComponent(penggunaAkhirText)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(biayaLabel)
                    .addComponent(biayaText)                 
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(statusOjekLabel)
                    .addComponent(statusOjekText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(batalButton,      GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
        );
        layout.linkSize(biayaLabel, penggunaAkhirLabel, penggunaAwalLabel, lokasiAkhirLabel, lokasiAwalLabel, tipeLayananLabel, statusOjekLabel);
        layout.linkSize(penggunaAwalText, penggunaAkhirText, tipeLayananText, statusOjekText);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGroup(layout.createParallelGroup()
                    .addComponent(tipeLayananLabel)
                    .addComponent(tipeLayananText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(lokasiAwalLabel)
                    .addComponent(lokasiAwalXText)
                    .addComponent(lokasiAwalYText)
                    .addComponent(lokasiAwalNamaText)                 
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(lokasiAkhirLabel)
                    .addComponent(lokasiAkhirXText)
                    .addComponent(lokasiAkhirYText)
                    .addComponent(lokasiAkhirNamaText)                
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(penggunaAwalLabel)
                    .addComponent(penggunaAwalText)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(penggunaAkhirLabel)
                    .addComponent(penggunaAkhirText)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(biayaLabel)
                    .addComponent(biayaText)                 
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(statusOjekLabel)
                    .addComponent(statusOjekText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(batalButton,      GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
        );
        // Add component
        container.add(titleLabel);
        container.add(tipeLayananLabel);
        container.add(lokasiAwalLabel);
        container.add(lokasiAkhirLabel);
        container.add(penggunaAwalLabel);
        container.add(penggunaAkhirLabel);
        container.add(biayaLabel);
        container.add(statusOjekLabel);
        container.add(lokasiAwalXText);
        container.add(lokasiAwalYText);
        container.add(lokasiAwalNamaText);
        container.add(lokasiAkhirXText);
        container.add(lokasiAkhirYText);
        container.add(lokasiAkhirNamaText);
        container.add(penggunaAwalText);
        container.add(penggunaAkhirText);
        container.add(biayaText);
        container.add(tipeLayananText);
        container.add(statusOjekText);
        container.add(batalButton);
        // Visibility
        setVisible(true);
        if(pesanan.getPelayan() == null){
            titleLabel.setText("Belum ada pesanan");
            batalButton.setVisible(false);
            lokasiAwalXText.setVisible(false);
            lokasiAwalYText.setVisible(false);
            lokasiAwalNamaText.setVisible(false);
            lokasiAkhirXText.setVisible(false);
            lokasiAkhirYText.setVisible(false);
            lokasiAkhirNamaText.setVisible(false);
            penggunaAwalText.setVisible(false);
            penggunaAkhirText.setVisible(false);
            biayaText.setVisible(false);
            tipeLayananText.setVisible(false);
            statusOjekText.setVisible(false);
        }
        else {
            lokasiAwalXText.setText(Double.toString(pesanan.getLokasiAwal().getX()));
            lokasiAwalYText.setText(Double.toString(pesanan.getLokasiAwal().getY()));
            lokasiAwalNamaText.setText(pesanan.getLokasiAwal().getNama());
            lokasiAkhirXText.setText(Double.toString(pesanan.getLokasiAkhir().getX()));
            lokasiAkhirYText.setText(Double.toString(pesanan.getLokasiAkhir().getY()));
            lokasiAkhirNamaText.setText(pesanan.getLokasiAkhir().getNama());
            penggunaAwalText.setText(pesanan.getPenggunaAwal());
            penggunaAkhirText.setText(pesanan.getPenggunaAkhir());
            biayaText.setText(Double.toString(pesanan.getBiaya()));
            tipeLayananText.setText(pesanan.getTipeLayanan().toString());
            statusOjekText.setText(pesanan.getPelayan().getStatus().toString());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("terima".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
//                 watchDog.pesananAmbil(ConnectionCommand.AMBIL);
            }catch(Exception bad){
                
            }
        } else if("tolak".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
//                 watchDog.pesananAmbil(ConnectionCommand.TOLAK);
            }catch(Exception bad){
                
            }
        } else if("batal".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
//                 watchDog.pesananAmbil(ConnectionCommand.TOLAK);
                watchDog.pesananBatal();
            }catch(Exception bad){
                
            }
        }
    }
}
