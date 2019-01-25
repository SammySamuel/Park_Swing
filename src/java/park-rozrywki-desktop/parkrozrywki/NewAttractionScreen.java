import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NewAttractionScreen extends JFrame implements ActionListener{

    /** glowny screen - logowanie do panelu admina */
    JFrame frame = new JFrame("Eleden | Dodawanie nowej atrakcji");
    /** zmienna typu static final int, okresla szerrokosc okna */
    static final int width = 400;
    /** zmienna typu static final int, okresla wysokosc okna */
    static final int height = 600;
    /** zmienna typu JButton odpowiadajacy za sfinalizowanie dodawania nowej atrakcji */
    private JButton btnAdd;
    /** prywatna zmienna typu JTextField - przyjmuje nazwe atrakcji */
    private JTextField attractionName;
    /** prywatna zmienna typu JTextField - przyjmuje cene biletu solo*/
    private JTextField soloPrice;
    /** prywatna zmienna typu JTextField - przyjmuje cene biletu grupowego */
    private JTextField groupPrice;
    /** prywatna zmienna typu JTextField - przyjmuje date rozpoczecia */
    private JTextField startDate;
    /** prywatna zmienna typu JTextField - przyjmuje date zakonczenia */
    private JTextField endDate;
    /** prywatna zmienna typu JLabel - nazwa atrakcji */
    private JLabel jlAttractionName;
    /** prywatna zmienna typu JLabel - cena biletu pojedynczego */
    private JLabel jlSoloPrice;
    /** prywatna zmienna typu JLabel - cena biletu grupowego */
    private JLabel jlGroupPrice;
    /** prywatna zmienna typu JLabel - data rozpoczecia*/
    private JLabel jlStartDate;
    /** prywatna zmienna typu JLabel - data zkonczenia*/
    private JLabel jlEndDate;
    /** prywatna zmienna typu JLabel - tlo aplikacji, w tym przypadku 400x600*/
    protected JLabel background;

    NewAttractionScreen(){

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        attractionName = new JTextField();
        attractionName.setBounds(170, 160, 200, 40);
        frame.add(attractionName);

        jlAttractionName = new JLabel();
        jlAttractionName.setText("Nazwa atrakcji:");
        jlAttractionName.setBounds(20,160,200,40);
        frame.add(jlAttractionName);

        soloPrice = new JTextField();
        soloPrice.setBounds(170, 210, 200, 40);
        /*soloPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
*/


        frame.add(soloPrice);

        jlSoloPrice = new JLabel();
        jlSoloPrice.setText("Cena biletu grupowego:");
        jlSoloPrice.setBounds(20,210,200,40);
        frame.add(jlSoloPrice);

        groupPrice = new JTextField();
        groupPrice.setBounds(170, 260, 200, 40);
        frame.add(groupPrice);

        jlGroupPrice = new JLabel();
        jlGroupPrice.setText("Cena biletu pojedynczego:");
        jlGroupPrice.setBounds(20,260,200,40);
        frame.add(jlGroupPrice);

        startDate = new JTextField();
        startDate.setBounds(170, 310, 200, 40);
        frame.add(startDate);

        jlStartDate = new JLabel();
        jlStartDate.setText("Data rozpoczęcia:");
        jlStartDate.setBounds(20,310,200,40);
        frame.add(jlStartDate);

        endDate = new JTextField();
        endDate.setBounds(170, 360, 200, 40);
        frame.add(endDate);

        jlEndDate = new JLabel();
        jlEndDate.setText("Data zakończenia:");
        jlEndDate.setBounds(20,360,200,40);
        frame.add(jlEndDate);


        btnAdd = new JButton((new ImageIcon("src/resources/img/btnAdd.png")));
        btnAdd.setBounds(100,450,160,56);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Nowa atrakcja  została pomyślnie dodana!", "Notyfikator", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });
        frame.add(btnAdd);


        background = new JLabel(new ImageIcon("src/resources/img/background400x600.png"));
        background.setOpaque(true);
        background.setBounds(-10, 0, width, height);
        frame.add(background);

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void warn(){

        if (Integer.parseInt(soloPrice.getText())<=0){
            JOptionPane.showMessageDialog(null,
                    "Error: Please enter number bigger than 0", "Error Massage",
                    JOptionPane.ERROR_MESSAGE);
        }


}}