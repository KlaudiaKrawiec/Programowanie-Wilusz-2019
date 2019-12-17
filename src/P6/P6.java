import java.awt.*;
import java.awt.event.*;
public class Lista extends Frame
{
    void say(String s)
    {
        System.out.println(s);
    }
    public Lista()
    {
        List l = new List();
        l.add("Mrówka");
        l.add("Krówka");
        l.add("Kózka");
        l.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                say("0riginator = "+e.getItemSelectable());
                say("Item = "+e.getItem());
                if (e.getStateChange() == ItemEvent.SELECTED)
                    say("SELECTED");
                else
                    say("DESELECTED");
            }
        });
        setLayout(new FlowLayout());
        add(l);
    }

    public static void main(String args[])
    {
        System.out.println("Starting App");
        Lista f = new Lista();
        f.pack();
        f.show();
    }
}
