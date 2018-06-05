import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ball2 {
  
  public ball2(){
    
    JFrame frame = new JFrame("Key Listener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.setVisible(true);
    
    final JTextField textField = new JTextField("input here",10);
    JPanel p = new JPanel();
    KeyListener listener = new KeyListener() {
      
      public void keyPressed(KeyEvent event) {
        printEventInfo("Key Pressed", event);
        textField.setText("");
      }
      
      
      public void keyReleased(KeyEvent event) {
        printEventInfo("Key Released", event);
      }
      
      public void keyTyped(KeyEvent event) {
        printEventInfo("Key Typed", event);
      }
      
      private void printEventInfo(String str, KeyEvent e) {
        System.out.println(str);
        int code = e.getKeyCode();
        System.out.println("   Code: " + KeyEvent.getKeyText(code));//caps for chars, location for arrow keys
        System.out.println("   Char: " + e.getKeyChar());
        System.out.println("    Action? " + e.isActionKey());
      }
      private String keyboardLocation(int keybrd) {
        if (keybrd == KeyEvent.VK_DOWN){
          return("down");
        }
        if (keybrd == KeyEvent.VK_UP){
          return("up");
        }
        if (keybrd == KeyEvent.VK_LEFT){
          return("left");
        }
        if (keybrd == KeyEvent.VK_RIGHT){
          return("right");
          
        }
        return " ";
      }
      
    };
    //p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    
    p.setLayout(null);
    
    
    
    textField.setBounds(0, 0, 100, 100);
    JLabel l = new JLabel("Text");
    l.setBounds(100,100,100,100);
    textField.addKeyListener(listener);
    p.add(textField);
    p.add(l);
    frame.add(p);
    frame.setVisible(true);
  }
  public static void main(String args[]) {
    ball2 a = new ball2();
    
  }
}
