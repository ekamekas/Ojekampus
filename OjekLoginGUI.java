import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OjekLoginGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JLabel inputIDLabel;
    JLabel infoPesananLabel;
    JButton inputIDButton;
    JButton pesananTerimaButton;
    JButton pesananTolakButton;
    JTextField inputIDText;
    JTextField statusPesananText;
    int idOjek;
    public OjekLoginGUI(){
        super("Ojek Login");
        setSize( 300, 300 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Ojek Login");
        inputIDLabel = new JLabel("ID : ");
        infoPesananLabel = new JLabel("Info Pesanan");
        inputIDButton = new JButton("Enter");
        pesananTerimaButton = new JButton("Accept");
        pesananTolakButton = new JButton("Decline");
        inputIDText = new JTextField("No ID", (int)mainPane.getPreferredSize().getWidth());
        statusPesananText = new JTextField("Status", (int)mainPane.getPreferredSize().getWidth());
        add(titleLabel);
        addComponentToPane(mainPane, inputIDLabel);
        addComponentToPane(mainPane, infoPesananLabel);
        addComponentToPane(mainPane, inputIDButton);
        addComponentToPane(mainPane, pesananTerimaButton);
        addComponentToPane(mainPane, pesananTolakButton);
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
                            if(DatabaseUser.getUserOjek(Integer.parseInt(inputIDText.getText())) == null)
                                JOptionPane.showMessageDialog(null, "ID tidak ditemukan", "alert", JOptionPane.WARNING_MESSAGE);
                            else {
                                idOjek = Integer.parseInt(inputIDText.getText());
                                statusPesananText.setText(DatabaseUser.getUserOjek(idOjek).getStatus().toString());
                                if(DatabaseUser.getUserOjek(idOjek).getPesanan() == null)
                                    throw new PesananOlehOjekTidakDitemukanException(DatabaseUser.getUserOjek(idOjek));
                                else {    
                                    infoPesananLabel.setText("Dipesan Oleh : " + DatabaseUser.getUserOjek(idOjek).getPesanan().getPelanggan().getNama() + "Tipe Layanan : " + DatabaseUser.getUserOjek(idOjek).getPesanan().getTipeLayanan());
                                }
                            }
                        } catch(NumberFormatException | PesananOlehOjekTidakDitemukanException exception){
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
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
                Administrasi.pesananDibatalkan(DatabaseUser.getUserOjek(idOjek));
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
                    .addComponent(inputIDLabel)
                    .addComponent(inputIDText)
                    .addComponent(inputIDButton)
                )                              
                .addComponent(infoPesananLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(statusPesananText,GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pesananTerimaButton)
                    .addComponent(pesananTolakButton)
                )                                
        );
        layout.linkSize(pesananTerimaButton, pesananTolakButton);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputIDLabel)
                    .addComponent(inputIDText)
                    .addComponent(inputIDButton)
                )                              
                .addComponent(infoPesananLabel, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addComponent(statusPesananText,GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(pesananTerimaButton)
                    .addComponent(pesananTolakButton)
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
