import java.awt.*;
import java.awt.event.*;

class P14 extends Frame implements ActionListener
{
    PopupMenu pm = null; // menu
    Component currContext = null; // kontekst otwarcia
    P14()
    {
        setLayout(new FlowLayout());
        pm = new PopupMenu();// Tworzenie nowego menu kontekstowego
        String miLab[] = { "Jeden", "Dwa", "Trzy", "KONIEC" };
        for (int i = 0; i < miLab.length; i++)
        { // Nowy element menu
            MenuItem mi = new MenuItem(miLab[i]);
            mi.setActionCommand(miLab[i]); // Skojarzona z mm akcja
            mi.addActionListener(this);// ... i skojarzony słuchacz akcji
            pm.add(mi); // Element dodawany Jest do menu
        }
        add(pm); // Dodanie menu kontekstowego do okna
        Button b = new Button("Jakis przycisk");// Jakiś przycisk
        add(b);
        MouseListener ma=new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                if (e.isPopupTrigger())
                {
                    currContext = e.getComponent();
                    pm.show(currContext, e.getX(), e.getY());
                }
            }
        };

        // Jak łatwo zapomnieć:
        b.addMouseListener(ma); // pozwala otworzyć menu na przycisku
        this.addMouseListener(ma); // a to na samym oknie
        pack();
        show(); // albo setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String Comm=e.getActionCommand();
        System.out.println(Comm);
        System.out.println("Na komponencie: " + currContext.toString());
        if(Comm.equals("KONIEC"))
        {
            dispose();
            System.exit(0);
        }

    }
    public static void main(String args[])
    {
        new P14();
    }
}