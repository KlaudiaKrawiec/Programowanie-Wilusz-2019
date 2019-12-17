import java.awt.*;
import java.awt.event.*;
class P11 extends MouseAdapter
{
    Frame f = new Frame();
    public static void main(String args[])
    {
        new P11();
    }
    P11()
    {
        f.setLayout(new FlowLayout());
        for(int i = 0; i < 5; i++)
        {
            Button b = new Button("A | " + (i+1));
            b.addMouseListener(this);
            f.add(b);
        }
        f.pack();
        f.show();
    }
    public void mouseClicked(MouseEvent e)
    {
        int m = e.getModifiers();
        int x = e.getX();
        int y = e.getY();
        Component c = e.getComponent();
        int w = c.getSize().width;
        String lab = ((Button) c).getLabel();
        String cmd = ((Button) c).getActionCommand() ;
        String s = "Lab: "+lab+" Cmd: "+cmd+" - akcja dla: ";
// Niuans: sprawdzenie, który klawisz myszy - nie przez isPopupTrigger() !
        if ((m & InputEvent.META_MASK) != 0) s = s + "RIGHT";
        else s = s+"LEFT";
        if ((m & InputEvent.SHIFT_MASK) != 0) s = s + "-SHIFT";
        if ((m & InputEvent.ALT_MASK) != 0) s = s + "-ALT";
        if ((m & InputEvent.CTRL_MASK) != 0) s = s + "-CTRL";
        s = s + "-CLICK";
        if (x > w/2) s = s + " na prawej połowie";
        else if (x < w/2) s = s + " na lewej połowie";
        else s = s + " w środku";
        System.out.println(s);
    }
} 