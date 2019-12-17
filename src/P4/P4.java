import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class P4 extends Frame //Tu nie ma implements !
{
    P4()
    {
        MouseListener ml = new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                e.getComponent().setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent e)
            {
                e.getComponent().setBackground(SystemColor.control);
            }
        };
        setLayout(new FlowLayout());
        for(int i = 0; i < 5; i++){
            Button b = new Button("A | " + (i+1));
            b.addMouseListener(ml); // tu dodajemy nasz wewnętrzny!
            add(b);
        }
    }
    public static void main(String args[])
    {
        P4 e=new P4();
        e.pack();
        e.show();
    }
}