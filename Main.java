/* Main.java
 * Julia Zhao and Tasha Xiao
 * Main class for the 12U final project
 * May 31 2018
 */

import java.util.Scanner;
import java.io.*;

public class Main {
  private static SimpleLinkedList<Item> items = new SimpleLinkedList<Item>();
  private static SimpleLinkedList<Item> inventory = new SimpleLinkedList<Item>();
  private static SimpleLinkedList<Puzzle> puzzles = new SimpleLinkedList<Puzzle>();
  private static int endMusic=1;
  
  /* readItems method
   * Reads information in from items text file into list
   */
  public static void readItems(){
    try{
      Scanner read = new Scanner (new File ("items.txt"));
      while (read.hasNextLine()){
        Item newItem = new Item();
        //sets the variable values
        newItem.setName(read.next());
        newItem.setX(read.nextInt());
        newItem.setY(read.nextInt());
        newItem.setNum(read.nextInt());
        newItem.setDesc(read.nextLine());
        
        items.add(newItem);
      }
      read.close();
    }
    catch(Exception e){
      System.out.println("There is no text file called items.");
    }
  }
  
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
      }
      read.close();
    }
    catch(Exception e){
      System.out.println("There is no text file called puzzles.");
    }
  }
  
  /* solveRiddle method
   * If the player's answer is correct, make the appropriate changes to the linked lists
   * @param puzzle - the puzzle that the player is trying to solve
   * @param item - the item that the player thinks is the answer
   * @return boolean - if the riddle has been solved or not
   */
  public static boolean solveRiddle(Puzzle puzzle, Item item){
    if (puzzle.getNum()==item.getNum()){
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
  }
  
  /* checkItem method
   * Check if the player is standing in front of an item when they try to pick it up
   * @param x - x coordinate of the player
   * @param y - y coordinate of the player
   * @return boolean - if there is an item or not
   */
  public static boolean checkItem (int x, int y){
    for (int i = 0; i< items.size(); i++){
      //if user's x is within object's values
      if (items.get(i).getX()-10 < x && x < items.get(i).getX()+100){
        //if user's y is between y1 and y2
        if (items.get(i).getY()-10 < y && y < items.get(i).getY()+100){
          return true;
        }
      }
    }
    return false; //not in front of an object
  }
  
  /* threadMusic method
   * Method to start the music thread
   */
  public static class threadMusic implements Runnable //implements Runnable because it is executed by a thread
  {
    //method to tell program what to thread
    public void run()
    {
      try
      {
        Music.play(); //start playing the music
      }
      catch (Exception e)
      {
        System.out.println ("Error: " + e);
      }
    }
  }
  
  public static void main(String [] args){
    Thread music = new Thread (new threadMusic());
    music.start (); //start the thread
    
    System.out.println ("i don't know anything anymore: an original game by tash and jul");
    System.out.println ("(mrs. martin pls give us 100)\n");
    
    readItems();
    readPuzzles();
    
//    for (int i=2; i>=0; i--){
//      inventory.add(items.get(i));
//     // System.out.println (items.get(i).getName());
//    }
    
    //  System.out.println (inventory.size());
    new Menu(); //new Menu class
  }
  
  //get methods
  public static SimpleLinkedList<Item> getItems(){
    return items;
  }
  
  public static SimpleLinkedList<Item> getInventory(){
    return inventory;
  }
  
  public static SimpleLinkedList<Puzzle> getPuzzles(){
    return puzzles;
  }
  
  //set methods
  public static void setEndMusic(){
    endMusic=0;
  }
}