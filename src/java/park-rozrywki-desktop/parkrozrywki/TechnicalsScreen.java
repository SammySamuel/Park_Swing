import Core.*;
import Core.Client.Client;
import Core.Client.ServerOperation;
import ProjectPatterns.Observer.*;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TechnicalsScreen extends JFrame implements ActionListener {


    ArrayList<Raport> raportList = null;
    /**
     * glowny screen - logowanie do panelu admina
     */
    JFrame frame = new JFrame("Eleden | Panel TECHNICZNY");
    /**
     * zmienna typu static final int, okresla szerrokosc okna
     */
    static final int width = 400;
    /**
     * zmienna typu static final int, okresla wysokosc okna
     */
    static final int height = 500;
    /**
     * ikonka programu
     */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    private JButton btnLogin;
    private JButton checkRaport;
    private JButton repair;
    private JButton checkDayPlans;
    private JButton checkWeekPlans;


    protected JLabel background;

    TechnicalsScreen(Pracownik pracownik) {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadRaportList();

        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        RaportSubject subject= new RaportSubject();
        ElectricObserver electric= new ElectricObserver();
        MechanicObserver mechanic= new MechanicObserver();
        SoftwareObserver ipspecialist= new SoftwareObserver();
        AllObserver unknow=new AllObserver();

        subject.registerObserver(electric);
        subject.registerObserver(mechanic);
        subject.registerObserver(ipspecialist);
        subject.registerObserver(unknow);


        for(Raport r: raportList){
            if(r.getStatus().equals("zgloszony")) {
                subject.reportRaport(pracownik.getIdTyp(), r.getId_typ_awarii());
            }
        }

        btnLogin = new JButton((new ImageIcon("src/resources/img/btnLogout.png")));
        btnLogin.setBounds(100, 380, 160, 56);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(this);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Zostales wylogowany z konta ", "Notyfikator", JOptionPane.PLAIN_MESSAGE);
                new LoginScreen();
                frame.dispose();
            }
        });
        frame.add(btnLogin);

        checkRaport = new JButton(new ImageIcon("src/resources/img/btnCheckReports.png"));
        checkRaport.setBounds(100, 320, 160, 56);
        checkRaport.setBorderPainted(false);
        checkRaport.setContentAreaFilled(false);
        checkRaport.addActionListener(this);
        checkRaport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new CheckRaportScreen(pracownik);
                frame.dispose();
            }
        });
        frame.add(checkRaport);

        repair = new JButton(new ImageIcon("src/resources/img/btnRepair.png"));
        repair.setBounds(100, 260, 170, 56);
        repair.setBorderPainted(false);
        repair.setContentAreaFilled(false);
        repair.addActionListener(this);
        repair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new RepairScreen(pracownik);
                frame.dispose();
            }
        });
        frame.add(repair);

        checkDayPlans = new JButton(new ImageIcon("src/resources/img/btnTodayPlans.png"));
        checkDayPlans.setBounds(100, 200, 160, 56);
        checkDayPlans.setBorderPainted(false);
        checkDayPlans.setContentAreaFilled(false);
        checkDayPlans.addActionListener(this);
        checkDayPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new OneDayPlanScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(checkDayPlans);

        checkWeekPlans = new JButton(new ImageIcon("src/resources/img/btnWeeklyPlans.png"));
        checkWeekPlans.setBounds(100, 140, 160, 56);
        checkWeekPlans.setBorderPainted(false);
        checkWeekPlans.setContentAreaFilled(false);
        checkWeekPlans.addActionListener(this);
        checkWeekPlans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new WeekPlanScreen(pracownik);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        frame.add(checkWeekPlans);

        background = new JLabel(new ImageIcon("src/resources/img/background.png"));
        background.setOpaque(true);
        background.setBounds(0, 0, width, height);
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

    void loadRaportList(){
        Client client = new Client("localhost", 4821);
        ClientManager clientManager = new ClientManager();

        raportList = (ArrayList<Raport>)ClientManager.clientSender.sendToServer(ServerOperation.getAllRaport,null);
    }


}