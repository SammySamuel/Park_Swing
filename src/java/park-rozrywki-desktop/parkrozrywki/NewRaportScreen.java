import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewRaportScreen extends JFrame implements  ActionListener
{
    String[] typy={"Elektryczna","Mechaniczna","Oprogramowania","Nieznany"};
    JFrame frame = new JFrame("Eleden | Zgłaszanie Awarii");
    static final int width = 400;
    static final int height = 600;
    private JButton btnAdd;
    private JButton btnReturn;

    private JTextArea taDescription;

    private JLabel lIdAtrkacji;
    private JLabel lTypeFailure;
    private JLabel lDescription;

    private JScrollPane scroll;
    private JComboBox cType;
    private JComboBox cAttraction;


    protected JLabel background;
    ImageIcon icon = new ImageIcon("src/resources/img/icon.png");

    NewRaportScreen()
    {

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cAttraction= new JComboBox();
        cAttraction.setBounds(170,170,200,40);
        frame.add(cAttraction);

        lIdAtrkacji = new JLabel();
        lIdAtrkacji.setText("Attraction :");
        lIdAtrkacji.setBounds(20,170,200,40);
        frame.add(lIdAtrkacji);


        cType=new JComboBox(typy);
        cType.setBounds(170,220,200,40);
        cType.addActionListener(this);
        frame.add(cType);

        lTypeFailure = new JLabel();
        lTypeFailure.setText("Type Failure:");
        lTypeFailure.setBounds(20,220,200,40);
        frame.add(lTypeFailure);

        taDescription= new JTextArea(5,10);
        scroll=new JScrollPane(taDescription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setLocation(170,270);
        scroll.setSize(200,100);
        frame.add(scroll);

        lDescription = new JLabel();
        lDescription.setText("Description:");
        lDescription.setBounds(20,270,200,40);
        frame.add(lDescription);

        btnAdd = new JButton(new ImageIcon("src/resources/img/btnAdd.png"));
        btnAdd.setBounds(20, 450, 160, 56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Awaria została zgłoszona", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                new NewRaportScreen();
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
                new ServiceWorkerScreen();
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}