import Core.*;
import Core.Client.Client;
import Core.Client.ServerOperation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WeekPlanScreen extends JFrame implements ActionListener {
    ArrayList<Plany> planyArrayList;

    JFrame frame = new JFrame("Eleden | Przeglądanie planow tygodniowych");
    static final int width = 400;
    static final int height = 600;

    private JButton btnReturn;

    private JTable jTable;
    private JScrollPane scroll;

    DefaultTableModel model = new DefaultTableModel();
    String[] headers = {"STANOWISKO", "ATRAKCJA", "DATE"};

    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    WeekPlanScreen(Pracownik pracownik) {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadPlan(pracownik);

        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);
        scroll = new JScrollPane(jTable);

        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        Atrakcje atrakcje = null;
        Stanowisko stanowisko = null;

        for (Plany p : planyArrayList) {
            atrakcje = (Atrakcje)ClientManager.clientSender.sendToServer(ServerOperation.getAttraction,p.getId_atrakcji());
            stanowisko = (Stanowisko)ClientManager.clientSender.sendToServer(ServerOperation.getStanowisko,p.getId_stanowiska());
            model.addRow(
                    new Object[]{
                            stanowisko.getNazwa(),
                            atrakcje.getNazwa_atrakcji(),

                            p.getData()
                    }
            );
        }
        jTable.setBounds(40, 140, 300, 300);
        scroll.setLocation(40, 148);
        scroll.setSize(300, 300);
        frame.add(scroll);


        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(110, 450, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(pracownik.getIdTyp()==3) {
                    new ServiceWorkerScreen(pracownik);
                }else {
                    new TechnicalsScreen(pracownik);
                }
                frame.setVisible(false);
                frame.dispose();
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

        planyArrayList = (ArrayList<Plany>) ClientManager.clientSender.sendToServer(ServerOperation.getWeekPlanList, pracownik.getId());
    }


}