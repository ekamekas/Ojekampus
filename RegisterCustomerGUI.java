import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CustomerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegisterCustomerGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JLabel inputNamaLabel;
    JLabel inputTelpLabel;
    JLabel inputEmailLabel;
    JLabel inputDobLabel;
    JButton registerButton;
    JTextField inputNamaText;
    JTextField inputTelpText;
    JTextField inputEmailText;
    JTextField inputDobText;
    public RegisterCustomerGUI(){
        super("Registrasi Customer");
        setSize( 300, 300 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Registrasi Customer");
        inputNamaLabel = new JLabel("Nama : ");
        inputTelpLabel = new JLabel("Telp : ");
        inputEmailLabel = new JLabel("Email : ");
        inputDobLabel = new JLabel("DoB : ");
        registerButton = new JButton("Register");
        inputNamaText = new JTextField("Nama", (int)mainPane.getPreferredSize().getWidth());        
        inputTelpText = new JTextField("1234567", (int)mainPane.getPreferredSize().getWidth());
        inputEmailText = new JTextField("maseka@site.id", (int)mainPane.getPreferredSize().getWidth());
        inputDobText = new JTextField("dd/MM/yyyy", (int)mainPane.getPreferredSize().getWidth());
        add(titleLabel);
        addComponentToPane(mainPane, inputNamaLabel);
        addComponentToPane(mainPane, inputTelpLabel);
        addComponentToPane(mainPane, inputEmailLabel);
        addComponentToPane(mainPane, inputDobLabel);
        addComponentToPane(mainPane, registerButton);
        addComponentToPane(mainPane, inputNamaText);
        addComponentToPane(mainPane, inputTelpText);
        addComponentToPane(mainPane, inputEmailText);
        addComponentToPane(mainPane, inputDobText);
        // End components
        // Layout
        getContentPane().setLayout(new GridBagLayout());
        createGroupPanel(mainPane);
        // Listener
        selectOnFocus(inputNamaText);
        selectOnFocus(inputTelpText);
        selectOnFocus(inputEmailText);
        selectOnFocus(inputDobText);
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(
                    !inputNamaText.getText().equals("") ||
                    !inputTelpText.getText().equals("")
                ){
                    if(
                        !inputNamaText.getText().equals("Nama") ||
                        !inputTelpText.getText().equals("1234567") ||
                        !inputEmailText.getText().equals("maseka@site.id") ||
                        !inputDobText.getText().equals("dd/MM/yyyy")
                    ){
                        try {
                            DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String dateAsString = inputDobText.getText();
                            Date date = sourceFormat.parse(dateAsString);
                            DatabaseUser.addPelanggan(new Pelanggan(
                                DatabaseUser.getIDPelangganTerakhir(),
                                inputNamaText.getText(),
                                inputTelpText.getText(),
                                inputEmailText.getText(),
                                date)
                            );
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        } catch(java.text.ParseException | NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Input harus diisi", "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong", "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
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
                    .addComponent(inputNamaLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNamaText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )                              
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputTelpLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTelpText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputEmailLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmailText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputDobLabel,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDobText,     GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)                                
        );
        layout.linkSize(inputNamaLabel, inputTelpLabel, inputEmailLabel, inputDobLabel);
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel,       GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputNamaLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNamaText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )                              
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputTelpLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTelpText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputEmailLabel,  GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmailText,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputDobLabel,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDobText,     GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
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
