
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;
import ProjectPatterns.prices.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AquaparkScreen extends JFrame implements ActionListener {

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Eleden | Mapa naszego parku");
    /** fav icon */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 600;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 800;
    /** zmienna typu JLabel - tlo widoku */
    private JLabel background;
    private JLabel lText;

    private JButton btnReturn;
    private JButton btnPrint;
    private JCheckBox standardTicket;
    private JCheckBox saunaTicket;
    private JCheckBox slidesTicket;
    private JCheckBox funTicket;
    private JCheckBox discountTicket;

    AquaparkScreen() {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lText = new JLabel();
        lText.setText("Skonfiguj swój własny bilet do aquaparku!");
        lText.setFont(lText.getFont().deriveFont(16.0f));
        lText.setLocation(75, 250);
        lText.setSize(400, 40);
        frame.add(lText);

        lText = new JLabel();
        lText.setText("Z taka konfiguracja, Twój bilet będzie kosztował:");
        lText.setFont(lText.getFont().deriveFont(16.0f));
        lText.setLocation(75, 400);
        lText.setSize(500, 40);
        frame.add(lText);

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

        btnPrint = new JButton(new ImageIcon("src/resources/img/btnPrintTicket.png"));
        btnPrint.setBounds(320, 600, 160, 56);
        btnPrint.setBorderPainted(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.addActionListener(this);
        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AquaparkTicket ticket =new StandardAquaparkTicket();
                if(saunaTicket.isBorderPaintedFlat()==true)
                    ticket=new SaunasZone(ticket);
                if(slidesTicket.isBorderPaintedFlat()==true)
                    ticket = new SlidesZone(ticket);
                if (funTicket.isBorderPaintedFlat()==true)
                    ticket = new FunZone(ticket);
                if(discountTicket.isBorderPaintedFlat()==true)
                    ticket = new Discount(ticket);

                System.out.println("Opis biletu: "+ ticket.getter_permissions());
                System.out.println("Cena biletu: "+ ticket.getter_price());

                JOptionPane.showMessageDialog(null, "Nastepuje drukowanie biletu!", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });
        frame.add(btnPrint);

        standardTicket = new JCheckBox("Standardowy bilet");
        standardTicket.setSelected(true);
        standardTicket.setBounds(150,300,200,15);
        standardTicket.setOpaque(false);
        frame.add(standardTicket);

        saunaTicket = new JCheckBox("Strefa saun");
        saunaTicket.setSelected(false);
        saunaTicket.setBounds(150,320,200,15);
        saunaTicket.setOpaque(false);
        frame.add(saunaTicket);

        slidesTicket = new JCheckBox("Strefa zjeżdżalni");
        slidesTicket.setSelected(false);
        slidesTicket.setBounds(150,340,200,15);
        slidesTicket.setOpaque(false);
        frame.add(slidesTicket);

        funTicket = new JCheckBox("Strefa zabawy");
        funTicket.setSelected(false);
        funTicket.setBounds(150,360,200,15);
        funTicket.setOpaque(false);
        frame.add(funTicket);

        discountTicket = new JCheckBox("25% zniżki dla osób poniżej 18 roku życia");
        discountTicket.setSelected(false);
        discountTicket.setBounds(150,380,400,15);
        discountTicket.setOpaque(false);
        frame.add(discountTicket);

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

