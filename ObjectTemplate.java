/**
 *
 */
public abstract class ObjectTemplate {
  int number=-1;
  String description = "";
  //default constructor
  public ObjectTemplate() { 
   
  }
  public abstract void setDesc(String descr);
  public abstract void setNum(int num);
  public abstract String getDesc();
  public abstract int getNum();
}
