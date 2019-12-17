import javax.swing.*;
import java.awt.*;

class KomponentySwingP2 {

    public static void main(String[] args) {
        MyGUI tt = new MyGUI("Przykład");
        tt.setSize(400, 300);
        tt.setVisible(true);
    }
}

class MyGUI extends JFrame
{
    JTextArea ta = new JTextArea ("Obszar tekstowy", 10, 80);
    JButton bt = new JButton ("Przycisk");
    JTextField tf = new JTextField ("Pole tekstowe", 80);
    JTextArea ta2 = new JTextArea ("", 10, 16);
    MyGUI (String title)
    {
        super (title);
        ta.setLineWrap (true);
        ta2.setLineWrap (true);
        GridBagLayout gb = new GridBagLayout ();
        Container cp = getContentPane ();
        cp.setLayout (gb);
        GridBagConstraints cs = new GridBagConstraints ();
        // obszar tekstowy
        cs.fill = GridBagConstraints.BOTH;
        cs.insets = new Insets (3, 3, 3, 3);
        cs.gridheight = 10;
        cs.gridwidth = 4;
        cs.weightx = 8;
        cs.weighty = 9;
        gb.setConstraints (ta, cs);
        cp.add (ta);
        // obszar tekstowy - pusty
        cs.gridheight = 10;
        cs.gridwidth = GridBagConstraints.REMAINDER;
        cs.weightx = 0;
        cs.weighty = 0;
        gb.setConstraints (ta2, cs);
        cp.add (ta2);
        // pole tekstowe
        cs.fill = GridBagConstraints.HORIZONTAL;
        cs.gridheight = 1;
        cs.gridwidth = 4;
        gb.setConstraints (tf, cs);
        cp.add (tf);
        // przycisk
        cs.gridheight = 1;
        cs.gridwidth = 1;
        gb.setConstraints (bt, cs);
        cp.add (bt);
    }
}