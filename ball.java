import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ball extends JPanel implements ActionListener{//, KeyListener {
  JFrame f = new JFrame();
  JPanel p = new JPanel();
  JLabel l = new JLabel("Text");
  JButton b = new JButton ("UP");
  Timer t = new Timer(5, this);//time of delay
  int x = 0, y = 0, velx =0, vely =0;
  
  public ball() {
    t.start();
//    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(600,400);
    f.setVisible(true);
    p.setLayout(null);
    p.add(l);
    p.add(b);
    f.add(p);
    b.addActionListener(this);
    l.setBounds(0, 0,100, 100);
    b.setBounds(300,300,100, 100);

    
  }
  
  
//public void paintComponent(Graphics g) {
// super.paintComponent(g);
// g.setColor(Color.RED);
// g.fillRect(x,y,30,30);//position, size of box
//}
  
  public void actionPerformed(ActionEvent e) {
    vely = 1;
    velx = 0;
    
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
    l.setLocation(x, y);//
//    l.setBounds(x, y, 200, 200);//position, size
    //   repaint();
  }
  
//  public void keyPressed(KeyEvent e) {
//    int code = e.getKeyCode();
//    
//    if (code == KeyEvent.VK_DOWN){
//      vely = 1;
//      velx = 0;
//      System.out.println("down");
//    }
//    if (code == KeyEvent.VK_UP){
//      vely = -1;
//      velx = 0;
//    }
//    if (code == KeyEvent.VK_LEFT){
//      vely = 0;
//      velx = -1;
//    }
//    if (code == KeyEvent.VK_RIGHT){
//      vely = 0;
//      velx = 1;
//      
//    }
//  }
  
  
  
  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {
    velx=0;
    vely=0;
  }
  
  
  public static void main (String arge[]){
    
    
    ball s = new ball();
    
    
  }
}

