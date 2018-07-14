/* Instructions.java
 * Julia Zhao and Tasha Xiao
 * Instructions GUI for the 12U final project
 * June 1 2018
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;

public class Instructions implements ActionListener{
  JFrame frame = new JFrame ("Instructions");
  public Instructions(){ //constructor`
    //create stuff for GUI
    JPanel overPanel = new JPanel();
    JPanel bgPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(null);
    
    JButton start = new JButton ("START");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set behaviour for frame
    frame.setSize(700,500);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    
    LayoutManager overlay = new OverlayLayout(overPanel); //overlay layout for background
    overPanel.setLayout(overlay);
    contentPanel.setOpaque(false);
    
    ImageIcon icon = new ImageIcon("instructions.png");
    JLabel iconLabel = new JLabel(icon);
    bgPanel.add(iconLabel);
    
    start.addActionListener(this); //actionListener leads to gameplay screen
    
    start.setOpaque(false); //make button background transparent
    start.setContentAreaFilled(false);
    start.setForeground(Color.WHITE);
    start.setPreferredSize(new Dimension(100,100)); //change size of button
   start.setBounds (450, 300, 100, 100);
    
    contentPanel.add(start);
    
    overPanel.add(contentPanel);
    overPanel.add(bgPanel);
    
    frame.add(overPanel);
    
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    new ball2();
    new VisualNovel("text.txt");
    frame.dispose();
  }
}