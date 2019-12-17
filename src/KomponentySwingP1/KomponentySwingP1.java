import java.awt.*;
import javax.swing.*;
class KomponentySwingP1
{
    public static void main (String[] args)
    {
        MyGUI tt = new MyGUI ("Wyklad 3");
        tt.setSize (400, 300);
        tt.setVisible (true);
    }
}
class MyGUI extends JFrame
{
    JButton b1 = new JButton ("Pierwszy");
    JButton b2 = new JButton ("Drugi");
    JButton b3 = new JButton ("Trzeci");
    JButton b4 = new JButton ("Czwarty");
    JButton b5 = new JButton ("Piaty");
    JButton b6 = new JButton ("Szosty");
    JButton b7 = new JButton ("Siodmy");
    MyGUI (String title)
    {
        super (title);
        Container cp = getContentPane ();
        cp.setLayout (new GridLayout (4,3));
        cp.add (b1);
        cp.add (b2);
        cp.add (b3);
        cp.add (b4);
        cp.add (b5);
        cp.add (b6);
        cp.add (b7);
    }
}