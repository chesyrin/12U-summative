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

public class VisualNovel extends JFrame implements ActionListener{
  
  JFrame f = new JFrame();
  JButton nextButton = new JButton ("Next");
  JLabel textLabel = new JLabel("~Sample text 1~");
  JLabel nameLabel = new JLabel("Name");
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
  ImageIcon bg = new ImageIcon ("bg.png");
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
    
    File file = new File ("text.txt");
    
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
    nextButton.addActionListener(this);
    
    dialoguePanel.setBounds(30, 365, 725, 200); //set size
    dialoguePanel.setBackground(Color.BLACK);
   // dialoguePanel.setBackground(new Color(0,0,0,150)); //make it translucent
    dialoguePanel.add(textLabel);
    dialoguePanel.add(nextButton);
    
    f.add(dialoguePanel);
    
    nameLabel.setFont(dosis);
    nameLabel.setForeground(Color.WHITE);
    
    namePanel.setBounds(30,300,100,50); //set size
    namePanel.setBackground(new Color(0,0,0,150)); //make it translucent
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
    setContentPane(bgLabel);
    //imageLabel.setBounds(-3,0,800,600);
    //f.add(imageLabel);
    
    f.add(bgLabel);
    //create a new font(I included it in the folder so go install it (if possible)for the full experience!!!!)
    Font dosis = new Font ("Dosis Light", Font.PLAIN, 21);
    
    //adjusting the font and colour of the text label
    textLabel.setFont(dosis);
    textLabel.setBounds(30, 270, 700, 400);
    textLabel.setForeground (Color.BLACK);
    f.add(textLabel);
    
    nameLabel.setFont(dosis);
    nameLabel.setBounds(20,214,700,400);
    nameLabel.setForeground(Color.BLACK);
    f.add(nameLabel);
    
    //add skipButton and nextButton
    
    nextButton.setBounds(670,520,70,30);
    dialoguePanel.add(nextButton);
   // f.add(nextButton);
    nextButton.addActionListener(this);
    
  //  try {fileInput = new Scanner(file);}
   // catch (FileNotFoundException e ){System.out.println("File not found");}
  }//end of constructor 
    
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
      }
    }
    //for arrays 
    else{
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
            nameLabel.setText("Player");
  
            //create a pop up asking for answer
            JFrame frame = new JFrame();
            String temp = JOptionPane.showInputDialog("Please enter your answer:");
            textLabel.setText(temp);
            
            //check if answer is valid
            System.out.println (puzzles.get(0).getQ()+"\n");
            
            //debugging, check if files have been read in correctly
            for (int i=0; i<items.size(); i++){
              System.out.println (items.get(i).getName());
            }
            
            //System.out.println (items.get(Integer.parseInt(temp)).getName() + "\n");
            
            boolean correct = Main.solveRiddle(puzzles.get(0), items.get(Integer.parseInt(temp)));
            nameLabel.setText("NPC");
            if (correct==true){
              textLabel.setText("I can't belive you got that right!");
            }
            else{
              textLabel.setText("You're terrible at this...");
            }
          }
        }
        turn++;
    }
    }//end of action listening 
  
  public static void main(String[] args) 
  { 
    new VisualNovel("text.txt");
  }//end of main
  
}//end of class