
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

public class LoginScreen extends JFrame implements ActionListener {

    /**
     * glowny screen - logowanie do panelu admina
     */
    JFrame frame = new JFrame("Panel administracyjny");
    /**
     * zmienna typu static final int, okresla szerrokosc okna
     */
    static final int width = 400;
    /**
     * zmienna typu static final int, okresla wysokosc okna
     */
    static final int height = 500;
    /**
     * zmienna typu Jbutton - logowanie
     */
    private JButton btnLogin;
    /**
     * zmienna typu Jbutton - logo
     */
    private JButton btnLogo;
    /**
     * pole tekstowe, w ktorym miejscu uzytkownik powinien wpisac swoj login
     */
    private JTextField tfUsername;
    /**
     * pole tekstowe typu JpasswordField, w ktorym uzytkownik wpisuje swoje haslo do konta, kazdy znak jest widoczny na ekranie jako gwiazdka co ma na celu ukrywanie hasla
     */
    private JPasswordField pfPassword;
    /**
     * zmienna typu JLable - wyswietlajaca 'username'
     */
    private JLabel lusername;
    /**
     * zmienna typu JLable - wyswietlajaca 'password'
     */
    private JLabel lpassword;
    /**
     * ikonka programu
     */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    Pracownik pracownik = null;

    LoginScreen() {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogin = new JButton(new ImageIcon("src/resources/img/btnLogin.png"));
        btnLogin.setBounds(100, 350, 160, 56);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(this);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Client client = new Client("localhost", 4821);
                ClientManager clientManager = new ClientManager();

                String password = new String(pfPassword.getPassword());
                String lancuch = tfUsername.getText() + " " + password;

                pracownik = (Pracownik) ClientManager.clientSender.sendToServer(ServerOperation.getSPracownik, (Object) lancuch);

                if (pracownik == null) {
                    JOptionPane.showMessageDialog(null, "Haslo lub nazwa uzytkownika jest nieprawidlowa", "Notyfikator", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (pracownik.getIdTyp() == 1) {
                        JOptionPane.showMessageDialog(null, "Zostales prawidlowo zalogowany do konta administora", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                        new AdminScreen();
                    } else if (pracownik.getIdTyp() == 2) {
                        JOptionPane.showMessageDialog(null, "Zostales prawidlowo zalogowany do konta kierowniczego", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                        new ManagerScreen(pracownik);
                    } else if (pracownik.getIdTyp() == 3) {
                        JOptionPane.showMessageDialog(null, "Zostales prawidlowo zalogowany do konta pracowniczego", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                        new ServiceWorkerScreen(pracownik);
                    } else {
                        JOptionPane.showMessageDialog(null, "Zostales prawidlowo zalogowany do konta technicznego", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                        new TechnicalsScreen(pracownik);
                    }
                    frame.dispose();
                }


            }
        });
        frame.add(btnLogin);

        btnLogo = new JButton(new ImageIcon("src/resources/img/logo.png"));
        btnLogo.setBounds(90, 40, 200, 70);
        btnLogo.setBorderPainted(false);
        btnLogo.setContentAreaFilled(false);
        frame.add(btnLogo);

        tfUsername = new JTextField();
        tfUsername.setBounds(80, 180, 200, 42);
        frame.add(tfUsername);

        lusername = new JLabel();
        lusername.setText("Username:");
        lusername.setLocation(80, 160);
        lusername.setSize(80, 20);
        frame.add(lusername);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(80, 250, 200, 42);
        frame.add(pfPassword);

        lpassword = new JLabel();
        lpassword.setText("Password:");
        lpassword.setLocation(80, 230);
        lpassword.setSize(80, 20);
        frame.add(lpassword);

        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*String password = new String(pfPassword.getPassword());
        String lancuch = tfUsername.getText() + " " + password;

        pracownik = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getSPracownik,lancuch);

        if(pracownik == null){
            System.out.println("!!!Wrong login or password!!!");
        } else {
            System.out.println("Succesful");
        }*/
    }
}

