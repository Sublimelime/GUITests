import javax.swing.*;

/**
 * Created on 12/5/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project SimpleCalculator
 */

public class SimpCalcPanel extends JPanel {
    JButton button = new JButton("Test");

    public SimpCalcPanel() {
        setLayout(null);
        setSize(350, 300);
        JButton[] numButtons = new JButton[10];
        JButton[] operatorButtons = new JButton[4];
        //init all number buttons
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton("" + i);
        }
        //set the bounds of all number buttons
        numButtons[0].setBounds(190, 100, 50, 160);
        //first row
        numButtons[1].setBounds(20, 100, 50, 50);
        numButtons[2].setBounds(75, 100, 50, 50);
        numButtons[3].setBounds(130, 100, 50, 50);
        //second row
        numButtons[4].setBounds(20, 155, 50, 50);
        numButtons[5].setBounds(75, 155, 50, 50);
        numButtons[6].setBounds(130, 155, 50, 50);
        //third row
        numButtons[7].setBounds(20, 210, 50, 50);
        numButtons[8].setBounds(75, 210, 50, 50);
        numButtons[9].setBounds(130, 210, 50, 50);

        //set all number buttons on
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i].setEnabled(true);
        }
        //add all number buttons to the panel
        for (JButton numButton : numButtons) {
            add(numButton);
        }

    }

}
