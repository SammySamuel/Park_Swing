import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminScreen extends JFrame implements ActionListener{

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Panel administracyjny");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 400;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 500;
    /** zmienna typu Jbutton - wylogowywanie */
    private JButton btnLogout;
    /** zmienna typu Jbutton - dodawanie nowego pracownika */
    private JButton addUser;
    /** zmienna typu Jbutton - usuwanie pracownika */
    private JButton deleteUser;
    /** zmienna typu Jbutton - dodawanie nowej atrakcji */
    private JButton addAttraction;
    /** zmienna typu JLabel - tlo programu */
    protected JLabel background;

    AdminScreen(){

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogout = new JButton((new ImageIcon("src/resources/img/btnLogout.png")));
        btnLogout.setBounds(100,370,160,56);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.addActionListener(this);
        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Zostales wylogowany z konta administratora", "Notyfikator", JOptionPane.PLAIN_MESSAGE);
                new LoginScreen();
                frame.dispose();
            }
        });
        frame.add(btnLogout);

        addUser = new JButton(new ImageIcon("src/resources/img/btnNewUser.png"));
        addUser.setBounds(100,300,160,56);
        addUser.setBorderPainted(false);
        addUser.setContentAreaFilled(false);
        addUser.addActionListener(this);
        addUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(addUser);

        deleteUser = new JButton(new ImageIcon("src/resources/img/btnRemoveUser.png"));
        deleteUser.setBounds(100,230,160,56);
        deleteUser.setBorderPainted(false);
        deleteUser.setContentAreaFilled(false);
        deleteUser.addActionListener(this);
        deleteUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(deleteUser);

        addAttraction = new JButton(new ImageIcon("src/resources/img/btnAddAttraction.png"));
        addAttraction.setBounds(100,160,160,56);
        addAttraction.setBorderPainted(false);
        addAttraction.setContentAreaFilled(false);
        addAttraction.addActionListener(this);
        addAttraction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(addAttraction);

        background = new JLabel(new ImageIcon("src/resources/img/background.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}

