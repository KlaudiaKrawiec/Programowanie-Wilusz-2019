import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class P7 extends Frame
{
    String tback = "";
    P7()
    {
        TextField tf = new TextField(40);
        tf.addTextListener( new TextListener(){
            public void textValueChanged(TextEvent e){
                TextComponent t = (TextComponent) e.getSource();
                try {
                    int i = Integer.parseInt(t.getText());
                }
                catch(NumberFormatException exc){
                    getToolkit().beep();
                    t.setText(tback);
                }
                tback = t.getText();
            }
        });
        add(tf);
        pack();
        setVisible(true);
    }
    public static void main(String[] args){ new P7();}
}