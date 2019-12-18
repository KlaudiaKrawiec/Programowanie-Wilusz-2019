class TextPanel extends Panel implements FocusListener{
    TextField tf;
    final Color NOTFOCUS = Color.gray, FOCUS = Color.blue, ERROR = Color.red;
    Color currColor = FOCUS;
    TextPanel(int cols){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(NOTFOCUS);
        tf = new TextField(cols);
        tf.addFocusListener(this);
        add(tf);
    }
    public Insets getInsets() { return new Insets(5,5,5,5); }
    public void focusGained(FocusEvent e){ setBackground(currColor); }
    public void focusLost(FocusEvent e) {
        String s = tf.getText();
        if (!s.equals(""))//Pomijamy przypadek pustego pola
        {
            try{ int i = Integer.parseInt(s); }
            catch(NumberFormatException exc) {
                getToolkit().beep();
                currColor = ERROR;
                tf.requestFocus(); // żądanie przywrócenia fokusu elementowi
                return;
            }
        }
        currColor = FOCUS;
        setBackground(NOTFOCUS);
    }
}