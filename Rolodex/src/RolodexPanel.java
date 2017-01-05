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
    private ArrayList<Entry> entries = new ArrayList<>();
    private JList list = new JList();

    public RolodexPanel() {
        setLayout(null);
        setSize(650, 650);

        /* TEXT FIELDS ################################################## */
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
        }
        for (int i = 0; i < 4; i++) {
            textFields[i].setBounds((getWidth() / 2) + 20, (i * 70) + 30, 200, 20);
            add(textFields[i]);
            textFields[i].setEnabled(true);
        }


        /* LABELS CODE ################################################ */
        labels[0] = new JLabel("First Name: ");
        labels[1] = new JLabel("Last Name: ");
        labels[2] = new JLabel("Address: ");
        labels[3] = new JLabel("Phone #: ");
        for (int i = 0; i < 4; i++) {
            labels[i].setBounds((getWidth() / 3) + 20, (i * 70) + 30, 100, 20);
            add(labels[i]);
            labels[i].setEnabled(true);
        }
        /* LIST CODE ################################################ */
        list.setEnabled(true);
        list.setBounds(0, 0, getWidth() / 3, getHeight());
        list.setListData(entries.toArray());
        add(list);


    }

    /**
     * Toggles the display of the 4 buttons to create different screens
     */
    private void toggleButtonLayout() {
        //todo make toggle between save/delete buttons and save/new
    }

}
