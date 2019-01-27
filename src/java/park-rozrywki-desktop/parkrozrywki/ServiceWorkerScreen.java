import Core.Pracownik;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ServiceWorkerScreen extends JFrame implements ActionListener {

    /**
     * glowny screen - logowanie do panelu admina
     */
    JFrame frame = new JFrame("Eleden | Panel pracowniczy");
    /**
     * zmienna typu static final int, okresla szerrokosc okna
     */
    static final int width = 400;
    /**
     * zmienna typu static final int, okresla wysokosc okna
     */
    static final int height = 500;
    /**
     * zmienna typu Jbutton - wylogowywanie
     */
    private JButton btnLogout;
    /**
     * zmienna typu Jbutton - sprawdzanie planow
     */
    private JButton checkTodayPlans;
    private JButton checkWeekPlans;
    /**
     * zmienna typu Jbutton - zglaszanie usterki
     */
    private JButton reportDamage;
    /**
     * zmienna typu JLabel - tlo programu
     */
    protected JLabel background;
    /**
     * ikonka programu
     */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    ServiceWorkerScreen(Pracownik pracownik) {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogout = new JButton((new ImageIcon("src/resources/img/btnLogout.png")));
        btnLogout.setBounds(100, 370, 160, 56);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.addActionListener(this);
        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Zostales wylogowany z konta pracownika obsługi", "Notyfikator", JOptionPane.PLAIN_MESSAGE);
                new LoginScreen();
                frame.dispose();
            }
        });
        frame.add(btnLogout);

        checkTodayPlans = new JButton(new ImageIcon("src/resources/img/btnTodayPlans.png"));
        checkTodayPlans.setBounds(100, 300, 160, 56);
        checkTodayPlans.setBorderPainted(false);
        checkTodayPlans.setContentAreaFilled(false);
        checkTodayPlans.addActionListener(this);
        checkTodayPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new OneDayPlanScreen(pracownik);
                frame.dispose();
            }
        });
        frame.add(checkTodayPlans);

        checkWeekPlans = new JButton(new ImageIcon("src/resources/img/btnWeeklyPlans.png"));
        checkWeekPlans.setBounds(100, 230, 160, 56);
        checkWeekPlans.setBorderPainted(false);
        checkWeekPlans.setContentAreaFilled(false);
        checkWeekPlans.addActionListener(this);
        checkWeekPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new WeekPlanScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(checkWeekPlans);

        reportDamage = new JButton(new ImageIcon("src/resources/img/btnReportDamage.png"));
        reportDamage.setBounds(100, 160, 160, 56);
        reportDamage.setBorderPainted(false);
        reportDamage.setContentAreaFilled(false);
        reportDamage.addActionListener(this);
        reportDamage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new NewRaportScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(reportDamage);


        background = new JLabel(new ImageIcon("src/resources/img/background.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}