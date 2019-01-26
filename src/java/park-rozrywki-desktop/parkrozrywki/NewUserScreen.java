
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewUserScreen extends JFrame implements ActionListener {
    String[] typy={"Admin","Kierownik","Obsługa","Mechannik","Elektryk","Informatyk"};
    JFrame frame = new JFrame("Eleden | Dodawania użytkownika");
    static final int width = 400;
    static final int height = 600;
    private JButton btnAdd;
    private JButton btnReturn;
    private JButton btnLogo;

    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfLogin;
    private JTextField tfPassword;

    private JLabel lName;
    private JLabel lSurname;
    private JLabel lLogin;
    private JLabel lPassword;
    private JLabel lType;

    private JComboBox cType;

    /** prywatna zmienna typu JLabel - tlo aplikacji, w tym przypadku 400x600*/
    protected JLabel background;
    /** ikonka programu */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");


    NewUserScreen()
    {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfName= new JTextField();
        tfName.setBounds(170,170,200,40);
        frame.add(tfName);

        lName = new JLabel();
        lName.setText("Username:");
        lName.setBounds(20,170,200,40);
        frame.add(lName);

        tfSurname= new JTextField();
        tfSurname.setBounds(170,220,200,40);
        frame.add(tfSurname);

        lSurname = new JLabel();
        lSurname.setText("Surname:");
        lSurname.setBounds(20,220,200,40);
        frame.add(lSurname);

        tfLogin= new JTextField();
        tfLogin.setBounds(170,270,200,40);
        frame.add(tfLogin);

        lLogin = new JLabel();
        lLogin.setText("Login:");
        lLogin.setBounds(20,270,200,40);
        frame.add(lLogin);

        tfPassword= new JTextField();
        tfPassword.setBounds(170,320,200,40);
        frame.add(tfPassword);

        lPassword = new JLabel();
        lPassword.setText("Password:");
        lPassword.setBounds(20,320,200,40);
        frame.add(lPassword);

        lType = new JLabel();
        lType.setText("Category:");
        lType.setBounds(20,370,200,40);
        frame.add(lType);

        cType=new JComboBox(typy);
        cType.setBounds(170,370,200,40);
        cType.addActionListener(this);
        frame.add(cType);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnAdd.png"));
        btnAdd.setBounds(20, 450, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addNewUser(tfLogin.getText(),tfName.getText(),tfSurname.getText(),tfPassword.getText(),cType.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "Nowy uzytkownik zostal pomyslnie dodany do systemu!", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                frame.setVisible(false);
                new NewUserScreen();
            }
        });
        frame.add(btnAdd);

        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(210, 450, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new AdminScreen();
            }});
        frame.add(btnReturn);

        background = new JLabel(new ImageIcon("src/resources/img/background400x600.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }

    public void addNewUser(String login,String imie, String nazwisko,String pass,int typ){
        Client client = new Client("localhost",4821);
        ClientManager clientManager = new ClientManager();

        Pracownik pracownik = new Pracownik(0,login,imie,pass,nazwisko,typ+1);
        ClientManager.clientSender.sendToServer(ServerOperation.addPracownik,pracownik);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}