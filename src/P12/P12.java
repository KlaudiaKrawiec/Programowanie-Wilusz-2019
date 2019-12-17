public class Events extends Frame implements ActionListener
{
    public Events()
    {
        setLayout(new GridLayout(0,1));
        for (int i=0;i<5;i++)
        {
            Button B=new AButton("Przycisk " +(i+1));
            B.addActionListener(this);
            add(B);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        int m = e.getModifiers();
        String s="Przycisnieto ";
        String lab= ((Button)e.getSource()).getLabel();
        s+=lab;
        if ((m & InputEvent.META_MASK) != 0) s = s + "RIGHT";
        if ((m & InputEvent.SHIFT_MASK) != 0) s = s + "-SHIFT";
        if ((m & InputEvent.ALT_MASK) != 0) s = s + "-ALT";
        if ((m & InputEvent.CTRL_MASK) != 0) s = s + "-CTRL";
        System.out.println(s);
    }

    public static void main(String args[])
    {
        System.out.println("Starting App");
        Events f = new Events();
        f.pack();
        f.show();
    }
}

class AButton extends Button implements FocusListener
{
    static Object focusButt = null; // kto ma focus
    AButton()
    {
        this("");
    }
    AButton(String label)
    {
        //w konstruktorze przyłączamy słuchaczy
        super(label);
        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                createActionOn(e);
                e.getComponent().requestFocus();
                // prawy klik nie zmienia fokusu, trzeba wymusić
            }
            public void mouseEntered(MouseEvent e)
            {
                light(true);
            }
            public void mouseExited(MouseEvent e)
            {
                if (e.getSource() != focusButt) light(false);
                // uwaga: jeśli przycisk, z którego wychodzi mysz ma fokus, nie wolno go zgasić!
            }
        });
        addKeyListener( new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    createActionOn(e);
            }
        });
        addFocusListener(this);
    }
    // w metodach obsługi fokusu zapamiętujemy, kto ma fokus
    public void focusGained(FocusEvent e)
    {
        light(true);
        focusButt = e.getSource();
    }
    public void focusLost(FocusEvent e)
    {
        light(false);
        focusButt = null;
    }
    void light(boolean on)// zapalanie i wygaszanie przycisków
    {
        Color c =(on ? Color.yellow : SystemColor.control);
        setBackground(c);
    }
}

    private void createActionOn(InputEvent e)
    {
        Button b = (Button) e.getSource();
// Fragment usuwający z kolejki zdarzeń podwójną akcję przy kliknięciu
        if (e.getID() == MouseEvent.MOUSE_CLICKED)
        {
            EventQueue que = getToolkit().getSystemEventQueue();
            AWTEvent nextEvent = que.peekEvent();
            while (nextEvent != null)
            {
                try{
                    nextEvent = que.getNextEvent();
                }
                catch(Exception exc)
                { break; }
                if(nextEvent.getID()==ActionEvent.ACTION_PERFORMED&&
                        nextEvent.getSource()==b) break;
                else
                    que.postEvent(nextEvent);
                nextEvent = que.peekEvent();
            }
        }
        // Budowa nowego zdarzenia (użycie konstruktora klasy ActionEvent)
        ActionEvent newAction = new ActionEvent(b, // źródło
                ActionEvent.ACTION_PERFORMED, // id
                b.getActionCommand(), // actioncommand
                e.getModifiers()); // modyfikatory, których brakowało
        b.dispatchEvent(newAction); // metoda klasy Component wysyła zdarzenie do kolejki
    }// Koniec metody createActionOn