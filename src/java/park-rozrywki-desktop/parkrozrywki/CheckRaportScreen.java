import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;
import Core.Raport;
import Core.TypPracownika;
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

public class CheckRaportScreen extends JFrame implements ActionListener {

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

    CheckRaportScreen(Pracownik pracownik) {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadUnimplementedRaport(pracownik);

        jTable = new JTable();
        model.setColumnIdentifiers(headers);
        jTable.setModel(model);
        scroll = new JScrollPane(jTable);

        add(scroll, BorderLayout.CENTER);
        model.addRow(headers);



        for(Raport r: raportArrayList){
            model.addRow(
                    new Object[]{
                            r.getId_raport(),r.getId_pracownika(),r.getId_atrakcji(),r.getId_typ_awarii(),r.getOpis()
                    }
            );
        }
        jTable.setBounds(30,100,700,50);
        frame.add(jTable);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnAdd.png"));
        btnAdd.setBounds(20, 450, 160, 56);
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

                doItRepair(Integer.parseInt(id));

                JOptionPane.showMessageDialog(null, "Naprawa została wykonana", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                new CheckRaportScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(btnAdd);

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
                new TechnicalsScreen(pracownik);
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


    void loadUnimplementedRaport(Pracownik pracownik) {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        raportArrayList = (ArrayList<Raport>) ClientManager.clientSender.sendToServer(ServerOperation.getUnimplementedRaport, pracownik.getIdTyp());
    }

    void doItRepair(int id){

        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        Raport rap = (Raport)ClientManager.clientSender.sendToServer(ServerOperation.getRaport,id);
        Pracownik pr = (Pracownik)ClientManager.clientSender.sendToServer(ServerOperation.getPracownik,rap.getId_pracownika());
        TypPracownika tp = (TypPracownika)ClientManager.clientSender.sendToServer(ServerOperation.getTypPracownika,pr.getIdTyp());
        RepairController rc = new RepairController(tp.getTyp());
        rc.repair();

        ClientManager.clientSender.sendToServer(ServerOperation.updateStatusRaport,id);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}