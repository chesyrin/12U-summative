/**
 * Object.java
 * Objects are things that the player cannot run into in the GUI
 * Julia Zhao and Tasha Xiao
 * June 14 2018
 */

public class Object extends ObjectTemplate{
  
  //the image begins at x and y
  private int x;
  private int y;
  
  //the image ends at sx and sy
  private int sx;
  private int sy;
  
  public Object(){//default constructor
  }
  
  /* the constructor that's actually used
   * @param x      the starting x value of the image
   * @param y      the starting y value of the image
   * @param sx     the ending x value of the image
   * @param sy     the ending y value of the image
   * @param num    the item the object is linked to(has the same num)
   * @param descr  the description of the image
   */
  public Object(int x, int y, int sx, int sy, int num, String descr){
    //set the values
    this.x = x;
    this.y = y;
    this.sx = sx;
    this.sy = sy;
    this.number = num;
    this.description = descr;
  }//end of constructor
  
  //get methods
    /* setNum
   * changes the item number
   * @param num      the number that it is changed to
   */
  public void setNum(int num){
    this.number = num;
  }
    /* setDesc
   * changes the description of the item
   * @param desc      the description that it is changed to
   */
  public void setDesc(String desc){
    this.description = desc;
  }
  
  /* getX()
   * @return  the starting x value
   */
  public int getX(){
    return x;
  }//end of getX()
  
  /* getY()
   * @return  the starting y value
   */
  public int getY(){
    return y;
  }//end of getY()
  
  /* getSx()
   * @return  the ending x value
   */
  public int getSx(){
    return sx;
  }//end of getSx()
  
  /* getSy()
   * @return  the ending y value
   */
  public int getSy(){
    return sy;
  }//end of getSy()
  
  /* getNum()
   * @return  the index value of the object
   */
  public int getNum(){
    return number;
  }//end of getNum()
  
  /* getDesc()
   * @return  the object's description
   */
  public String getDesc(){
    return description;
  }//end of getDesc()
}//end of Object class
