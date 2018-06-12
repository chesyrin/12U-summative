/*
 * Main gui 
 * change boundaries
 */
import java.io.*;
import java.util.Scanner;
import javax.swing.*;  
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class ball2 {
  
  private SimpleLinkedList<Object> interactObj = initial();
  JFrame frame = new JFrame("Key Listener");
  JPanel p = new JPanel();
  final JLabel frontAni[] = new JLabel[3];
  final JLabel backAni[] = new JLabel[3];
  final JLabel rightAni[] = new JLabel[3];
  final JLabel leftAni[] = new JLabel[3];
  
  int x = 8, y = 100, velx =0, vely =0, count = 0;
  private SimpleLinkedList<Item> itemList;
  public ball2(SimpleLinkedList<Item> itemsList){
    this.itemList = itemsList;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(615,425);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    
    //set animation sprites
    //front   
    frontAni[0] = new JLabel(new ImageIcon("fside_tanuki(2).gif"));
    frontAni[0].setBounds(8,100,38,56);//initial sprite
    frontAni[1] = new JLabel(new ImageIcon("fside_tanuki(1).gif"));
    frontAni[1].setBounds(0,0,38,56);
    frontAni[2] = new JLabel(new ImageIcon("fside_tanuki(3).gif"));
    frontAni[2].setBounds(0,0,38,56);
    
    p.add(frontAni[2]);
    p.add(frontAni[1]);
    p.add(frontAni[0]);
    //back
    backAni[0] = new JLabel(new ImageIcon("bside_tanuki(2).gif"));
    backAni[0].setBounds(0,0,38,56);
    backAni[1] = new JLabel(new ImageIcon("bside_tanuki(1).gif"));
    backAni[1].setBounds(0,0,38,56);
    backAni[2] = new JLabel(new ImageIcon("bside_tanuki(3).gif"));
    backAni[2].setBounds(0,0,38,56);
    
    p.add(backAni[2]);
    p.add(backAni[1]);
    p.add(backAni[0]);
    //left
    leftAni[0] = new JLabel(new ImageIcon("lside_tanuki(2).gif"));
    leftAni[0].setBounds(0,0,38,56);
    leftAni[1] = new JLabel(new ImageIcon("lside_tanuki(1).gif"));
    leftAni[1].setBounds(0,0,38,56);
    leftAni[2] = new JLabel(new ImageIcon("lside_tanuki(3).gif"));
    leftAni[2].setBounds(0,0,38,56);
    
    p.add(leftAni[2]);
    p.add(leftAni[1]);
    p.add(leftAni[0]);
    //right
    rightAni[0] = new JLabel(new ImageIcon("rside_tanuki(1).gif"));
    rightAni[0].setBounds(0,0,38,56);
    rightAni[1] = new JLabel(new ImageIcon("rside_tanuki(2).gif"));
    rightAni[1].setBounds(0,0,38,56);
    rightAni[2] = new JLabel(new ImageIcon("rside_tanuki(3).gif"));
    rightAni[2].setBounds(0,0,38,56);
    
    p.add(rightAni[2]);
    p.add(rightAni[1]);
    p.add(rightAni[0]);
    reset();
    frontAni[0].setVisible(true);//this sprite is initially visible
    
    
    //set keyboard input
    KeyListener listener = new KeyListener() {
      
      public void keyPressed(KeyEvent event) {
        //set velocity x & velocity y
        keyboardLocation(event.getKeyCode());

//        System.out.println(x + " " + y);
        //sets general bounds
        if(x < 8){//left boundary
          x = 8;  
        }
        
        if(x > 550){//right boundary
          x = 550;  
        }
        
        if(y < 80){//upper bounds
          y = 80;  
        }
        
        if(y > 320){//lower bounds
          y = 320;  
        }
        boolean ifMoved = false;
        for (int i = 0; i<interactObj.size(); i ++){
          Object temp = interactObj.get(i);
          //temp boundary test
          //currently left, trying to move right
          //if the character sprite is inside the object image
          if (x>temp.getX() && x<temp.getSx() && //x-bounds
              y > temp.getY() && y < + temp.getSy()){//y-bounds
            ifMoved = true;
            //teleport the player sprite to the appropriate side of the object image
            //if it's on the left side of the image
            if (x - 3 < temp.getX()){
              x = temp.getX();
            }
            //if it's on the right side of the image
            else if (x + 3 > temp.getSx()) {
              x = temp.getSx();
            }
            //if it's on the top of the image
            else if (y - 3 < temp.getY()){
              y = temp.getY();
            }
            //else on bottom of image
            else {
              y = temp.getSy();
            }
          }
        }
        //set x and  y
        if (ifMoved == false) {
          x += velx;
          y += vely;
        }
        
        //set animation
        if (vely == 2){//down
          if (count%4 == 0 || count%4 ==2){
            reset();
            frontAni[0].setVisible(true);
            frontAni[0].setLocation(x,y);}
          
          else if (count%4 == 1){
            reset();
            frontAni[1].setVisible(true);
            frontAni[1].setLocation(x,y);}
          else{
            reset();
            frontAni[2].setVisible(true);
            frontAni[2].setLocation(x,y);}
        }
        else if (vely == -2){//up
          if (count%4 == 0 || count%4 ==2){
            reset();
            backAni[0].setVisible(true);
            backAni[0].setLocation(x,y);}
          
          else if (count%4 == 1){
            reset();
            backAni[1].setVisible(true);
            backAni[1].setLocation(x,y);}
          else{
            reset();
            backAni[2].setVisible(true);
            backAni[2].setLocation(x,y);}
        }
        else if (velx == 2){//right
          if (count%4 == 0 || count%4 ==2){
            reset();
            rightAni[1].setVisible(true);
            rightAni[1].setLocation(x,y);}
          
          else if (count%4 == 1){
            reset();
            rightAni[2].setVisible(true);
            rightAni[2].setLocation(x,y);}
          else{
            reset();
            rightAni[0].setVisible(true);
            rightAni[0].setLocation(x,y);}
          
        }
        else if(velx == -2) {//left
          if (count%4 == 0 || count%4 ==2){
            reset();
            leftAni[1].setVisible(true);
            leftAni[1].setLocation(x,y);}
          
          else if (count%4 == 1){
            reset();
            leftAni[2].setVisible(true);
            leftAni[2].setLocation(x,y);}
          else{
            reset();
            leftAni[0].setVisible(true);
            leftAni[0].setLocation(x,y);}
        }
        count++;
        //pause program for 15 milliseconds
        try {
          TimeUnit.MILLISECONDS.sleep(15);}
        catch(InterruptedException ex){
          Thread.currentThread().interrupt();
        }
        
      }
      
      public void keyReleased(KeyEvent event) {
        //reset velx and vely
        velx=0;
        vely=0;
      }
      
      public void keyTyped(KeyEvent event) {
      }
      
      private void keyboardLocation(int keybrd) {
        if (keybrd == KeyEvent.VK_DOWN){
          vely = 2;
          velx = 0;
        }
        if (keybrd == KeyEvent.VK_UP){
          vely = -2;
          velx = 0;
        }
        if (keybrd == KeyEvent.VK_LEFT){
          vely = 0;
          velx = -2;
        }
        if (keybrd == KeyEvent.VK_RIGHT){
          vely = 0;
          velx = 2;
          
        }
        if (keybrd == KeyEvent.VK_X){
          new ItemPopUp();
          
        }
      }
      
      
    };//end of key listener
    p.setLayout(null);
    //add the keyboard listener
    frame.addKeyListener(listener);
    
    //add bg image
    ImageIcon bgImage = new ImageIcon("IMAGE1.jpg");
    JLabel bg = new JLabel(bgImage);
    bg.setBounds(0,0,600,386);
    p.add(bg);
    
    //add the panel to the frame
    frame.add(p);
    
    frame.setVisible(true);
  }
//sets all the sprites visiblity to false
  public void reset(){
    for (int i = 0; i<3; i++){
      frontAni[i].setVisible(false);
      backAni[i].setVisible(false);
      leftAni[i].setVisible(false);
      rightAni[i].setVisible(false);
    }
  }
  //initializes the objects
  public SimpleLinkedList<Object> initial(){
    SimpleLinkedList<Object> a = new SimpleLinkedList<Object>();
    try {
      Scanner fileInput = new Scanner (new File ("objectList.txt"));
      while (fileInput.hasNextLine()){
        Scanner stringInput = new Scanner(fileInput.nextLine());
        Object temp = new Object(stringInput.next(), stringInput.next(), 
                                 stringInput.next(), stringInput.next(),
                                 stringInput.next());
        a.add(temp);
      }//end of while
      fileInput.close();}
    catch(Exception e){System.out.println("error");}
    return a;
  }
}
