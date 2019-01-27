
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

public class PricesScreen extends JFrame implements ActionListener {

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Eleden | Cennik");
    /** fav icon */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 600;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 800;
    /** zmienna typu JLabel - tlo widoku */
    private JLabel background;
    private JButton btnReturn;
    private JButton btnMore;

    PricesScreen() {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(120, 600, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
        frame.add(btnReturn);

        btnMore = new JButton(new ImageIcon("src/resources/img/btnMore.png"));
        btnMore.setBounds(320, 600, 160, 56);
        btnMore.setBorderPainted(false);
        btnMore.setContentAreaFilled(false);
        btnMore.addActionListener(this);
        btnMore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new AquaparkScreen();
                frame.dispose();
            }
        });
        frame.add(btnMore);

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

