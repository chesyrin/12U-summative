/* Puzzle.java
 * Julia Zhao and Tasha Xiao
 * Puzzle class for the 12U final project
 * May 31 2018
 */

public class Puzzle {
  private String question = "";
  private int number=-1;
  
  public Puzzle (){ //default constructor
  }
  
  //methods to set the specified variables
  public void setQ(String q){
    this.question=q;
  }
  
  public void setNum(int num){
    this.number=num;
  }
  
  //methods to retrieve the specified variables
  public String getQ(){
    return this.question;
  }
  
  public int getNum(){
    return this.number;
  }
  
}
