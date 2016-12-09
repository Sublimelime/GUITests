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
        setSize(320, 350);
        Thread t = new Thread(this);
        t.start();
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
