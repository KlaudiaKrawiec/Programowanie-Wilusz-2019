import java.awt.*;
import java.awt.event.*; // by obsługiwać zdarzenia
class Lis extends Frame implements ActionListener
{
    Lis()
    {
        setLayout(new GridLayout(1,2));
        String s1[] = {"Ala", "Ma", "Kota" },
                s2[] = { "1", "2", "3", "4", "5" };
        List l = createList(s1);
        l.addActionListener(this);
        add(l);
        add(createList(s2));
        pack();
        show();
    }
    List createList(String s[])
    {
        List l = new List();
        for (int i=0; i<s.length; i++) l.addItem(s[i]);
        return l ;
    }
    public void actionPerformed(ActionEvent e)
    {
        setTitle(e.getActionCommand());
    }
    public static void main(String[] args)
    {
        new Lis();
    }
}
