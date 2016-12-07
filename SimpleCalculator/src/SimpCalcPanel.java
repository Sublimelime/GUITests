import javax.swing.*;

/**
 * Created on 12/5/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project SimpleCalculator
 */

public class SimpCalcPanel extends JPanel implements Runnable {
    String leftOperand, rightOperand, mathAction, answer;
    JTextField leftOperandBox = new JTextField(""); //todo rename this
    JTextField mathActionBox = new JTextField("");
    JTextField answerBox = new JTextField("");

    public SimpCalcPanel() {
        setLayout(null);
        setSize(320, 350);
        JButton[] numButtons = new JButton[10]; //holds all the number buttons, 0-9. Array index corresponds to number
        JButton[] operatorButtons = new JButton[8]; //holds operators that affect numbers.
        //NUMBER BUTTONS -------------------------
        //init all number buttons
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton("" + i);
        }
        //set the bounds of all number buttons
        numButtons[0].setBounds(185, 150, 50, 160);
        //first row
        numButtons[1].setBounds(20, 150, 50, 50);
        numButtons[2].setBounds(75, 150, 50, 50);
        numButtons[3].setBounds(130, 150, 50, 50);
        //second row
        numButtons[4].setBounds(20, 205, 50, 50);
        numButtons[5].setBounds(75, 205, 50, 50);
        numButtons[6].setBounds(130, 205, 50, 50);
        //third row
        numButtons[7].setBounds(20, 260, 50, 50);
        numButtons[8].setBounds(75, 260, 50, 50);
        numButtons[9].setBounds(130, 260, 50, 50);
        //set all number buttons on, add all number buttons to the panel
        for (JButton numButton : numButtons) {
            numButton.setEnabled(true);
            add(numButton);
        }
        //OPERATOR BUTTONS -------------------------
        //init
        operatorButtons[0] = new JButton(".");
        operatorButtons[1] = new JButton("±");
        operatorButtons[2] = new JButton("C");
        operatorButtons[3] = new JButton("+");
        operatorButtons[4] = new JButton("-");
        operatorButtons[5] = new JButton("*");
        operatorButtons[6] = new JButton("/");
        operatorButtons[7] = new JButton("=");
        //bounds and locations
        //top row, which includes ., ±, C, and +
        for (int x = 75; x< 295; x+=55) {
            operatorButtons[(x-75)/55].setBounds(x,95,50,50);
        }
        //includes -, *, /, =
        operatorButtons[4].setBounds(240,150,50,50); // -
        operatorButtons[5].setBounds(240,205,50,50); // *
        operatorButtons[6].setBounds(240,260,50,50); // /
        operatorButtons[7].setBounds(20,315,270,30); // =

        //enable and add all operator buttons to panel
        for (JButton operatorButton : operatorButtons) {
            operatorButton.setEnabled(true);
            add(operatorButton);
        }
        //LABELS FOR CALC AREA -----------------

        answerBox.setHorizontalAlignment(JLabel.RIGHT);
        answerBox.setBounds(50, 50, getWidth() - 100, 20);
        answerBox.setEditable(false);
        answerBox.setEnabled(true);
        add(answerBox);


        leftOperandBox.setHorizontalAlignment(JLabel.RIGHT);
        leftOperandBox.setBounds(50, 30, getWidth() - 100, 20);
        leftOperandBox.setEditable(false);
        leftOperandBox.setEnabled(true);
        add(leftOperandBox);


        mathActionBox.setHorizontalAlignment(JLabel.RIGHT);
        mathActionBox.setBounds(50, 10, getWidth() - 100, 20);
        mathActionBox.setEditable(false);
        mathActionBox.setEnabled(true);
        add(mathActionBox);

        //NUMBER BUTTON ACTIONS ------------------------
        numButtons[0].addActionListener(e -> { //todo put into method?
            if (mathAction.equals("") && rightOperand.equals("")) {
                leftOperand += "0";
            } else if (!leftOperand.equals("") && !mathAction.equals("")) { //if mathAct and left are both not blank
                rightOperand += "0";
            }
        });

    }

    @Override
    public void run() {
        while (true) {
            leftOperandBox.setText(leftOperand);
            answerBox.setText(answer);
            mathActionBox.setText(mathAction);
            try {
                Thread.sleep(35);
            } catch (Exception exe) {
                System.out.println("Issue with sleeping thread.");
                System.exit(-1);
            }
        }
    }
}
