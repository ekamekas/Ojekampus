package ClientOjek;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Write a description of class RegisterGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegisterGUI extends JDialog implements ActionListener
{
    // WatchDog
    WatchDog watchDog;
    //
    JLabel inputNamaLabel;
    JLabel inputUsernameLabel;
    JLabel inputPasswordLabel;
    JLabel inputPasswordReLabel;
    JLabel inputNoTelpLabel;
    JLabel inputDobLabel;
    JLabel inputEmailLabel;
    JLabel inputNoPlatLabel;
    JLabel badLabel;
    
    JTextField inputNamaText;
    JTextField inputUsernameText;
    JPasswordField inputPasswordText;
    JPasswordField inputPasswordReText;
    JTextField inputNoTelpText;
    JTextField inputDobText;
    JTextField inputEmailText;
    JTextField inputNoPlatText;
    JButton registerButton;
    JPanel formPanel;
    /**
     * Constructor for objects of class RegisterGUI
     */
    public RegisterGUI(JFrame frame, WatchDog watchDog)
    {
        // Init super
        super(frame, "Register", Dialog.ModalityType.APPLICATION_MODAL);
        setSize(new Dimension(300, 400));
        // WatchDog
        this.watchDog = watchDog;
        //
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Setup container
        formPanel = new JPanel();
        //formPanel.setPreferredSize(new Dimension(150, 200));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Container container = getContentPane();
        // Setup components
        inputNamaLabel = new JLabel("Nama");
        inputUsernameLabel = new JLabel("Username");
        inputPasswordLabel = new JLabel("Password");
        inputPasswordReLabel = new JLabel("Password");
        inputDobLabel = new JLabel("DoB");
        inputNoTelpLabel = new JLabel("No Telp");
        JLabel badLabel = new JLabel("Input tidak sesuai");
        inputEmailLabel = new JLabel("Email");
        inputNoPlatLabel = new JLabel("NoPlat");
        
        inputNamaText = new JTextField("Mas Eka Setiawan");
        inputUsernameText = new JTextField("ekamekas");
        inputPasswordText = new JPasswordField("akesam");
        inputPasswordReText = new JPasswordField("akesam");
        inputNoTelpText = new JTextField("08787585939");
        inputDobText = new JTextField("dd/MM/yyyy");
        inputEmailText = new JTextField("mas.ekamekas@site.id");
        inputNoPlatText = new JTextField("A3902CA");
        registerButton = new JButton("Register");
        // Setup listener
        selectOnFocus(inputDobText);
        selectOnFocus(inputEmailText);
        selectOnFocus(inputNoTelpText);
        selectOnFocus(inputNoPlatText);
        new AddFocusListener(inputNamaText);
        new AddFocusListener(inputUsernameText);
        inputPasswordText.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                inputPasswordText.setText("");
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(String.valueOf(inputPasswordText.getPassword()).equals(""))
                    inputPasswordText.setText("******");
            }
        });
        inputPasswordReText.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                inputPasswordReText.setText("");
            }
            
            @Override
            public void focusLost(FocusEvent e){
                if(String.valueOf(inputPasswordReText.getPassword()).equals(""))
                    inputPasswordReText.setText("******");
            }
        });
        new AddFocusListener(inputNoTelpText);
        registerButton.setActionCommand("register");
        registerButton.addActionListener(this);
        // Setup layout
        GroupLayout layout = new GroupLayout(formPanel);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        formPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.linkSize(inputNamaLabel, inputUsernameLabel, inputPasswordLabel, inputPasswordReLabel, inputNoTelpLabel);
        layout.linkSize(inputNamaText, inputUsernameText, inputPasswordText, inputPasswordReText, inputNoTelpText);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputUsernameLabel)
                    .addComponent(inputUsernameText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPasswordLabel)
                    .addComponent(inputPasswordText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputPasswordReLabel)
                    .addComponent(inputPasswordReText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputNamaLabel)
                    .addComponent(inputNamaText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputDobLabel)
                    .addComponent(inputDobText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputNoTelpLabel)
                    .addComponent(inputNoTelpText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputEmailLabel)
                    .addComponent(inputEmailText)
                )
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputNoPlatLabel)
                    .addComponent(inputNoPlatText)
                )
                .addComponent(badLabel)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputUsernameLabel)
                    .addComponent(inputUsernameText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPasswordLabel)
                    .addComponent(inputPasswordText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputPasswordReLabel)
                    .addComponent(inputPasswordReText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputNamaLabel)
                    .addComponent(inputNamaText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputDobLabel)
                    .addComponent(inputDobText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputNoTelpLabel)
                    .addComponent(inputNoTelpText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputEmailLabel)
                    .addComponent(inputEmailText)
                )
                .addGroup(layout.createParallelGroup()
                    .addComponent(inputNoPlatLabel)
                    .addComponent(inputNoPlatText)
                )
                .addComponent(badLabel)
        );
        // Add components
        formPanel.add(inputNamaLabel);
        formPanel.add(inputUsernameLabel);
        formPanel.add(inputPasswordLabel);
        formPanel.add(inputPasswordReLabel);
        formPanel.add(inputNoTelpLabel);
        formPanel.add(inputDobLabel);
        formPanel.add(inputEmailLabel);
        formPanel.add(inputNoPlatLabel);
        formPanel.add(inputNamaText);
        formPanel.add(inputUsernameText);
        formPanel.add(inputPasswordText);
        formPanel.add(inputPasswordReText);
        formPanel.add(inputNoTelpText);
        formPanel.add(inputDobText);
        formPanel.add(inputEmailText);
        formPanel.add(inputNoPlatText);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridwidth = GridBagConstraints.REMAINDER;
        add(formPanel, constraint);
        constraint.fill = GridBagConstraints.SOUTHEAST;
        constraint.gridwidth = 2;
        add(registerButton, constraint);
        // Set visibility
        badLabel.setVisible(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if("register".equals(e.getActionCommand()))
            if(
                    !inputNamaText.getText().equals("") ||
                    !inputNoTelpLabel.getText().equals("") ||
                    String.valueOf(inputPasswordText.getPassword()).equals(String.valueOf(inputPasswordReText.getPassword())) ||
                    !inputNamaText.getText().equals("Nama") ||
                    !inputNoTelpLabel.getText().equals("1234567") ||
                    !inputEmailText.getText().equals("maseka@site.id") ||
                    !inputDobText.getText().equals("dd/MM/yyyy")
                ){
                    try {
                        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String dateAsString = inputDobText.getText();
                        Date date = sourceFormat.parse(dateAsString);
                        if(watchDog.register(
                            inputUsernameText.getText(),
                            String.valueOf(inputPasswordText.getPassword()),
                            inputNamaText.getText(),
                            date,
                            inputNoTelpText.getText(),
                            inputEmailText.getText(),
                            inputNoPlatText.getText()
                        )){
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Registrasi gagal", "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
                        }
                        dispose();    
                    } catch(java.text.ParseException | NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "Registrasi Gagal", JOptionPane.ERROR_MESSAGE);
                        dispose();
                    }                    
                }else {
                    JOptionPane.showMessageDialog(null, "Registrasi gagal", "Registrasi gagal", JOptionPane.ERROR_MESSAGE);
                }
                
    }
    
    public class AddFocusListener implements FocusListener{
        JTextField inputText;
        JPasswordField inputPassword;
        String defaultString;
        public AddFocusListener(JTextField inputText){
            this.inputText = inputText;
            defaultString = inputText.getText();
            inputText.addFocusListener(this);
        }
        
        public AddFocusListener(JPasswordField inputPassword){
            this.inputPassword = inputPassword;
            inputPassword.addFocusListener(this);
        }
        
        @Override
            public void focusGained(FocusEvent e){
                inputText.setText("");
            }
            
        @Override
        public void focusLost(FocusEvent e){
            if(inputText instanceof JPasswordField){
                if(String.valueOf(inputPassword.getPassword()).equals(""))
                    inputPassword.setText("******");
            }
            else{
                if(inputText.getText().equals(""))
                    inputText.setText(defaultString);
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
