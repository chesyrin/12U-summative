import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ball2 {
  int x = 0, y = 0, velx =0, vely =0;
  public ball2(){
    
    JFrame frame = new JFrame("Key Listener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.setVisible(true);
    
    final JLabel l = new JLabel("Text");
    final JTextField textField = new JTextField("input here",10);
    JPanel p = new JPanel();
    KeyListener listener = new KeyListener() {
      
      public void keyPressed(KeyEvent event) {
        //    printEventInfo("Key Pressed", event);
        keyboardLocation(event.getKeyCode());
        textField.setText("");
        
        System.out.println("button pressed");
        
        //sets bounds
        if(x < 0)
        {
          velx=0;
          x = 0;  
        }
        
        if(x > 530)
        {
          velx=0;
          x = 530;  
        }
        
        if(y < 0)
        {
          vely=0;
          y = 0;  
        }
        
        if(y > 330)
        {
          vely=0;
          y = 330;  
        }
        
        
        x += velx;
        y += vely;
        l.setLocation(x, y);
//        vely = 0;
//        velx = 0;
        System.out.println("x" + x + "y" + y);
      }
      
      
      public void keyReleased(KeyEvent event) {
        //   printEventInfo("Key Released", event);
        velx=0;
        vely=0;
      }
      
      public void keyTyped(KeyEvent event) {
        //    printEventInfo("Key Typed", event);
      }
      
      private void keyboardLocation(int keybrd) {
        if (keybrd == KeyEvent.VK_DOWN){
          vely = 1;
          velx = 0;
        }
        if (keybrd == KeyEvent.VK_UP){
          vely = -1;
          velx = 0;
        }
        if (keybrd == KeyEvent.VK_LEFT){
          vely = 0;
          velx = -1;
        }
        if (keybrd == KeyEvent.VK_RIGHT){
          vely = 0;
          velx = 1;
          
        }
      }
      
    };
    p.setLayout(null);
    
    
    
    textField.setBounds(0, 0, 100, 100);
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
