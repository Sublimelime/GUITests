import javax.swing.*;
import java.awt.*;

/**
 * Created on 12/11/2016, 2:16 PM
 *
 * @author Noah Morton
 *         Tully 7th period
 *         Part of project Rolodex
 */

public class RolodexFrame extends JFrame {
    public RolodexFrame() {

        super("Rolodex");

        // Sets the close button to exit the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // makes the window not able to be re-sized
        setResizable(false);
        // creates the window
        pack();
        // creates the panel
        RolodexPanel p = new RolodexPanel();
        // gets the frames insets
        Insets frameInsets = getInsets();
        // calculates panel size
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
        // sets the frame's size
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        // turns off the layout options
        setLayout(null);
        // adds the panel to the frame
        add(p);
        // adjusts the window to meet its new preferred size
        pack();
        // shows the frame
        setVisible(true);
    }

}
