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
        setSize(300, 500);
        button.setBounds(50, 50, 50, 50);
        button.setEnabled(true);

        add(button);

    }

}
