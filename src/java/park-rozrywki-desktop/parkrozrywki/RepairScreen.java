import Core.*;
import Core.Client.Client;
import Core.Client.ServerOperation;
import ProjectPatterns.Repairment.RepairController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RepairScreen extends JFrame implements ActionListener {

    ArrayList<Raport> raportArrayList;

    JFrame frame = new JFrame("Eleden | Przeglądanie raportów");
    static final int width = 800;
    static final int height = 600;
    private JButton btnAdd;
    private JButton btnReturn;

    private JTable jTable;
    private JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();

    String[] headers = {"ID_RAPORT","PRACOWNIKA","ATRAKCJA","TYP_AWARII","OPIS"};

    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    RepairScreen(Pracownik pracownik) {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadUnimplementedRaport(pracownik);

        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);
        scroll = new JScrollPane(jTable);



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
                            r.getOpis()
                    }
            );
        }
        jTable.setBounds(40,140,700,300);
        scroll.setLocation(40,148);
        scroll.setSize(700,300);
        frame.add(scroll);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnStart.png"));
        btnAdd.setBounds(200, 450, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int i = jTable.getSelectedRow();
                TableModel m = jTable.getModel();
                String id = model.getValueAt(i,0).toString();
                doRapair(Integer.parseInt(id));
                JOptionPane.showMessageDialog(null, "Naprawa została wykonana", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                new RepairScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(btnAdd);

        btnReturn = new JButton(new ImageIcon("src/resources/img/btnReturn.png"));
        btnReturn.setBounds(400, 450, 160, 56);
        btnReturn.setBorderPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.addActionListener(this);
        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                new TechnicalsScreen(pracownik);
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


    void loadUnimplementedRaport(Pracownik pracownik) {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        int idT = 0;
        if (pracownik.getIdTyp() == 4) {
            idT = 1;
        }
        if (pracownik.getIdTyp() == 5) {
            idT = 2;
        }
        if (pracownik.getIdTyp() == 6) {
            idT = 3;
        }

        raportArrayList = (ArrayList<Raport>) ClientManager.clientSender.sendToServer(ServerOperation.getUnimplementedRaport, idT);
    }

    void doRapair(int id){

        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        Raport rap = (Raport)ClientManager.clientSender.sendToServer(ServerOperation.getRaport,id);
        Pracownik pr = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,rap.getId_pracownika());
        TypPracownika tp = (TypPracownika)ClientManager.clientSender.sendToServer(ServerOperation.getTypPracownika,pr.getIdTyp());
        RepairController rc = new RepairController(tp.getTyp());

        ClientManager.clientSender.sendToServer(ServerOperation.updateStatusRaport,id);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}