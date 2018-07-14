/* Item.java
 * Julia Zhao and Tasha Xiao
 *  Item class for the 12U final project
 * June 14 2018
 */

public class Item extends ObjectTemplate{
  //variable declaration
  private String name="";
  private boolean isFound=false;
  
  public Item(){ //default constructor
  }
  
  //the constructor that is used
  //sets the values
  public Item(String name, String description){
    this.name=name;
    this.description=description;
  }//end of constructor 
  
  //set methods for the program, sets the values of the specified variable
  /* setName
   * changes the item name
   * @param name      the name that it is changed to
   */
  public void setName(String name){
    this.name = name;
  }//end of setName()
  
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
  /* setFound
   * changes to true when the item is discovered by the player
   */
  public void setFound(){
    this.isFound=true;
  }

  //get methods for the program, gets the values of the specified variable
 /* getName()
  * @return    the name of the item
  */
  public String getName(){
    return this.name;
  }
  /* getDesc()
  * @return    the description of the item
  */
  public String getDesc(){
    return this.description;
  }
  /* getNum()
  * @return    the number of the item
  */
  public int getNum(){
    return this.number;
  }
  /* getFound()
  * @return     whether or not the item has been found
  */
  public boolean getFound(){
    return this.isFound;
  }
  
}//end of Item class