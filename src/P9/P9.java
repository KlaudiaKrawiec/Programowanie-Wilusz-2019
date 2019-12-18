// Klasa TextPanel (modyfikacje)
class TextPanel extends Panel implements FocusListener
{
    TextField tf;
    TextPanel prev, next;
    // tekst-panele tworzą listę; każdy ma referencję do poprzedniego i następnego
    /* Tu definiujemy focusGained i focusLost patrz przykład 8*/
// Konstruktor
    TextPanel(int cols, TextPanel p){
// argument - poprzedni TextPane1 na liście do obsługi
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(NOTFOCUS);
        tf = new TextField(cols);
        tf.addFocusListener(this);
        prev = p;
        if (prev != null) prev.next = this;
        tf.addKeyListener( new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                int key = e.getKeyCode();
                String ktxt = KeyEvent.getKeyText(key);
                if (ktxt.equals("Enter") || ktxt.equals("Down"))
                { // następny na liście
                    if (next != null) next.tf.requestFocus();
                }
                else
                if (ktxt.equals("Up") && prev != null)
                    prev.tf.requestFocus(); // poprzedni
            }
        });
        add(tf);
    }


    public static void main(String args[])
    {
        Frame f = new Frame ("Text Field");
        f.setLayout(new GridLayout(0,1));
        TextPanel tp[] = new TextPanel[3];
        for( int i = 0; i < 3; i++)
        {
            tp[i] = new TextPanel(40, (i > 0? tp[i-1]:null));
            f.add(tp[i]);
        }
        f.pack();
        f.show();
    }
}