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
  ImageIcon bgImage = new ImageIcon("IMAGE.jpg");
  ImageIcon image = new ImageIcon("dialogue1.png");
  JLabel bg = new JLabel(bgImage);
  JLabel imageLabel = new JLabel(image);
  Scanner fileInput;
  String fileName="";
  File file;
  SimpleLinkedList<Puzzle> puzzles;
  SimpleLinkedList<Item> items;
  int turn=0;
        
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
    
    //add the images (imageLabel on top of bg)
    setContentPane(bg);
    imageLabel.setBounds(-3,0,800,600);
    f.add(imageLabel);
    
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
    f.add(nextButton);
    nextButton.addActionListener(this);
    
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
    setContentPane(bg);
    imageLabel.setBounds(-3,0,800,600);
    f.add(imageLabel);
    
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
    f.add(nextButton);
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
          textLabel.setText(puzzles.get(0).getQ());
        }
        else{
          nameLabel.setText("Player");
          //create a pop up asking for answer
          JFrame frame = new JFrame();
          String temp = JOptionPane.showInputDialog("Please enter your answer:");
          textLabel.setText(temp);
          
          //check if answer is valid
          Main.solveRiddle(puzzles.get(0), items.get(Integer.parseInt(temp)));
        }
        turn++;
      //}
      //catch(Exception E){
        //when there aren't anymore lines, get rid of this
      //  f.dispose();
     // } 
    }
    }//end of action listening 
  
  public static void main(String[] args) 
  { 
    new VisualNovel("text.txt");
  }//end of main
  
}//end of class