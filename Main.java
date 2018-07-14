/* Main.java
 * Julia Zhao and Tasha Xiao
 * Main class for the 12U final project - run program here
 * June 14 2018
 */

//import libraries
import java.util.Scanner;
import java.io.*;

public class Main {
  //declare variables
  private static SimpleLinkedList<Item> items = new SimpleLinkedList<Item>();
  private static SimpleLinkedList<Item> inventory = new SimpleLinkedList<Item>();
  private static SimpleLinkedList<Puzzle> puzzles = new SimpleLinkedList<Puzzle>();
  
  /* readItems method
   * Reads information in from items text file into list
   */
  public static void readItems(){
    try{
      //import scanner and read in file
      Scanner read = new Scanner (new File ("items.txt"));
      while (read.hasNextLine()){
        Item newItem = new Item();
        //sets the variable values
        newItem.setName(read.next());
        newItem.setNum(read.nextInt());
        newItem.setDesc(read.nextLine());
        
        items.add(newItem);
      }
      //close scanner
      read.close();
    }//end of try
    catch(Exception e){
      System.out.println("There is no text file called items.");
    }//end of catch
  }//end of readItems()
  
   /* readObjects method
   * Reads information in from text file into list (in ball2)
   * For GUI use
   * @returns      the initialized SimpleLinkedList of objects
   */ 
  public static SimpleLinkedList<Object> readObjects(){
    //initialize the simple linked list
    SimpleLinkedList<Object> a = new SimpleLinkedList<Object>();
    //read in the information from txt file
    try {
      Scanner fileInput = new Scanner (new File ("objectList.txt"));
      while (fileInput.hasNextLine()){
        Scanner stringInput = new Scanner(fileInput.nextLine());
        Object temp = new Object(stringInput.nextInt(), stringInput.nextInt(), 
                                 stringInput.nextInt(), stringInput.nextInt(),
                                 stringInput.nextInt(), stringInput.nextLine());
        a.add(temp);
        stringInput.close();
      }//end of while loop
      //close scaner
      fileInput.close();
    }//end of try
    catch(Exception e){
      System.out.println("Object txt file error");
    }//end of catch
    return a;
  }//end of readObjects() method
  
  /* readPuzzles method
   * Reads information in from puzzles file into list
   */
  public static void readPuzzles(){
    try{
      Scanner read = new Scanner (new File ("puzzles.txt"));
      while (read.hasNextLine()){
        Puzzle newPuzzle = new Puzzle();
        //sets the variable values
        newPuzzle.setNum(read.nextInt());
        newPuzzle.setQ(read.nextLine());
        
        puzzles.add(newPuzzle);
      }//end of while loop
      read.close();
    }//end of try
    catch(Exception e){
      System.out.println("There is no text file called puzzles.");
    }//end of catch
  }//end of readPuzzles()
  
  /* solveRiddle method
   * If the player's answer is correct, make the appropriate changes to the linked lists
   * @param puzzle - the puzzle that the player is trying to solve
   * @param item - the item that the player thinks is the answer
   * @return boolean - if the riddle has been solved or not
   */
  public static boolean solveRiddle(Puzzle puzzle, Item item){
    if (puzzle.getNum()==item.getNum() && item.getFound()==true){
      //remove the puzzle and item from their respective lists
      if (puzzles.size()>1){
        puzzles.remove(0);
      }
      else{
        puzzles.clear();
      }
      //if more than one item in inventory
      if (inventory.size()>1){
        for (int i=0; i<inventory.size(); i++){
          if (inventory.get(i).equals(item)){
            inventory.remove(i); //need to initialize inventory once gameplay starts
          }
        }
      }
      else{
        inventory.clear();
      }
      return true;
    }
    return false;
  }//end of solveRiddle()
  
  /* ThreadMusic class
   * Threads the background music
   */
  public static class ThreadMusic implements Runnable 
  {
    //method to tell program what to thread
    public void run()
    {
      try {
          Music.play();
      }
      catch (Exception e)
      {
        System.out.println ("Error: " + e);
      }
    }
  }//end of class
  
  //main method
  public static void main(String [] args){
    //start the music
    Thread music = new Thread (new ThreadMusic());
    music.start (); //start the thread

    //initialize the SimpleLinkedLists
    readItems();
    readPuzzles();
    
    SimpleLinkedList.sort(items); //sort items (make sure its in order)
    
    for (int i=2; i>=0; i--){
      inventory.add(items.get(i));
    }
    //open the gui
//    new ball2();
    new Menu();
  }
  
  //get methods
  
  /* getItems()
   * @return     the simple linked list for items
   */
  public static SimpleLinkedList<Item> getItems(){
    return items;
  }
  
  /* getInventory()
   * @return     the simple linked list for the current inventory
   */
  public static SimpleLinkedList<Item> getInventory(){
    return inventory;
  }
  
  /* getPuzzles()
   * @return     the simple linked list for the puzzles
   */
  public static SimpleLinkedList<Puzzle> getPuzzles(){
    return puzzles;
  }
}//end of Main class