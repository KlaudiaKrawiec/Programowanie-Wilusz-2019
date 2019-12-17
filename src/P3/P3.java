import java.awt.*;
import java.awt.event.*;
class P3 extends Frame implements MouseListener, ActionListener
{
    public static void main(String args[])
    {
        new P3();
    }
    P3()
    {
        setLayout(new FlowLayout());
        for(int i = 0; i < 5; i++)
        {
            Button b = new Button("A | " + (i+1));
            b.addActionListener(this);
            b.addMouseListener(this);
            add(b);
        }
        pack();
        show();
    }
    public void mouseEntered(MouseEvent e)
    {
        e.getComponent().setBackground(Color.yellow);
    }
    public void mouseExited(MouseEvent e)
    {
        e.getComponent().setBackground(SystemColor.control);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {}
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Action performed on " +e.getActionCommand());
    }
}