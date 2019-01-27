
import Core.Atrakcje;
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PricesScreen extends JFrame implements ActionListener {
    ArrayList<Atrakcje> atrakcjeArrayList;
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

    private JTable jTable;
    private JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();

    String[] headers = {"Nazwa Atrkacji","Cena dla osoby","Cena dla grupy","Otwarte od","Otwarte do"};

    PricesScreen() {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadAttraction();
        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);

        for(Atrakcje a:atrakcjeArrayList)
        {
            model.addRow(new Object[]{
                    a.getNazwa_atrakcji(),
                    a.getCena_idywidualna(),
                    a.getCena_grupowa(),
                    a.getData_otwarcia(),
                    a.getData_zamkniecia()}
            );
        }
        jTable.setBounds(40,140,500,200);
        scroll = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setLocation(40,200);
        scroll.setSize(500,350);
        frame.add(scroll);

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
    public void loadAttraction()
    {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();
        atrakcjeArrayList = (ArrayList<Atrakcje>) ClientManager.clientSender.sendToServer(ServerOperation.getAttractionToList, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

}}

