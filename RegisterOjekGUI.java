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
public class RegisterOjekGUI extends JFrame
{
    // instance variables - replace the example below with your own
    JPanel mainPane;
    JLabel titleLabel;
    JLabel inputNamaLabel;
    JLabel inputTelpLabel;
    JLabel inputEmailLabel;
    JLabel inputDobLabel;
    JLabel inputPlatLabel;
    JLabel inputLokasiLabel;
    JButton registerButton;
    JTextField inputNamaText;
    JTextField inputTelpText;
    JTextField inputEmailText;
    JTextField inputDobText;
    JTextField inputPlatText;
    JTextField inputLokasiXText;
    JTextField inputLokasiYText;
    JTextField inputLokasiNamaText;
    JTextField inputLokasiKeteranganText;
    public RegisterOjekGUI(){
        super("Registrasi Ojek");
        setSize( 300, 350 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Containers
        mainPane = new JPanel();
        mainPane.setSize(200, 200);
        add(mainPane);
        // end container
        // Components, 
        titleLabel = new JLabel("Registrasi Ojek");
        inputNamaLabel = new JLabel("Nama : ");
        inputTelpLabel = new JLabel("Telp : ");
        inputEmailLabel = new JLabel("Email : ");
        inputDobLabel = new JLabel("DoB : ");
        inputPlatLabel = new JLabel("Plat : ");
        inputLokasiLabel = new JLabel("Lokasi : ");
        registerButton = new JButton("Register");
        inputNamaText = new JTextField("Nama", (int)mainPane.getPreferredSize().getWidth());        
        inputTelpText = new JTextField("1234567", (int)mainPane.getPreferredSize().getWidth());
        inputEmailText = new JTextField("maseka@site.id", (int)mainPane.getPreferredSize().getWidth());
        inputDobText = new JTextField("dd/MM/yyyy", (int)mainPane.getPreferredSize().getWidth());
        inputPlatText = new JTextField("A1234CA", (int)mainPane.getPreferredSize().getWidth());
        inputLokasiXText = new JTextField("X", (int)mainPane.getPreferredSize().getWidth()/3);
        inputLokasiYText = new JTextField("Y", (int)mainPane.getPreferredSize().getWidth()/3);
        inputLokasiNamaText = new JTextField("NamaLokasi", (int)mainPane.getPreferredSize().getWidth());
        inputLokasiKeteranganText = new JTextField("Keterangan", (int)mainPane.getPreferredSize().getWidth());
        add(titleLabel);
        addComponentToPane(mainPane, inputNamaLabel);
        addComponentToPane(mainPane, inputTelpLabel);
        addComponentToPane(mainPane, inputEmailLabel);
        addComponentToPane(mainPane, inputDobLabel);
        addComponentToPane(mainPane, inputPlatLabel);
        addComponentToPane(mainPane, inputLokasiLabel);
        addComponentToPane(mainPane, registerButton);
        addComponentToPane(mainPane, inputNamaText);
        addComponentToPane(mainPane, inputTelpText);
        addComponentToPane(mainPane, inputEmailText);
        addComponentToPane(mainPane, inputDobText);
        addComponentToPane(mainPane, inputPlatText);
        addComponentToPane(mainPane, inputLokasiXText);
        addComponentToPane(mainPane, inputLokasiYText);
        addComponentToPane(mainPane, inputLokasiNamaText);
        addComponentToPane(mainPane, inputLokasiKeteranganText);
        // End components
        // Layout
        getContentPane().setLayout(new GridBagLayout());
        createGroupPanel(mainPane);
        // Listener
        selectOnFocus(inputNamaText);
        selectOnFocus(inputTelpText);
        selectOnFocus(inputEmailText);
        selectOnFocus(inputDobText);
        selectOnFocus(inputPlatText);
        selectOnFocus(inputLokasiXText);
        selectOnFocus(inputLokasiYText);
        selectOnFocus(inputLokasiNamaText);
        selectOnFocus(inputLokasiKeteranganText);
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(
                    !inputNamaText.getText().equals("") ||
                    !inputTelpText.getText().equals("") ||
                    !inputPlatText.getText().equals("") ||
                    !inputLokasiXText.getText().equals("") ||
                    !inputLokasiYText.getText().equals("") ||
                    !inputLokasiNamaText.getText().equals("") ||
                    !inputLokasiKeteranganText.getText().equals("")
                ){
                    if(
                        /*!inputNamaText.getText().equals("Nama") ||
                        !inputTelpText.getText().equals("1234567") ||
                        !inputEmailText.getText().equals("maseka@site.id") ||
                        !inputDobText.getText().equals("dd/MM/yyyy") || 
                        !inputPlatText.getText().equals("") ||
                        !inputLokasiXText.getText().equals("X") ||
                        !inputLokasiYText.getText().equals("Y") ||
                        !inputLokasiNamaText.getText().equals("") ||
                        !inputLokasiKeteranganText.getText().equals("")*/
                        true
                    ){
                        try {
                            DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String dateAsString = inputDobText.getText();
                            Date date = sourceFormat.parse(dateAsString);
                            DatabaseUser.addOjek(new Ojek(
                                DatabaseUser.getIDPelangganTerakhir(),
                                inputNamaText.getText(),
                                inputTelpText.getText(),
                                inputEmailText.getText(),
                                date,
                                inputPlatText.getText(),
                                new Lokasi(
                                    inputLokasiNamaText.getText(),
                                    Integer.parseInt(inputLokasiXText.getText()),
                                    Integer.parseInt(inputLokasiYText.getText()),
                                    inputLokasiKeteranganText.getText()
                                    )
                                )
                            );
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        } catch(java.text.ParseException | NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage(), "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Input harus diisi", "Registrasi Berhasil", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input tidak boleh kosong", "Registrasi Berhasil", JOptionPane.ERROR_MESSAGE);
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
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPlatLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlatText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputLokasiLabel, GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputLokasiXText,             GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLokasiYText,             GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputLokasiNamaText,          GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLokasiKeteranganText,    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                    )
                )
                .addComponent(registerButton,   GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE)                                
        );
        layout.linkSize(inputNamaLabel, inputTelpLabel, inputEmailLabel, inputDobLabel, inputPlatLabel, inputLokasiLabel);
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
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPlatLabel,   GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlatText,    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLokasiLabel, GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(inputLokasiXText,             GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLokasiYText,             GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                    )
                    .addGroup(layout.createParallelGroup()
                        .addComponent(inputLokasiNamaText,          GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLokasiKeteranganText,    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE,
                                                                    GroupLayout.PREFERRED_SIZE)
                    )
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
