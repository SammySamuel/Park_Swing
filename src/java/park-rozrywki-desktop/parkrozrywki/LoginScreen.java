
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JFrame implements ActionListener {

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Panel administracyjny");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 400;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 500;
    /** zmienna typu Jbutton - logowanie */
    private JButton btnLogin;
    /** zmienna typu Jbutton - logo */
    private JButton btnLogo;
    /** pole tekstowe, w ktorym miejscu uzytkownik powinien wpisac swoj login  */
    private JTextField tfUsername;
    /** pole tekstowe typu JpasswordField, w ktorym uzytkownik wpisuje swoje haslo do konta, kazdy znak jest widoczny na ekranie jako gwiazdka co ma na celu ukrywanie hasla */
    private JPasswordField pfPassword;
    /** zmienna typu JLable - wyswietlajaca 'username' */
    private JLabel lusername;
    /** zmienna typu JLable - wyswietlajaca 'password' */
    private JLabel lpassword;


   LoginScreen(){

       frame.setLayout(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       btnLogin = new JButton(new ImageIcon("src/resources/img/btnLogin.png"));
       btnLogin.setBounds(100,350,160,56);
       btnLogin.setBorderPainted(false);
       btnLogin.setContentAreaFilled(false);
       btnLogin.addActionListener(this);
       btnLogin.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               new AdminScreen();
               frame.dispose();
           }
       });
       frame.add(btnLogin);

       btnLogo = new JButton(new ImageIcon("src/resources/img/logo.png"));
       btnLogo.setBounds(90,40,200,70);
       btnLogo.setBorderPainted(false);
       btnLogo.setContentAreaFilled(false);
       frame.add(btnLogo);

       tfUsername = new JTextField();
       tfUsername.setBounds(80,180,200,42);
       String user=tfUsername.getText();
       frame.add(tfUsername);

       lusername = new JLabel();
       lusername.setText("Username:");
       lusername.setLocation(80,160);
       lusername.setSize(80,20);
       frame.add(lusername);

       pfPassword = new JPasswordField();
       pfPassword.setBounds(80,250,200,42);
       frame.add(pfPassword);

       lpassword = new JLabel();
       lpassword.setText("Password:");
       lpassword.setLocation(80,230);
       lpassword.setSize(80,20);
       frame.add(lpassword);

       frame.setVisible(true);
       frame.setSize(width,height);
       frame.setResizable(false);
      // frame.getContentPane().setBackground(new Color(234,234,234));
   }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

