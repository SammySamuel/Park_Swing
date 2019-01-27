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

public class AllRaportScreen extends JFrame implements ActionListener
{
    ArrayList<Raport> raportArrayList;

    JFrame frame = new JFrame("Eleden | Przeglądanie raportów");
    static final int width = 800;
    static final int height = 600;
    private JButton btnReturn;

    private JTable jTable;
    private JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();

    String[] headers = {"ID_RAPORT","PRACOWNIK","ATRAKCJA","TYP_AWARII","OPIS","STATUS"};

    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    AllRaportScreen(Pracownik pracownik)
    {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadRaport();

        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);

        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();
        TypAwarii awarii = null;
        Atrakcje atrakcje = null;
        Pracownik pracownik1 = null;

        for(Raport r: raportArrayList){
            awarii = (TypAwarii)ClientManager.clientSender.sendToServer(ServerOperation.getTypAwarii,r.getId_typ_awarii());
            atrakcje = (Atrakcje)ClientManager.clientSender.sendToServer(ServerOperation.getAttraction,r.getId_atrakcji());
            pracownik1 = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,r.getId_pracownika());
            model.addRow(
                    new Object[]{
                            r.getId_raport(),
                            pracownik1.getLogin(),
                            atrakcje.getNazwa_atrakcji(),
                            awarii.getNazwa(),
                            r.getOpis(),
                            r.getStatus()
                    }
            );
        }
        jTable.setBounds(40,140,700,300);
        scroll = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setLocation(40,148);
        scroll.setSize(700,300);
        frame.add(scroll);

        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(300, 450, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new ManagerScreen(pracownik);
                frame.dispose();
            }
        });
        frame.add(btnReturn);

        background = new JLabel(new ImageIcon("src/resources/img/background800x600.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }

    public void loadRaport()
    {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();
        raportArrayList = (ArrayList<Raport>) ClientManager.clientSender.sendToServer(ServerOperation.getAllRaport, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}