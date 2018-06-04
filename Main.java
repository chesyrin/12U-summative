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
      puzzles.remove(0);
      inventory.remove(0); //need to initialize inventory once gameplay starts
      return true;
    }
    return false;
  }
  
  public static void main(String [] args){
    System.out.println ("i don't know anything anymore: an original game by tash and jul");
    System.out.println ("(mrs. martin pls give us 100)\n");
   
    readItems();
    readPuzzles();
    
    //debugging, check if files have been read in correctly
    for (int i=0; i<4; i++){
      System.out.println (items.get(i).getDesc());
    }
    puzzles.remove(0);
    new VisualNovel(puzzles, items);
  }
  
}