import Core.Client.Client;
import Core.Client.ServerOperation;
import Core.ClientManager;
import Core.Pracownik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EditUserScreen extends JFrame implements ActionListener{

    ArrayList<Pracownik> pracownicy;

    JFrame frame = new JFrame("Eleden | Edit uzytkownik");

    static final int width = 400;
    static final int height = 600;

    private JButton btnAdd;
    private JButton btnReturn;

    private JComboBox Prac;



    /** prywatna zmienna typu JLabel - tlo aplikacji, w tym przypadku 400x600*/
    protected JLabel background;
    /** ikonka programu */
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    EditUserScreen(){
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadPracownicy();

        String[] pr= new String[pracownicy.size()];

        int i = -1;
        for(Pracownik p:pracownicy){
            i++;
            pr[i] = new String(p.getLogin());
        }


        Prac = new JComboBox(pr);
        Prac.setBounds(20,150,400,70);
        Prac.addActionListener(this);
        frame.add(Prac);


        btnAdd = new JButton(new ImageIcon("src/resources/img/btnAdd.png"));
        btnAdd.setBounds(20, 450, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                removeUserr(pr,Prac.getSelectedIndex());
                JOptionPane.showMessageDialog(null, " uzytkownik zostal pomyslnie usuniety z systemu!", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                frame.setVisible(false);
                new AdminScreen();
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
                new AdminScreen();
            }});
        frame.add(btnReturn);

        background = new JLabel(new ImageIcon("src/resources/img/background400x600.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }

    void loadPracownicy(){
        Client client = new Client("localhost",4821);
        ClientManager clientManager = new ClientManager();
        int ilosc = (Integer)ClientManager.clientSender.sendToServer(ServerOperation.howManyPracownik,null);

        pracownicy = (ArrayList<Pracownik>)ClientManager.clientSender.sendToServer(ServerOperation.getPracownikToList,null);

    }

    void removeUserr(String[] pr, int rem){
        Client client = new Client("localhost",4821);
        ClientManager clientManager = new ClientManager();


        String login = pr[rem];

        ClientManager.clientSender.sendToServer(ServerOperation.removeUserFromBase,login);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
