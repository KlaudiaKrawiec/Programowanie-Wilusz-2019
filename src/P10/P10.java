class TextPanel extends Panel implements FocusListener, TextListener
{
    boolean hasTxtListener = false; // czy dla danego pola słuchacz tekstu przyłączony?
    TextField tf;
    final Color NOTFOCUS = Color.gray, FOCUS = Color.blue, ERROR = Color.red;
    Color currColor = FOCUS;
    TextPanel(int cols){ /*Patrz przyklad 8*/}
    public Insets getInsets() {/*Patrz przyklad 8*/}
    public void focusGained(FocusEvent e) {/*Patrz przyklad 8*/}
    public void focusLost(FocusEvent e)
    {
        if (!good())
        {
            getToolkit().beep();
            currColor = ERROR;
            if (!hasTxtListener)
            {
                tf.addTextListener(this);
                System.out.println("Słuchacz tekstu przyłączony");
                hasTxtListener = true;
            }
            tf.requestFocus();
            return;
        }
        currColor = FOCUS;
        setBackground(NOTFOCUS);
    }
    public void textValueChanged(TextEvent e)
    {
        if (good())
        {
            tf.removeTextListener(this);
            System.out.println("Słuchacz tekstu ODŁĄCZONY");
            hasTxtListener = false;
            setBackground(FOCUS);
        }
    }
    private boolean good()
    {
        String s = tf.getText();
        if (!s.equals(""))
        {
            try
            {
                int i = Integer.parseInt(s);
            }
            catch(NumberFormatException exc)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    { /*utworz okienko i dodaj kilka obiektów TextPanel */}
}