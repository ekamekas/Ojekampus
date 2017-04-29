import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TungguGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JLabel inputIDLabel;
    JLabel infoPesananLabel;
    JButton inputIDButton;
    JButton pesananTerimaButton;
    JButton pesananTolakButton;
    JButton pesananBatalButton;
    JTextField inputIDText;
    JTextField statusPesananText;
    int idPelanggan = -1;
    public TungguGUI(){
        super("Customer Menunggu");
        setSize( 300, 300 );
        setDefaultCloseOperation( this.DISPOSE_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Customer Menunggu");
        inputIDLabel = new JLabel("ID : ");
        infoPesananLabel = new JLabel("Info Pesanan");
        inputIDButton = new JButton("Enter");
        pesananTerimaButton = new JButton("Accept");
        pesananTolakButton = new JButton("Decline");
        pesananBatalButton = new JButton("Delete");
        inputIDText = new JTextField("No ID", (int)mainPane.getPreferredSize().getWidth());
        statusPesananText = new JTextField("Status", (int)mainPane.getPreferredSize().getWidth());
        add(titleLabel);
        addComponentToPane(mainPane, inputIDLabel);
        addComponentToPane(mainPane, infoPesananLabel);
        addComponentToPane(mainPane, inputIDButton);
        addComponentToPane(mainPane, pesananTerimaButton);
        addComponentToPane(mainPane, pesananTolakButton);
        addComponentToPane(mainPane, pesananBatalButton);
        addComponentToPane(mainPane, inputIDText);
        addComponentToPane(mainPane, statusPesananText);
        // End components
        // Layout
        getContentPane().setLayout(new GridBagLayout());
        createGroupPanel(mainPane);
        // Listener
        selectOnFocus(inputIDText);
        selectOnFocus(statusPesananText);
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
                            else{
                                idPelanggan = Integer.parseInt(inputIDText.getText());
                                if(DatabasePesanan.getPesanan(DatabaseUser.getUserPelanggan(idPelanggan)) == null)
                                    throw new PesananTidakDitemukanException(DatabasePesanan.getPesanan(DatabaseUser.getUserPelanggan(idPelanggan)));
                                else {
                                    infoPesananLabel.setText("Dipesan Oleh : " + DatabasePesanan.getPesanan(DatabaseUser.getUserPelanggan(idPelanggan)).getPelanggan().getNama() + "Dilayani Oleh : " + DatabasePesanan.getPesanan(DatabaseUser.getUserPelanggan(idPelanggan)).getPelayan().getNama());
                                    statusPesananText.setText(DatabasePesanan.getPesanan(DatabaseUser.getUserPelanggan(idPelanggan)).getFinalStatus());
                                }
                            }
                        } catch(NumberFormatException | PesananTidakDitemukanException exception){
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
        pesananTerimaButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println();
            }
        });
        pesananTolakButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(idPelanggan != -1)
                    Administrasi.pesananDibatalkan(DatabaseUser.getUserPelanggan(idPelanggan));
            }
        });
        pesananBatalButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(idPelanggan != -1){
                    try {
                        DatabasePesanan.hapusPesanan(DatabaseUser.getUserPelanggan(idPelanggan));
                    } catch(PesananOlehPelangganTidakDitemukanException exception) {
                        System.out.println(exception.getMessage());
                    }
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
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputIDLabel,         GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDText,          GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDButton,        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                )                              
                .addComponent(infoPesananLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(statusPesananText,GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pesananTerimaButton,  GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesananTolakButton,   GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesananBatalButton,   GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                )                                
        );
        layout.linkSize(pesananTerimaButton, pesananTolakButton, pesananBatalButton);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputIDLabel,         GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDText,          GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputIDButton,        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                )                              
                .addComponent(infoPesananLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(statusPesananText,GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(pesananTerimaButton,  GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesananTolakButton,   GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesananBatalButton,   GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                )
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
