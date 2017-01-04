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

    ArrayList<Entry> entries = new ArrayList<>();
    private JList list = new JList();



    public RolodexPanel() {
        setLayout(null);
        setSize(650, 650);

        list.setEnabled(true);
        list.setBounds(0, 0, getWidth() / 3, getHeight());
        list.setListData(entries.toArray());


        add(list);
    }

}
