import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class P5
{
    public static void main(String[] args)
    {
        Frame f = new Frame("Główne okno aplikacji");
        f.addWindowListener(new AppEnd());
        f.setSize(300,300);
        f.setVisible(true);
    }
}
class AppEnd extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        e.getWindow().dispose();
// metoda getWindow dostarcza referencji do okna
        System.exit(0);
    }
}