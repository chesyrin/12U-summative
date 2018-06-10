/**
 * Object object
 * Currently has set values, for the tako npc
 */
import javax.swing.*;  
public class Object {
  
  //position x & y positions
  private int x = 150;
  private int y = 150;
  
  //size x & y dimensions
  private int sx = 38;
  private int sy = 46;
  
  //the sprite
  private JLabel sprite = new JLabel(new ImageIcon("tako.png"));
  
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getSx(){
    return sx;
  }
  public int getSy(){
    return sy;
  }
  public JLabel getSprite(){
    return sprite;
  }
}
