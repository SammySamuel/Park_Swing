import Core.Atrakcje;
import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Plany;
import Core.Pracownik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NewPlanScreen extends JFrame implements ActionListener {
    ArrayList<Pracownik> pracownicy;
    ArrayList<Atrakcje> atrakcjes;

    String[] stanowisko = {"Obługa atrkacji", "Kasjer"};

    JFrame frame = new JFrame("Eleden | Tworzenie planów");
    static final int width = 400;
    static final int height = 600;
    private JButton btnAdd;
    private JButton btnReturn;

    private JLabel lPracownik;
    private JLabel lStanowisko;
    private JLabel lAtrkacja;
    private JLabel lData;

    private JTextField tfData;
    private JComboBox cPracownik;
    private JComboBox cStanowisko;
    private JComboBox cAtrakcja;

    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    NewPlanScreen(Pracownik pracownik) {
        loadPracownicy();
        String[] pr = new String[pracownicy.size()];

        int i = -1;
        for (Pracownik p : pracownicy) {
            i++;
            pr[i] = new String(p.getLogin());
        }

        loadListAtraction();
        String[] atr = new String[atrakcjes.size()];
        int j = -1;
        for (Atrakcje a : atrakcjes) {
            j++;
            atr[j] = new String(a.getNazwa_atrakcji());
        }

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cPracownik = new JComboBox(pr);
        cPracownik.setBounds(170, 170, 200, 40);
        frame.add(cPracownik);

        lPracownik = new JLabel();
        lPracownik.setText("Employee :");
        lPracownik.setBounds(20, 170, 200, 40);
        frame.add(lPracownik);

        cStanowisko = new JComboBox(stanowisko);
        cStanowisko.setBounds(170, 220, 200, 40);
        cStanowisko.addActionListener(this);
        frame.add(cStanowisko);

        lStanowisko = new JLabel();
        lStanowisko.setText("Position:");
        lStanowisko.setBounds(20, 220, 200, 40);
        frame.add(lStanowisko);

        cAtrakcja = new JComboBox(atr);
        cAtrakcja.setBounds(170, 270, 200, 40);
        cAtrakcja.addActionListener(this);
        frame.add(cAtrakcja);

        lAtrkacja = new JLabel();
        lAtrkacja.setText("Attraction:");
        lAtrkacja.setBounds(20, 270, 200, 40);
        frame.add(lAtrkacja);

        tfData = new JTextField();
        tfData.setBounds(170, 320, 200, 40);
        frame.add(tfData);

        lData = new JLabel();
        lData.setText("Date:");
        lData.setBounds(20, 320, 200, 40);
        frame.add(lData);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnAdd.png"));
        btnAdd.setBounds(20, 450, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addNewPlan(pr, cPracownik.getSelectedIndex(), cStanowisko.getSelectedIndex(), atr, cAtrakcja.getSelectedIndex(), tfData.getText());
                JOptionPane.showMessageDialog(null, "Plan został dodany", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                new NewPlanScreen(pracownik);
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
                new ManagerScreen(pracownik);
            }
        });
        frame.add(btnReturn);

        background = new JLabel(new ImageIcon("src/resources/img/background400x600.png"));
        background.setOpaque(true);
        background.setBounds(0, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());

    }

    void loadListAtraction() {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        atrakcjes = (ArrayList<Atrakcje>) ClientManager.clientSender.sendToServer(ServerOperation.getAttractionToList, atrakcjes);
    }

    void loadPracownicy() {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();
        int ilosc = (Integer) ClientManager.clientSender.sendToServer(ServerOperation.howManyPracownik, null);

        pracownicy = (ArrayList<Pracownik>) ClientManager.clientSender.sendToServer(ServerOperation.getPracownikToList, null);

    }

    void addNewPlan(String[] pr, int iPr, int stan, String[] atr, int aAtr, String date) {
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        String Pr = pr[iPr];
        int idP = 0;
        for (Pracownik p : pracownicy) {
            if (p.getLogin().equals(Pr) == true)
                idP = p.getIdTyp();
        }

        String at = atr[aAtr];
        int idA = 0;
        for (Atrakcje a : atrakcjes) {
            if (a.getNazwa_atrakcji().equals(at) == true)
                idA = a.getId_atrakcji();
        }

        Plany plan = new Plany(0, idP, stan + 1, idA, date);

        ClientManager.clientSender.sendToServer(ServerOperation.addPlan, plan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}