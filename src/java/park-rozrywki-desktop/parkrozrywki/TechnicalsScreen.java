import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class TechnicalsScreen extends JFrame implements ActionListener{

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Panel TECHNICZNY");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 400;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 500;

    private JButton btnLogin;
    private JButton checkRaport;
    private JButton checkDayPlans;
    private JButton checkWeekPlans;


    protected JLabel background;

    TechnicalsScreen(){

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogin = new JButton((new ImageIcon("src/resources/img/btnLogout.png")));
        btnLogin.setBounds(100,370,160,56);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(this);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Zostales wylogowany z konta ", "Notyfikator", JOptionPane.PLAIN_MESSAGE);
                frame.dispose();
            }
        });
        frame.add(btnLogin);

        checkRaport = new JButton(new ImageIcon("src/resources/img/btnCheckReports.png"));
        checkRaport.setBounds(100,300,160,56);
        checkRaport.setBorderPainted(false);
        checkRaport.setContentAreaFilled(false);
        checkRaport.addActionListener(this);
        checkRaport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(checkRaport);

        checkDayPlans = new JButton(new ImageIcon("src/resources/img/btnTodayPlans.png"));
        checkDayPlans.setBounds(100,230,160,56);
        checkDayPlans.setBorderPainted(false);
        checkDayPlans.setContentAreaFilled(false);
        checkDayPlans.addActionListener(this);
        checkDayPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(checkDayPlans);

        checkWeekPlans = new JButton(new ImageIcon("src/resources/img/btnWeeklyPlans.png"));
        checkWeekPlans.setBounds(100,160,160,56);
        checkWeekPlans.setBorderPainted(false);
        checkWeekPlans.setContentAreaFilled(false);
        checkWeekPlans.addActionListener(this);
        checkWeekPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(checkWeekPlans);

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