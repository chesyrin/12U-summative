/* Menu.java
 * Julia Zhao and Tasha Xiao
 * Menu GUI for the 12U final project
 * June 1 2018
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;

public class Menu implements ActionListener{
  public Menu(){ //constructor
    //create stuff for GUI
    JFrame frame = new JFrame ("i don't know anything anymore: a game");
    JPanel overPanel = new JPanel();
    JPanel bgPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    
    JLabel name = new JLabel ("i don't know anything anymore: an original game by tash and jul");
    JButton start = new JButton ("START");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set behaviour for frame
    frame.setSize(700,500);
    frame.setResizable(false);
    
    LayoutManager overlay = new OverlayLayout(overPanel); //overlay layout for background
    overPanel.setLayout(overlay);
    contentPanel.setOpaque(false);
    
    ImageIcon icon = new ImageIcon("menuBackground.jpg");
    JLabel iconLabel = new JLabel(icon);
    bgPanel.add(iconLabel);
    
    start.addActionListener(this); //actionListener leads to gameplay screen
    
    name.setFont(new Font("Raleway", Font.BOLD, 20)); //change font and size of label font
    name.setForeground(Color.WHITE);
    
    start.setOpaque(false); //make button background transparent
    start.setContentAreaFilled(false);
    start.setForeground(Color.WHITE);
    start.setPreferredSize(new Dimension(100,100)); //change size of button
    
    contentPanel.add(name); //add components onto panel, then panel onto frame
    contentPanel.add(start);
    
    overPanel.add(contentPanel);
    overPanel.add(bgPanel);
    
    frame.add(overPanel);
    
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    System.out.println ("Starting...");
  }
  
  public static void main(String[]args){
    new Menu();
  }
}
