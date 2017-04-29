import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PesananGUI extends JFrame
{
    // instance variables - replace the example below with your own
    int count = 0;
    JPanel mainPane;
    JLabel titleLabel;
    JLabel inputIDLabel;
    JLabel inputTipeLayananLabel;
    JLabel inputLokasiAwalLabel;
    JLabel inputLokasiAkhirLabel;
    JLabel inputPenggunaAwalLabel;
    JLabel inputPenggunaAkhirLabel;
    JLabel inputBiayaLabel;
    JButton inputIDButton;
    JButton pesanButton;
    JTextField inputIDText;
    JTextField inputLokasiAwalXText;
    JTextField inputLokasiAwalYText;
    JTextField inputLokasiAwalNamaText;
    JTextField inputLokasiAwalKeteranganText;
    JTextField inputLokasiAkhirXText;
    JTextField inputLokasiAkhirYText;
    JTextField inputLokasiAkhirNamaText;
    JTextField inputLokasiAkhirKeteranganText;
    JTextField inputPenggunaAwalText;
    JTextField inputPenggunaAkhirText;
    JTextField inputBiayaText;
    JComboBox<TipeLayanan> tipeLayananList;
    public PesananGUI(){
        super("Customer GUI");
        setSize( 400, 350 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Pemesanan Customer");
        inputIDLabel = new JLabel("ID : ");
        inputTipeLayananLabel = new JLabel("Tipe Layanan : ");
        inputLokasiAwalLabel = new JLabel("Lokasi Awal : ");
        inputLokasiAkhirLabel = new JLabel("Lokasi Akhir : ");
        inputPenggunaAwalLabel = new JLabel("Pengguna Awal : ");
        inputPenggunaAkhirLabel = new JLabel("Pengguna Ahir : ");
        inputBiayaLabel = new JLabel("Biaya : ");
        inputIDButton = new JButton("Enter");
        pesanButton = new JButton("Register");
        inputIDText = new JTextField("ID", (int)mainPane.getPreferredSize().getWidth());
        inputLokasiAwalXText = new JTextField("X", (int)mainPane.getPreferredSize().getWidth()/4);
        inputLokasiAwalYText = new JTextField("Y", (int)mainPane.getPreferredSize().getWidth()/4);
        inputLokasiAwalNamaText = new JTextField("NamaLokasi", (int)mainPane.getPreferredSize().getWidth()/2);
        inputLokasiAwalKeteranganText = new JTextField("Keterangan", (int)mainPane.getPreferredSize().getWidth()/2);
        inputLokasiAkhirXText = new JTextField("X", (int)mainPane.getPreferredSize().getWidth()/4);
        inputLokasiAkhirYText = new JTextField("Y", (int)mainPane.getPreferredSize().getWidth()/4);
        inputLokasiAkhirNamaText = new JTextField("NamaLokasi", (int)mainPane.getPreferredSize().getWidth()/2);
        inputLokasiAkhirKeteranganText = new JTextField("Keterangan", (int)mainPane.getPreferredSize().getWidth()/2);
        inputPenggunaAwalText = new JTextField("Nama Pengguna Awal", (int)mainPane.getPreferredSize().getWidth());
        inputPenggunaAkhirText = new JTextField("Nama Pengguna Akhir", (int)mainPane.getPreferredSize().getWidth());
        inputBiayaText = new JTextField("Biaya", (int)mainPane.getPreferredSize().getWidth());
        tipeLayananList = new JComboBox<>();
        tipeLayananList.setModel(new DefaultComboBoxModel<>(TipeLayanan.values()));
        tipeLayananList.setSelectedIndex(0);
        add(titleLabel);
        //addComponentToPane(mainPane, inputIDLabel);
        addComponentToPane(mainPane, titleLabel);
        addComponentToPane(mainPane, inputIDLabel);
        addComponentToPane(mainPane, inputLokasiAwalLabel);
        addComponentToPane(mainPane, inputLokasiAkhirLabel);
        addComponentToPane(mainPane, inputPenggunaAwalLabel);
        addComponentToPane(mainPane, inputPenggunaAkhirLabel);
        addComponentToPane(mainPane, inputBiayaLabel);
        addComponentToPane(mainPane, inputIDButton);
        addComponentToPane(mainPane, pesanButton);
        addComponentToPane(mainPane, inputIDText);
        addComponentToPane(mainPane, inputLokasiAwalXText);
        addComponentToPane(mainPane, inputLokasiAwalYText);
        addComponentToPane(mainPane, inputLokasiAwalNamaText);
        addComponentToPane(mainPane, inputLokasiAwalKeteranganText);
        addComponentToPane(mainPane, inputLokasiAkhirXText);
        addComponentToPane(mainPane, inputLokasiAkhirYText);
        addComponentToPane(mainPane, inputLokasiAkhirNamaText);
        addComponentToPane(mainPane, inputLokasiAkhirKeteranganText);
        addComponentToPane(mainPane, inputPenggunaAwalText);
        addComponentToPane(mainPane, inputPenggunaAkhirText);
        addComponentToPane(mainPane, inputBiayaText);
        addComponentToPane(mainPane, tipeLayananList);
        // End components
        // Layout
        getContentPane().setLayout(new GridBagLayout());
        createGroupPanel(mainPane);
        // Listener
        selectOnFocus(inputIDText);
        selectOnFocus(inputLokasiAwalXText);
        selectOnFocus(inputLokasiAwalYText);
        selectOnFocus(inputLokasiAwalNamaText);
        selectOnFocus(inputLokasiAwalKeteranganText);
        selectOnFocus(inputLokasiAkhirXText);
        selectOnFocus(inputLokasiAkhirYText);
        selectOnFocus(inputLokasiAkhirNamaText);
        selectOnFocus(inputLokasiAkhirKeteranganText);
        selectOnFocus(inputPenggunaAwalText);
        selectOnFocus(inputPenggunaAkhirText);
        selectOnFocus(inputBiayaText);
        inputIDButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(
                    !inputIDText.getText().equals("")
                ){
                    if(
                        !inputIDText.getText().equals("ID")
                    ){
                        try {
                            if(DatabaseUser.getUserPelanggan(Integer.parseInt(inputIDText.getText())) == null)
                                JOptionPane.showMessageDialog(null, "ID tidak ditemukan", "alert", JOptionPane.WARNING_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "ID ditemukan", "alert", JOptionPane.INFORMATION_MESSAGE);
                        } catch(NumberFormatException exception){
                            JOptionPane.showMessageDialog(null, "ID merupakan angka", "alert", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ID harus diisi", "alert", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID tidak boleh kosong", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pesanButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(
                    !inputIDText.getText().equals("") ||
                    !inputLokasiAwalXText.getText().equals("") ||
                    !inputLokasiAwalYText.getText().equals("") ||
                    !inputLokasiAwalNamaText.getText().equals("") ||
                    !inputLokasiAwalKeteranganText.getText().equals("") ||
                    !inputLokasiAkhirXText.getText().equals("") ||
                    !inputLokasiAkhirYText.getText().equals("") ||
                    !inputLokasiAkhirNamaText.getText().equals("") ||
                    !inputLokasiAkhirKeteranganText.getText().equals("") ||
                    !inputPenggunaAwalText.getText().equals("") ||
                    !inputPenggunaAkhirText.getText().equals("") ||
                    !inputBiayaText.getText().equals("")
                ){
                    if(
                        !inputIDText.getText().equals("ID") ||
                        !inputLokasiAwalXText.getText().equals("X") ||
                        !inputLokasiAwalYText.getText().equals("Y") ||
                        !inputLokasiAwalNamaText.getText().equals("NamaLokasi") ||
                        !inputLokasiAwalKeteranganText.getText().equals("Keterangan") ||
                        !inputLokasiAkhirXText.getText().equals("X") ||
                        !inputLokasiAkhirYText.getText().equals("Y") ||
                        !inputLokasiAkhirNamaText.getText().equals("NamaLokasi") ||
                        !inputLokasiAkhirKeteranganText.getText().equals("Keterangan") ||
                        !inputPenggunaAwalText.getText().equals("Nama Pengguna Awal") ||
                        !inputPenggunaAkhirText.getText().equals("Nama Pengguna Akhir") ||
                        !inputBiayaText.getText().equals("Biaya")
                    ){
                        try {
                            DatabasePesanan.addPesanan(new Pesanan(
                                DatabaseUser.getUserPelanggan(Integer.parseInt(inputIDText.getText())),
                                (TipeLayanan)tipeLayananList.getSelectedItem(),
                                new Lokasi(inputLokasiAwalNamaText.getText(), Integer.parseInt(inputLokasiAwalXText.getText()), Integer.parseInt(inputLokasiAwalYText.getText()), inputLokasiAwalKeteranganText.getText()),
                                new Lokasi(inputLokasiAkhirNamaText.getText(), Integer.parseInt(inputLokasiAkhirXText.getText()), Integer.parseInt(inputLokasiAkhirYText.getText()), inputLokasiAkhirKeteranganText.getText()),
                                inputPenggunaAwalText.getText(),
                                inputPenggunaAwalText.getText())
                            );
                            Administrasi.jalankanSistemPenugas();
                        } catch(PesananSudahAdaException | NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Input harus diisi", "alert", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // End listener
        setVisible(this, true);
    }
    
    private void createGroupPanel(JPanel panel){
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputIDLabel,     GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDText,      GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDButton,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )                              
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputTipeLayananLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipeLayananList,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLokasiAwalLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalXText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalYText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalNamaText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalKeteranganText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLokasiAkhirLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirXText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirYText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirNamaText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirKeteranganText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPenggunaAwalLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPenggunaAwalText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPenggunaAkhirLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPenggunaAkhirText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputBiayaLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBiayaText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(pesanButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)                                
        );
        layout.linkSize(inputIDLabel, inputTipeLayananLabel, inputLokasiAwalLabel, inputLokasiAkhirLabel, inputPenggunaAwalLabel, inputPenggunaAkhirLabel, inputBiayaLabel);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputIDLabel,     GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDText,      GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDButton,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )                              
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputTipeLayananLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipeLayananList,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputLokasiAwalLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalXText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalYText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalNamaText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAwalKeteranganText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputLokasiAkhirLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirXText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirYText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirNamaText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLokasiAkhirKeteranganText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPenggunaAwalLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPenggunaAwalText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPenggunaAkhirLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPenggunaAkhirText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputBiayaLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBiayaText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(pesanButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
        );
    }
    
    private void addComponentToPane(JPanel pane, JComponent component){
        pane.add(component);
    }
    
    private void selectOnFocus(JTextField textComponent){
        textComponent.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
                textComponent.selectAll();
            }
        });
    }
    
    public void setVisible(Container container, Boolean status){
        container.setVisible(status);
    }
}