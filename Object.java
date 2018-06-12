/**
 * Object object
 * Currently has set values, for the tako npc
 */
import javax.swing.*;  
public class Object {
  
  //position x & y positions
  private int x;
  private int y;
  
  //size x & y dimensions
  private int sx;
  private int sy;
  
  private String description;
  
  public Object(String x, String y, String sx, String sy, String descr){
    this.x = Integer.parseInt(x);
    this.y = Integer.parseInt(y);
    this.sx = Integer.parseInt(sx);
    this.sy = Integer.parseInt(sy);
    this.description = descr;
  }
  
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
  public String getDescr(){
    return description;
  }
}
