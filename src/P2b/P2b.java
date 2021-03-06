import java.awt.*;
import java.awt.event.*; // Zdarzenia
import java.util.*; // Hashtable
class P2b extends Frame implements ActionListener
{
    Button bdel;
    private Hashtable htf = new Hashtable();
    private TextArea editor = new TextArea(10,40);
    P2b()
    {
        bdel = new Button("Delete");
        bdel.addActionListener(this);
        panel.add(bdel);
        super("List");
        String lt[] = { "List oficjalny", "List firmowy", "List mily", };
        htf.put(lt[0], "Szanowny Panie!\n\nZ powazaniem\n" );
        htf.put(lt[1],"W nawiazaniu do pisma z dnia ... uprzejmie ");
        htf.put(lt[2],"Droga ... \n\nSerdecznosci\n");
        String ad[] = { "Praca", "Dom", "Uczelnia"};
        htf.put(ad[0], "ul. Kozia 1");
        htf.put(ad[1], "ul. Misia 2");
        htf.put(ad[2], "ul. Sowia 3");
        MenuBar mbar = new MenuBar();
        Font font = new Font("Dialog", Font.PLAIN, 14);
        editor.setFont(font);
        Menu menu = new Menu("Listy");
        menu.setFont(font);
        mbar.add(menu);
        for (int i = 0; i < lt.length; i++)
        {
            String label = lt[i];
            MenuItem mi = new MenuItem(label);
            mi.setFont(font);
            mi.addActionListener(this);
            menu.add(mi);
        }
        setMenuBar(mbar);
        add(editor, "Center");
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(1,ad.length));
        for (int i = 0; i < ad.length; i++)
        {
            String label = ad[i];
            Button b = new Button(label);
            b.addActionListener(this);
            panel.add(b);
        }
        add(panel, "South");
        pack() ;
        setVisible(true);
    }
    public void actionPerformed(ActionEvent aev)
    {
        if (aev.getSource() == bdel)// czy kliknięto przycisk bdel
        {
            editor.setText(""); // kasowanie tekstu
            return ;
        }// poprzednie działanie (dopisywanie fragmentów listu):
        String key = aev.getActionCommand();
        String txt = (String) htf.get(key);
        if (txt != null) editor.append(txt);
    }
    public static void main(String args[])
    { new P2b();}
}