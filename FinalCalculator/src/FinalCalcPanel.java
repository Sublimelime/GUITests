import javax.swing.*;

/**
 * Created on 12/5/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project SimpleCalculator
 */

public class FinalCalcPanel extends JPanel implements Runnable {

    public FinalCalcPanel() {
        setLayout(null);
        setSize(350, 550);
        Thread t = new Thread(this);
        t.start();

        JLabel[] labels = new JLabel[9];
        JTextField[] textFields = new JTextField[8];
        //stuff for the combo box
        String[] choices = new String[6];
        for (int i = 1; i < choices.length; i++) { //init list of choices
            choices[i] = "" + i;
        }
        JComboBox<String> dropDown = new JComboBox<>(choices);

        //LABELS CODE ------------------
        String[] labelStrings = {"Total term weight: ", "Final Weight: ", "Number of terms: ", "Grade wanted: ", "Term 1 grade: ",
                "Term 2 grade: ", "Term 3 grade: ", "Term 4 grade: ", "Term 5 grade: "};
        for (int i = 0; i < labels.length; i++) { //init and set the label text for all labels
            labels[i] = new JLabel(labelStrings[i]);
            labels[i].setBounds(10, (i * 50) + 20, 150, 40);
            labels[i].setEnabled(true);
            add(labels[i]);
        }

        //TEXT FIELDS CODE ----------------
        for (int i = 0; i < textFields.length; i++) { //init and set the label text for all text fields
            if (i >= 2) {
                textFields[i] = new JTextField();
                textFields[i].setEditable(true);
                textFields[i].setBounds(150, (i * 50) + 70, 150, 40);
                textFields[i].setEnabled(true);
                add(textFields[i]);
            } else {
                textFields[i] = new JTextField();
                textFields[i].setEditable(true);
                textFields[i].setBounds(150, (i * 50) + 20, 150, 40);
                textFields[i].setEnabled(true);
                add(textFields[i]);
            }
        }



    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception exe) {
                System.out.println("Issue with sleeping thread.");
                System.exit(-1);
            }
        }
    }
}
