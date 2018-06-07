/**
 * 
 */
import javax.swing.*;  
public class Object {
  
  //position x & y positions
  private int x = 200;
  private int y = 200;
  
  //size x & y dimensions
  private int sx = 38;
  private int sy = 43;
  
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
