import javax.swing.*;
import java.util.ArrayList;

/**
 * Created on 12/11/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Rolodex
 */

@SuppressWarnings("unchecked")
public class RolodexPanel extends JPanel {

    private final JLabel[] labels = new JLabel[4];
    private final JTextField[] textFields = new JTextField[4];
    private final JButton[] buttons = new JButton[4];
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

        list.addListSelectionListener(e -> {
            if (list.getSelectedIndex() != -1) {
                setButtonLayout(1);
                wipeBoxes();
                textFields[0].setText(entries.get(list.getSelectedIndex()).getFirstName()); //set first name
                textFields[1].setText(entries.get(list.getSelectedIndex()).getLastName()); //set last name
                textFields[2].setText(entries.get(list.getSelectedIndex()).getAddress()); //set address
                textFields[3].setText("" + entries.get(list.getSelectedIndex()).getPhoneNum()); //set phone number
            } else {
                setButtonLayout(2);
            }
        });

        /* BUTTON CODE ################################################ */ //todo fix display issues
        String[] names = {"Save Changes", "Delete contact", "Save as new", "Make new, wipe"};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(names[i]);
            add(buttons[i]);
            buttons[i].setEnabled(true);
            buttons[i].setVisible(false);
        }
        buttons[0].setBounds((getWidth() / 3) + 50, 2 * getHeight() / 3, buttons[0].getText().length() * 12, 30);
        buttons[1].setBounds((getWidth() / 3) + 50, (2 * getHeight() / 3) + 50, buttons[1].getText().length() * 12, 30);
        buttons[2].setBounds((getWidth() / 3) + 50, 2 * getHeight() / 3, buttons[2].getText().length() * 12, 30);
        buttons[3].setBounds((getWidth() / 3) + 50, (2 * getHeight() / 3) + 50, buttons[3].getText().length() * 12, 30);
        setButtonLayout(2);
        for (JButton button : buttons) {
            add(button);
        }

        buttons[0].addActionListener(e -> { // Save changes
            entries.get(list.getSelectedIndex()).setFirstName(textFields[0].getText()); //saves the first name into the contact from the box
            entries.get(list.getSelectedIndex()).setLastName(textFields[1].getText());
            entries.get(list.getSelectedIndex()).setAddress(textFields[2].getText());
            entries.get(list.getSelectedIndex()).setPhoneNum(Long.parseLong(textFields[3].getText()));
            list.setListData(entries.toArray()); //sync changes
            list.setSelectedIndex(-1);
            wipeBoxes();
            setButtonLayout(2); //this switches back to the main buttons.
        });

        buttons[1].addActionListener(e -> { // Delete contact
            entries.remove(list.getSelectedIndex()); //Removes the contact from the entries list
            list.setListData(entries.toArray()); //refresh list
            list.setSelectedIndex(-1); //Un-select
            wipeBoxes();
            setButtonLayout(2);
        });
        buttons[2].addActionListener(e -> { // Save as new
            entries.add(new Entry(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), Long.parseLong(textFields[3].getText())));
            list.setListData(entries.toArray()); //refresh list
            wipeBoxes();
            list.setSelectedIndex(-1); //Un-select
            setButtonLayout(2);
        });
        buttons[3].addActionListener(e -> { // Make new, wipe
            wipeBoxes();
            list.setListData(entries.toArray()); //sync changes
            setButtonLayout(2);
        });

    }

    /**
     * Toggles the display of the 4 buttons to create different screens.
     * 2 : Tools for making a new contact.
     * 1 : Tools for editing/deleting a contact.
     */
    private void setButtonLayout(int mode) {
        if (mode == 1) {
            buttons[0].setVisible(true);
            buttons[1].setVisible(true);
            buttons[2].setVisible(false);
            buttons[3].setVisible(false);
        } else if (mode == 2) {
            buttons[0].setVisible(false);
            buttons[1].setVisible(false);
            buttons[2].setVisible(true);
            buttons[3].setVisible(true);
        }
    }

    /**
     * Wipes all the text fields.
     */
    private void wipeBoxes() {
        for (JTextField textField : textFields) { //wipe all the boxes
            textField.setText("");
        }
    }
}
