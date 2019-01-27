import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Plany;
import Core.Pracownik;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OneDayPlanScreen extends JFrame implements ActionListener {
    ArrayList<Plany> planyArrayList;

    JFrame frame = new JFrame("Eleden | Przeglądanie planow dnia");
    static final int width = 800;
    static final int height = 600;

    private JButton btnAdd;
    private JButton btnReturn;

    private JTable jTable;
    private JScrollPane scroll;

    DefaultTableModel model = new DefaultTableModel();
    String[] headers = {"ID_PLANU", "PRACOWNIK", "STANOWISKO", "ATRAKCJA", "DATE"};

    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    OneDayPlanScreen(Pracownik pracownik) {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadPlan(pracownik);

        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);
        scroll = new JScrollPane(jTable);

        for (Plany p : planyArrayList) {
            model.addRow(
                    new Object[]{
                            p.getId_planu(),
                            p.getId_pracownika(),
                            p.getId_stanowiska(),
                            p.getId_atrakcji(),
                            p.getData()
                    }
            );
        }
        jTable.setBounds(40, 140, 700, 300);
        scroll.setLocation(40, 148);
        scroll.setSize(700, 300);
        frame.add(scroll);


        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(210, 450, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new ServiceWorkerScreen(pracownik);
            }
        });
        frame.add(btnReturn);

        background = new JLabel(new ImageIcon("src/resources/img/background400x600.png"));
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

    void loadPlan(Pracownik pracownik) {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        planyArrayList = (ArrayList<Plany>) ClientManager.clientSender.sendToServer(ServerOperation.getOneDayPlanList, pracownik.getId());
    }


}