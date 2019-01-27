
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

public class MainScreen extends JFrame implements ActionListener {

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Eleden - Jedyny taki park rozrywki");
    /** fav icon */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 600;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 800;
    /** zmienna typu JLabel - tlo widoku */
    private JLabel background;

    private JButton btnPrices;

    private JButton btnMap;

    private JButton btnAbout;

    private JButton btnAdmin;



    MainScreen() {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnPrices = new JButton(new ImageIcon("src/resources/img/buttonCennik.png"));
        btnPrices.setBounds(170, 250, 244, 58);
        btnPrices.setBorderPainted(false);
        btnPrices.setContentAreaFilled(false);
        btnPrices.addActionListener(this);
        btnPrices.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new PricesScreen();
            }
        });
        frame.add(btnPrices);

        btnMap = new JButton(new ImageIcon("src/resources/img/buttonMapa.png"));
        btnMap.setBounds(170, 350, 244, 58);
        btnMap.setBorderPainted(false);
        btnMap.setContentAreaFilled(false);
        btnMap.addActionListener(this);
        btnMap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new MapScreen();
            }
        });
        frame.add(btnMap);

        btnAbout = new JButton(new ImageIcon("src/resources/img/buttonAboutUs.png"));
        btnAbout.setBounds(170, 450, 244, 58);
        btnAbout.setBorderPainted(false);
        btnAbout.setContentAreaFilled(false);
        btnAbout.addActionListener(this);
        btnAbout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new AboutUsScreen();
            }
        });
        frame.add(btnAbout);

        btnAdmin = new JButton(new ImageIcon("src/resources/img/buttonPanel.png"));
        btnAdmin.setBounds(170, 550, 244, 58);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.addActionListener(this);
        btnAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Ostrzezenie ! Uprawnienia do tej funkcji maja tylko pracownicy parku!", "Notyfikator", JOptionPane.ERROR_MESSAGE);
                new LoginScreen();
                frame.dispose();
            }
        });
        frame.add(btnAdmin);

        background = new JLabel(new ImageIcon("src/resources/img/main_background.png"));
        background.setOpaque(true);
        background.setBounds(-10, -10, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

}}

