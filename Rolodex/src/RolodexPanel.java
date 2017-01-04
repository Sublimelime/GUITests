import javax.swing.*;
import java.util.ArrayList;

/**
 * Created on 12/11/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Rolodex
 */

public class RolodexPanel extends JPanel {

    private final JLabel[] labels = new JLabel[4];
    private final JTextField[] textFields = new JTextField[4];
    ArrayList<Entry> entries = new ArrayList<>();
    private JList list = new JList();


    public RolodexPanel() {
        setLayout(null);
        setSize(650, 650);

        for (int i = 0; i < textFields.length; i++) { //todo set bounds for both of these
            textFields[i] = new JTextField();
        }

        labels[0] = new JLabel("First Name: ");
        labels[1] = new JLabel("Last Name: ");
        labels[2] = new JLabel("Address: ");
        labels[3] = new JLabel("Phone #: ");

        list.setEnabled(true);
        list.setBounds(0, 0, getWidth() / 3, getHeight());
        list.setListData(entries.toArray());


        add(list);
    }

}
