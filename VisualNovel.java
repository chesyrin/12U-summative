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
  
  JFrame f = new JFrame();
  JButton nextButton = new JButton ("Next");
  JButton backButton = new JButton("WAIT GO BACK I'M NOT READY");
  JLabel textLabel = new JLabel("Hi!");
  JLabel nameLabel = new JLabel("NPC");
  ImageIcon image = new ImageIcon("dialogue1.png");
  JLabel imageLabel = new JLabel(image);
  Scanner fileInput;
  String fileName="";
  File file;
  SimpleLinkedList<Puzzle> puzzles;
  SimpleLinkedList<Item> items;
  int turn=0;
  JPanel dialoguePanel = new JPanel();
  JPanel namePanel = new JPanel();
  
  ImageIcon nonPlayer = new ImageIcon("npc.png");
  ImageIcon player = new ImageIcon("player.png");
  ImageIcon bg = new ImageIcon ("bg.jpg");
  JLabel npcLabel = new JLabel(nonPlayer);
  JLabel playerLabel = new JLabel (player);
  JLabel bgLabel = new JLabel (bg);
  
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
    
   // dialoguePanel.setLayout(null);
    
    //add the images (imageLabel on top of bg)
    bgLabel.setBounds(0,0,800,600);
    setContentPane(bgLabel);
    
    // imageLabel.setBounds(-3,0,800,600);
    // f.add(imageLabel);
    
    //create a new font(I included it in the folder so go install it (if possible)for the full experience!!!!)
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
   // dialoguePanel.setBackground(new Color(0,0,0,150)); //make it translucent
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
    //add skipButton and nextButton
    
    bgLabel.setBounds(0,0,800,600);
    f.add(bgLabel);
    
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
    //add the images (imageLabel on top of bg)
    bgLabel.setBounds(0,0,800,600);
    setContentPane(bgLabel);
    //f.add(imageLabel);
    
    f.add(bgLabel);
    //create a new font(I included it in the folder so go install it (if possible)for the full experience!!!!)
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
   // dialoguePanel.setBackground(new Color(0,0,0,150)); //make it translucent
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
    
    bgLabel.setBounds(0,0,800,600);
    f.add(bgLabel);
    //  try {fileInput = new Scanner(file);}
    // catch (FileNotFoundException e ){System.out.println("File not found");}
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
              System.exit(0); //stop all other processes (music)
            }
          }
        }
        //for arrays 
        else{
          backButton.setVisible(true);
          //try{
          if (turn%2==0){
            nameLabel.setText("NPC");
            if (puzzles.size()>0){
              textLabel.setText(puzzles.get(0).getQ());
            }
            else{
              textLabel.setText("Wow! You solved all the puzzles!");
            }
          }
          else{
            if (textLabel.getText().equals("Wow! You solved all the puzzles!")){
              f.dispose();
            }
            else{
              JFrame f = new JFrame("Inventory");
              nameLabel.setText("Player");
              ball2.inventoryPopUp(f);
              boolean answer=false;//if the answer if valid or not
              int tempInt=-1;
              
              while (answer==false){
                //create a pop up asking for answer
                JFrame frame = new JFrame();
                String temp = JOptionPane.showInputDialog("Please enter your answer:");
                textLabel.setText(temp);
                //attempt to convert to integer
                if (checkInt(temp)==true){
                  tempInt=Integer.parseInt(temp);
                }
                if (tempInt>-1 && tempInt<Main.getInventory().size()){
                  answer=true; //valid answer
                }
              }
              
              //boolean correct = Main.solveRiddle(puzzles.get(0), items.get(Integer.parseInt(temp)));
              boolean correct = Main.solveRiddle(puzzles.get(0), Main.getInventory().get(tempInt));
              nameLabel.setText("NPC");
              if (correct==true){
                textLabel.setText("I can't belive you got that right!");
              }
              else{
                textLabel.setText("You're terrible at this...");
              }
              f.dispose(); //dispose of the frame
            }
          }
          turn++;
        }
      }//end of action listening 
      }
  
    public static boolean checkInt(String str){
      if (str.length()==0){
        return false; //nothing in the string
      }
      for (int i=0; i<str.length(); i++){
        char temp = str.charAt(i);
        if (Character.isDigit(temp)==false){
          return false;
        }
      }
      return true;
    }
    
  public static void main(String[] args) 
  { 
    new VisualNovel("text.txt");
  }//end of main
  
}//end of class