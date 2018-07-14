/**
 * Tasha Xiao, Julia Zhao 
 * Character dialogue
 * VisualNovel.java
 */

//import the libraries
import java.util.Scanner;
import java.io.*;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class VisualNovel extends JFrame{
  
  JFrame f = new JFrame();//main frame
  JButton nextButton = new JButton ("Next");
  JButton backButton = new JButton("WAIT GO BACK I'M NOT READY");
  JLabel textLabel = new JLabel("Hello!");
  JLabel nameLabel = new JLabel("Tako");
  Scanner fileInput;
  String fileName="";
  File file;
  SimpleLinkedList<Puzzle> puzzles;
  SimpleLinkedList<Item> items;
  int turn=0;
  JFrame invFrame = new JFrame("Inventory");//inventory frame
  JPanel dialoguePanel = new JPanel();
  JPanel namePanel = new JPanel();
  
  JLabel npcLabel = new JLabel(new ImageIcon("npc.png"));
  JLabel playerLabel = new JLabel (new ImageIcon("player.png"));
  
  //start of constructor
  public VisualNovel(String fileName) 
  { 
    this.fileName=fileName;
    
    f.setTitle("");
    f.setSize(800,600);
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setLocationRelativeTo(null);
    
    File file = new File (fileName);

    //create a new font
    Font dosis = new Font ("Dosis Light", Font.PLAIN, 21);
    
    //adjusting the font and colour of the text label
    textLabel.setFont(dosis);
    textLabel.setForeground (Color.WHITE); //set colour
    textLabel.setBounds (40, 375, 400, 200);
    
    nextButton.setBounds(670,520,70,30);
    nextButton.setOpaque(false); //make button background transparent
    nextButton.setContentAreaFilled(false);
    nextButton.setForeground(Color.WHITE);
    nextButton.setSize(150,100);
    nextButton.addActionListener(new NextListener());
    
    backButton.setOpaque(false); //make button background transparent
    backButton.setContentAreaFilled(false);
    backButton.setForeground(Color.WHITE);
    backButton.setSize(150,100);
    backButton.addActionListener(new BackListener());
    backButton.setVisible(false);
    
    dialoguePanel.setBounds(30, 365, 725, 200); //set size
    dialoguePanel.setBackground(Color.BLACK);
//    dialoguePanel.setBackground(new Color(0,0,0,200)); //make it translucent
    dialoguePanel.add(textLabel);
    dialoguePanel.add(nextButton);
    dialoguePanel.add(backButton);
    
    f.add(dialoguePanel);
    
    nameLabel.setFont(dosis);
    nameLabel.setForeground(Color.WHITE);
    
    namePanel.setBounds(30,300,100,50); //set size
    namePanel.setBackground(Color.BLACK); //make it translucent
    namePanel.add(nameLabel);
    f.add(namePanel);
    
    playerLabel.setBounds(0,50,199,316);
    f.add(playerLabel);
    
    npcLabel.setBounds(500,100, 288, 288);
    f.add(npcLabel);
    
   try {fileInput = new Scanner(file);}
   catch (FileNotFoundException e ){System.out.println("File not found");}
  }//end of constructor 
  
    public VisualNovel(SimpleLinkedList<Puzzle> puzzles, SimpleLinkedList<Item> items) 
  { 
    f.setTitle("");
    f.setSize(800,600);
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setLocationRelativeTo(null);
    
    this.puzzles=puzzles;
    this.items=items;

    //create a new font
    Font dosis = new Font ("Dosis Light", Font.PLAIN, 21);
    
    //adjusting the font and colour of the text label
    textLabel.setFont(dosis);
    textLabel.setForeground (Color.WHITE); //set colour
    textLabel.setBounds (40, 375, 400, 200);
    
    //add skipButton and nextButton
    nextButton.setBounds(670,520,70,30);
    nextButton.setOpaque(false); //make button background transparent
    nextButton.setContentAreaFilled(false);
    nextButton.setForeground(Color.WHITE);
    nextButton.setSize(150,100);
    nextButton.addActionListener(new NextListener());
    
    backButton.setOpaque(false); //make button background transparent
    backButton.setContentAreaFilled(false);
    backButton.setForeground(Color.WHITE);
    backButton.setSize(150,100);
    backButton.addActionListener(new BackListener());
    backButton.setVisible(false);
    
    dialoguePanel.setBounds(30, 365, 725, 200); //set size
    dialoguePanel.setBackground(Color.BLACK);
    dialoguePanel.add(textLabel);
    dialoguePanel.add(nextButton);
    dialoguePanel.add(backButton);
    
    f.add(dialoguePanel);
    
    nameLabel.setFont(dosis);
    nameLabel.setForeground(Color.WHITE);
    
    namePanel.setBounds(30,300,100,50); //set size
    namePanel.setBackground(Color.BLACK); //make it translucent
    namePanel.add(nameLabel);
    f.add(namePanel);
    
    playerLabel.setBounds(0,50,199,316);
    f.add(playerLabel);
    
    npcLabel.setBounds(500,100, 288, 288);
    f.add(npcLabel);

    //print out inventory for debug
    for (int i=0; i<Main.getInventory().size(); i++){
      System.out.println (Main.getInventory().get(i).getName());
    }
    }//end of constructor 
    
    class BackListener implements ActionListener{
      /* actionPerformed method
       * Runs if the next out button is pressed
       * @param event - the action that is performed
       */
      public void actionPerformed (ActionEvent event)
      {
        //dispose of the frame
        f.dispose();
      }
    }
    class NextListener implements ActionListener{
      /* actionPerformed method
       * Runs if the next out button is pressed
       * @param event - the action that is performed
       */
      public void actionPerformed (ActionEvent event)
      {
        //for text files
        if (!fileName.equals("")){
          String temp = "";
          try{
            //set the next lines
            temp = fileInput.nextLine();
            nameLabel.setText(temp.substring(0, temp.indexOf(" ")));
            textLabel.setText(temp.substring(temp.indexOf(" ")+1));
          }
          catch(Exception E){
            //when there aren't anymore lines, get rid of this
            f.dispose();
            if (fileName.equals("end.txt")){
              System.exit(0); //ends the program
            }
          }
        }
        //for arrays 
        else{
          backButton.setVisible(true);
          //try{
          if (turn%2==0){
            nameLabel.setText("Tako");
            if (puzzles.size()>0){
              textLabel.setText(puzzles.get(0).getQ());
            }
            else{
              textLabel.setText("Wow! You solved all the puzzles! Congrats!");
            }
          }
          else{
            if (textLabel.getText().equals("Wow! You solved all the puzzles! Congrats!")){
              invFrame.setVisible(false);
              invFrame.dispose();
              f.dispose();
              new VisualNovel("end.txt");
            }
            else{
              
              nameLabel.setText("Player");
              ball2.inventoryPopUp(invFrame);
              boolean answer=false;//if the answer if valid or not
              boolean correct=false;
              int tempInt=-1;
              boolean noItems=false;

              boolean endLoop = false;
              if (Main.getInventory().get(0).getFound()==false && Main.getInventory().get(1).getFound() == false&&
              Main.getInventory().get(2).getFound()==false){ //if size is zero
                answer=true;
                noItems=true;//no items in inventory
                nameLabel.setText("Tako");
                textLabel.setText("You don't have any items to solve the riddle with...");
              }
              else{
              while (answer==false && endLoop == false){
                System.out.println ("Inventory size: " + Main.getInventory().size());
                //create a pop up asking for answer
                //JFrame frame = new JFrame();
                String temp = JOptionPane.showInputDialog("Please enter the item number from the inventory:");
//                textLabel.setText(temp);
                //if the user wants to exit
                if (temp == null){
                  endLoop = true;
                }
                try{
                  tempInt=Integer.parseInt(temp);
                }
                catch (Exception e){
                 //answer is false
                  System.out.println ("Not a number:(");
                  endLoop = true;
                }
                System.out.println(tempInt);
                if (tempInt>0 && tempInt<=Main.getInventory().size()){
                  answer=true; //valid answer
                  System.out.println(answer);
                }
                else{
                  endLoop = true;
                }

                    
              }
                //check if answer is valid
              try{ correct = Main.solveRiddle(puzzles.get(0), Main.getInventory().get(tempInt-1));
              }catch (NullPointerException e){}
              
              System.out.println ("No items: " + noItems);
              nameLabel.setText("Tako");
              if (correct==true){
                textLabel.setText("I can't believe you got that right!");
              }
              else{
                textLabel.setText("You're terrible at this...");
              }
              }
              System.out.println ("Inventory");
              //print out inventory for debug
              for (int i=0; i<Main.getInventory().size(); i++){
      System.out.println (Main.getInventory().get(i).getName());
    }
              invFrame.dispose();
            }
          }
          turn++;
        }
      }//end of action listening 
      }
 
}//end of class