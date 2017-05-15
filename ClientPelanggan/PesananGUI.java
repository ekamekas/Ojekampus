package ClientPelanggan;

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
 * > Menyelesaikan pesanan
 * > Membuat pesanan
 * 
 * @author Mas Eka Setiawan 
 * @version 2017.5.12
 */
public class PesananGUI extends JDialog implements ActionListener
{
    // Thread
    WatchDog watchDog;
    // 
    Lokasi lokasiAwal = new GPS().getData();
    Lokasi lokasiAkhir = new GPS().getData();
    Pesanan pesanan;
    // Components
    JLabel titleLabel;
    JLabel inputTipeLayananLabel;
    JLabel inputLokasiAwalLabel;
    JLabel inputLokasiAkhirLabel;
    JLabel inputPenggunaAwalLabel;
    JLabel inputPenggunaAkhirLabel;
    JLabel inputBiayaLabel;
    
    JLabel inputLokasiAwalXText;
    JLabel inputLokasiAwalYText;
    JLabel inputLokasiAwalNamaText;
    JLabel inputLokasiAwalKeteranganText;
    JLabel inputLokasiAkhirXText;
    JLabel inputLokasiAkhirYText;
    JLabel inputLokasiAkhirNamaText;
    JLabel inputLokasiAkhirKeteranganText;
    JLabel penggunaAwalLabel;
    JLabel penggunaAkhirLabel;
    JLabel biayaLabel;
    JLabel tipeLayananLabel;
    
    JButton pesanButton;
    JButton selesaiButton;
    JButton batalButton;
    
    JTextField inputPenggunaAwalText;
    JTextField inputPenggunaAkhirText;
    JComboBox<TipeLayanan> tipeLayananList;
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
        setSize(400, 600);
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
        titleLabel = new JLabel("Pemesanan Customer");
        inputTipeLayananLabel = new JLabel("Tipe Layanan : ");
        inputLokasiAwalLabel = new JLabel("Lokasi Awal : ");
        inputLokasiAkhirLabel = new JLabel("Lokasi Akhir : ");
        inputPenggunaAwalLabel = new JLabel("Pengguna Awal : ");
        inputPenggunaAkhirLabel = new JLabel("Pengguna Akhir : ");
        inputBiayaLabel = new JLabel("Biaya : ");
        penggunaAwalLabel = new JLabel("Pengguna Awal");
        penggunaAkhirLabel = new JLabel("Pengguna Akhir");
        biayaLabel = new JLabel("Biaya");
        tipeLayananLabel = new JLabel("Tipe");
        pesanButton = new JButton("Pesan");
        selesaiButton = new JButton("Selesai");
        batalButton = new JButton("Batal");
        inputLokasiAwalXText = new JLabel(Double.toString(lokasiAwal.getX()));
        inputLokasiAwalYText = new JLabel(Double.toString(lokasiAwal.getY()));
        inputLokasiAwalNamaText = new JLabel(lokasiAwal.getNama());
        inputLokasiAwalKeteranganText = new JLabel(lokasiAwal.getKeteranganLokasi());
        inputLokasiAkhirXText = new JLabel(Double.toString(lokasiAkhir.getX()));
        inputLokasiAkhirYText = new JLabel(Double.toString(lokasiAkhir.getY()));
        inputLokasiAkhirNamaText = new JLabel(lokasiAkhir.getNama());
        inputLokasiAkhirKeteranganText = new JLabel(lokasiAkhir.getKeteranganLokasi());
        inputPenggunaAwalText = new JTextField("Nama Pengguna Awal");
        inputPenggunaAkhirText = new JTextField("Nama Pengguna Akhir");
        tipeLayananList = new JComboBox<>();
        tipeLayananList.setModel(new DefaultComboBoxModel<>(TipeLayanan.values()));
        tipeLayananList.setSelectedIndex(0);
        // Setup listerner
        pesanButton.setActionCommand("pesan");
        pesanButton.addActionListener(this);
        selesaiButton.setActionCommand("selesai");
        selesaiButton.addActionListener(this);
        batalButton.setActionCommand("batal");
        batalButton.addActionListener(this);
        selectOnFocus(inputPenggunaAwalText);
        selectOnFocus(inputPenggunaAkhirText);
        // Setup Layout
        GroupLayout layout = new GroupLayout(container);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        container.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(titleLabel)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputTipeLayananLabel)
                    .addComponent(tipeLayananList)
                    .addComponent(tipeLayananLabel)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLokasiAwalLabel)
                    .addComponent(inputLokasiAwalXText)
                    .addComponent(inputLokasiAwalYText)
                    .addComponent(inputLokasiAwalNamaText)
                    .addComponent(inputLokasiAwalKeteranganText)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLokasiAkhirLabel)
                    .addComponent(inputLokasiAkhirXText)
                    .addComponent(inputLokasiAkhirYText)
                    .addComponent(inputLokasiAkhirNamaText)
                    .addComponent(inputLokasiAkhirKeteranganText)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPenggunaAwalLabel)
                    .addComponent(inputPenggunaAwalText)
                    .addComponent(penggunaAwalLabel)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPenggunaAkhirLabel)
                    .addComponent(inputPenggunaAkhirText)
                    .addComponent(penggunaAkhirLabel)                   
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputBiayaLabel)
                    .addComponent(biayaLabel)                 
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pesanButton)              
                    .addComponent(selesaiButton)
                    .addComponent(batalButton)
                )
        );
        layout.linkSize(inputBiayaLabel, inputPenggunaAkhirLabel, inputPenggunaAwalLabel, inputLokasiAkhirLabel, inputLokasiAwalLabel, inputTipeLayananLabel);
        layout.linkSize(inputPenggunaAwalText, inputPenggunaAkhirText, tipeLayananList);
        layout.linkSize(pesanButton, selesaiButton, batalButton);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputTipeLayananLabel)
                    .addComponent(tipeLayananList,      GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipeLayananLabel)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputLokasiAwalLabel)
                    .addComponent(inputLokasiAwalXText)
                    .addComponent(inputLokasiAwalYText)
                    .addComponent(inputLokasiAwalNamaText)
                    .addComponent(inputLokasiAwalKeteranganText)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputLokasiAkhirLabel)
                    .addComponent(inputLokasiAkhirXText)
                    .addComponent(inputLokasiAkhirYText)
                    .addComponent(inputLokasiAkhirNamaText)
                    .addComponent(inputLokasiAkhirKeteranganText)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPenggunaAwalLabel)
                    .addComponent(inputPenggunaAwalText,    GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.PREFERRED_SIZE)
                    .addComponent(penggunaAwalLabel)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPenggunaAkhirLabel)
                    .addComponent(inputPenggunaAkhirText,   GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.PREFERRED_SIZE,
                                                            GroupLayout.PREFERRED_SIZE)
                    .addComponent(penggunaAkhirLabel)                   
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputBiayaLabel)
                    .addComponent(biayaLabel)                 
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(pesanButton)              
                    .addComponent(selesaiButton)
                    .addComponent(batalButton)
                )
        );
        // Add component
        container.add(titleLabel);
        container.add(inputLokasiAwalLabel);
        container.add(inputLokasiAkhirLabel);
        container.add(inputPenggunaAwalLabel);
        container.add(inputPenggunaAkhirLabel);
        container.add(inputBiayaLabel);
        container.add(penggunaAwalLabel);
        container.add(penggunaAkhirLabel);
        container.add(biayaLabel);
        container.add(tipeLayananLabel);
        container.add(pesanButton);
        container.add(selesaiButton);
        container.add(batalButton);
        container.add(inputLokasiAwalXText);
        container.add(inputLokasiAwalYText);
        container.add(inputLokasiAwalNamaText);
        container.add(inputLokasiAwalKeteranganText);
        container.add(inputLokasiAkhirXText);
        container.add(inputLokasiAkhirYText);
        container.add(inputLokasiAkhirNamaText);
        container.add(inputLokasiAkhirKeteranganText);
        container.add(inputPenggunaAwalText);
        container.add(inputPenggunaAkhirText);
        container.add(tipeLayananList);
        // Visibility
        setVisible(true);
        if(pesanan != null){
            inputPenggunaAwalText.setVisible(false);
            inputPenggunaAkhirText.setVisible(false);
            tipeLayananList.setVisible(false);
            pesanButton.setVisible(false);
        }else {
            penggunaAwalLabel.setVisible(false);
            penggunaAkhirLabel.setVisible(false);
            inputBiayaLabel.setVisible(false);
            biayaLabel.setVisible(false);
            batalButton.setVisible(false);
            selesaiButton.setVisible(false);
            tipeLayananLabel.setVisible(false);
            biayaLabel.setText(Double.toString(pesanan.getBiaya()));
            if(((TipeLayanan)tipeLayananList.getSelectedItem()).equals(TipeLayanan.ANTAR_ORANG)){
                inputPenggunaAkhirText.setText("");
            }else if(((TipeLayanan)tipeLayananList.getSelectedItem()).equals(TipeLayanan.ANTAR_BARANG)){
                
            }else {
                
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("pesan".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
                if(((TipeLayanan)tipeLayananList.getSelectedItem()).equals(TipeLayanan.ANTAR_ORANG)){
                    watchDog.pesananPesan((TipeLayanan)tipeLayananList.getSelectedItem(), lokasiAwal, lokasiAkhir, inputPenggunaAwalText.getText());
                }else {
                    watchDog.pesananPesan((TipeLayanan)tipeLayananList.getSelectedItem(), lokasiAwal, lokasiAkhir, inputPenggunaAwalText.getText(), inputPenggunaAkhirText.getText());
                }
                dispose();
            }catch(Exception bad){
                
            }
        } else if("batal".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
                watchDog.pesananBatal();
                dispose();
            }catch(Exception bad){
                
            }
        } else if("selesai".equals(e.getActionCommand())){
            try{
                Thread.sleep(500);
                watchDog.pesananSelesai();
                dispose();
            }catch(Exception bad){
                
            }
        }
    }
    
    private void selectOnFocus(JTextField textComponent){
        textComponent.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
                textComponent.selectAll();
            }
        });
    }
}
