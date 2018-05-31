/* Character.java
 * Julia Zhao and Tasha Xiao
 * Abstract character class for the 12U final project
 * May 31 2018
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.*;

public abstract class Character {
  String name;
  ImageIcon image;
  JLabel label;
  
  abstract void talk(); //abtract method talk
}
