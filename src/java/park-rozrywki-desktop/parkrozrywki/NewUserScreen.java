
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
    JFrame frame = new JFrame("Dodawania użytkownika");
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


    NewUserScreen()
    {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogo = new JButton(new ImageIcon("src/resources/img/logo.png"));
        btnLogo.setBounds(90, 40, 200, 70);
        btnLogo.setBorderPainted(false);
        btnLogo.setContentAreaFilled(false);
        frame.add(btnLogo);



        tfName= new JTextField();
        tfName.setBounds(50,130,200,40);
        frame.add(tfName);

        lName = new JLabel();
        lName.setText("Imie:");
        lName.setLocation(50,100 );
        lName.setSize(100, 40);
        frame.add(lName);

        tfSurname= new JTextField();
        tfSurname.setBounds(50,205,200,40);
        frame.add(tfSurname);

        lSurname = new JLabel();
        lSurname.setText("Nazwisko:");
        lSurname.setLocation(50,175 );
        lSurname.setSize(100, 40);
        frame.add(lSurname);

        tfLogin= new JTextField();
        tfLogin.setBounds(50,280,200,40);
        frame.add(tfLogin);

        lLogin = new JLabel();
        lLogin.setText("Login:");
        lLogin.setLocation(50,250 );
        lLogin.setSize(100, 40);
        frame.add(lLogin);

        tfPassword= new JTextField();
        tfPassword.setBounds(50,355,200,40);
        frame.add(tfPassword);

        lPassword = new JLabel();
        lPassword.setText("Hasło:");
        lPassword.setLocation(50,325 );
        lPassword.setSize(100, 40);
        frame.add(lPassword);

        lType = new JLabel();
        lType.setText("Typ pracownika:");
        lType.setLocation(50,425 );
        lType.setSize(100, 40);
        frame.add(lType);

        cType=new JComboBox(typy);
        cType.setLocation(150,425);
        cType.setSize(100,40);
        cType.addActionListener(this);
        frame.add(cType);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnLogin.png"));
        btnAdd.setBounds(25, 475, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }});
        frame.add(btnAdd);

        btnReturn = new JButton(new ImageIcon("src/resources/img/btnLogin.png"));
        btnReturn.setBounds(175, 475, 160, 56);
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

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}