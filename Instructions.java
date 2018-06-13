/**
 * Auto Generated Java Class.
 */
//import the libraries
import java.util.Scanner;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JFrame{
  JFrame f = new JFrame();
  JButton backButton = new JButton ("Go Back");
  JLabel bg = new JLabel(new ImageIcon ("bg.jpg"));
  public Instructions(){
    f.setVisible(true);
    f.setSize(300,300);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setLayout(null);
    bg.setBounds(0,0,300,300);
    backButton.setBounds(200,200,100,50);
    f.add(bg);
    f.add(backButton);
    
  }
  public static void main(String[] args) { 
    new Instructions();
  }
  
}
