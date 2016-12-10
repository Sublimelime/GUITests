import javax.swing.*;

/**
 * Created on 12/5/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project SimpleCalculator
 */

public class FinalCalcPanel extends JPanel {
    JLabel[] labels = new JLabel[9];
    JTextField[] textFields = new JTextField[8];
    JComboBox<String> termsAmount;
    JLabel answerLabel = new JLabel("");

    public FinalCalcPanel() {
        setLayout(null);
        setSize(350, 650);

        //stuff for the combo box
        String[] choices = new String[6];
        for (int i = 1; i < choices.length; i++) { //init list of choices
            choices[i] = "" + i;
        }

        termsAmount = new JComboBox<>(choices);
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
            textFields[i].setText("0");
        }
        //COMBO BOX CODE ------------------------
        termsAmount.setBounds(150, 115, 130, 40);
        termsAmount.setEnabled(true);
        termsAmount.setEditable(false);
        termsAmount.setSelectedItem("1");
        add(termsAmount);


        //BUTTONS CODE -----------------------------
        JButton calcButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        calcButton.setEnabled(true);
        calcButton.setBounds(20, 500, 200, 30);
        add(calcButton);
        clearButton.setEnabled(true);
        clearButton.setBounds(20, 550, 200, 30);
        add(clearButton);

        calcButton.addActionListener(e -> {
            answerLabel.setText("" + doCalc(textFields, termsAmount));
        });

        clearButton.addActionListener(e -> {
            for (int i = 0; i < textFields.length; i++) {
                textFields[i].setText("0");
            }
            termsAmount.setSelectedItem("1");
            answerLabel.setText("");
        });

    }

    /**
     * Calculates the result based on the text of the textFields, then returns it.
     *
     * @param textFields An array of all the text fields.
     * @param comboBox   the drop down box containing the current amount of terms.
     * @return double - The result of the calculation.
     */
    private double doCalc(JTextField[] textFields, JComboBox<String> comboBox) {
        double termAverage = 0;
        for (int i = 3; i <= (termsAmount.getSelectedIndex()) + 2; i++) {
            termAverage += Double.parseDouble(textFields[i].getText());
        }
        termAverage = termAverage / termsAmount.getSelectedIndex();


        return 0;
    }

}
