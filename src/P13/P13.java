class MainWork implements ActionListener
{
    private Gui gui = null ; // obiekt klasy Gui
    public static void main(String args[])
    {
        MainWork MainWorkInstance = new MainWork();
    }
    MainWork()
    {
        // Etykiety oznaczające czynności
        String labels[]={"Add","Select","Remove","Exit"};
        // Nazwy poleceń związanych z czynnościami
        String cmd[] = { "doAdd", "doSelect", "doRemove", "exit" };
        int critical[] = { 2, 3 }; // indeksy czynności krytycznych
        // Tworzenie GUI. Ostatni argument = Słuchacz akcji
        gui = new Gui(labels, cmd, critical, this);
    }
    public void actionPerformed(ActionEvent e){ // Obsługa akcji
        String cmd = e.getActionCommand();
        if (cmd.equals("doAdd")) doAdd();
        else if (cmd.equals("doSelect")) doSelect();
        else if (cmd.equals("doRemove")) doRemove();
        else if (cmd.equals("exit")) exit();
    }
//tu definicje metod wykonujących czynności, np. void exit()
}
    Implementacja interfejsu graficznego
class Gui extends Frame
{
    Gui(String labels[], String commands[], int critical[], ActionListener a)
    {
        super("Test");
        int n = labels.length, i;
        Button b[] = new Button[n];
        setLayout(new GridLayout());
        for (i = 0; i < n; i++)
        {
            b[i] = new Button(labels[i]);
            b[i].setActionCommand(commands[i]);
            b[i].addActionListener(a);
            add(b[i]);
        }
        // tylko krytyczne odpowiedzą Słuchaczowi myszy
        for (i=0; i < critical.length; i++)
            b[critical[i]].addMouseListener(ml);
        pack();
        setVisible(true);
    }
    MouseListener ml = new MouseAdapter()
    {
        public void mouseEntered(MouseEvent e)
        {
            e.getComponent().setBackground(Color.orange);
        }
        public void mouseExited(MouseEvent e)
        {
            e.getComponent().setBackground(SystemColor.control);
        }
    };
} class MainWork implements ActionListener
{
    private Gui gui = null ; // obiekt klasy Gui
    public static void main(String args[])
    {
        MainWork MainWorkInstance = new MainWork();
    }
    MainWork()
    {
        // Etykiety oznaczające czynności
        String labels[]={"Add","Select","Remove","Exit"};
        // Nazwy poleceń związanych z czynnościami
        String cmd[] = { "doAdd", "doSelect", "doRemove", "exit" };
        int critical[] = { 2, 3 }; // indeksy czynności krytycznych
        // Tworzenie GUI. Ostatni argument = Słuchacz akcji
        gui = new Gui(labels, cmd, critical, this);
    }
    public void actionPerformed(ActionEvent e){ // Obsługa akcji
        String cmd = e.getActionCommand();
        if (cmd.equals("doAdd")) doAdd();
        else if (cmd.equals("doSelect")) doSelect();
        else if (cmd.equals("doRemove")) doRemove();
        else if (cmd.equals("exit")) exit();
    }
//tu definicje metod wykonujących czynności, np. void exit()
}

class Gui extends Frame
{
    Gui(String labels[], String commands[], int critical[], ActionListener a)
    {
        super("Test");
        int n = labels.length, i;
        Button b[] = new Button[n];
        setLayout(new GridLayout());
        for (i = 0; i < n; i++)
        {
            b[i] = new Button(labels[i]);
            b[i].setActionCommand(commands[i]);
            b[i].addActionListener(a);
            add(b[i]);
        }
        // tylko krytyczne odpowiedzą Słuchaczowi myszy
        for (i=0; i < critical.length; i++)
            b[critical[i]].addMouseListener(ml);
        pack();
        setVisible(true);
    }
    MouseListener ml = new MouseAdapter()
    {
        public void mouseEntered(MouseEvent e)
        {
            e.getComponent().setBackground(Color.orange);
        }
        public void mouseExited(MouseEvent e)
        {
            e.getComponent().setBackground(SystemColor.control);
        }
    };
}