import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ManagerScreen extends JFrame implements ActionListener{

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Panel administracyjny");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 400;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 500;
    /** zmienna typu Jbutton - wylogowywanie */
    private JButton btnLogout;
    /** zmienna typu Jbutton - dodawanie planow */
    private JButton addPlans;
    /** zmienna typu Jbutton - sprawdzanie raportow */
    private JButton checkRaports;
    /** zmienna typu JLabel - tlo programu */
    protected JLabel background;

    ManagerScreen(){

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
                JOptionPane.showMessageDialog(null, "Zostales wylogowany z konta kierownika", "Notyfikator", JOptionPane.PLAIN_MESSAGE);
                new AdminScreen();
                frame.dispose();
            }
        });
        frame.add(btnLogout);

        addPlans = new JButton(new ImageIcon("src/resources/img/btnAddPlans.png"));
        addPlans.setBounds(100,300,160,56);
        addPlans.setBorderPainted(false);
        addPlans.setContentAreaFilled(false);
        addPlans.addActionListener(this);
        addPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(addPlans);

        checkRaports = new JButton(new ImageIcon("src/resources/img/btnCheckReports.png"));
        checkRaports.setBounds(100,230,160,56);
        checkRaports.setBorderPainted(false);
        checkRaports.setContentAreaFilled(false);
        checkRaports.addActionListener(this);
        checkRaports.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(checkRaports);

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