/*
 * Main gui 
 * issue: txt file (description only has 1 word)
 */
import javax.swing.*;  
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class ball2 {
  
  private SimpleLinkedList<Object> interactObj = Main.readObjects();
  private static SimpleLinkedList<Item> itemList = Main.getItems();
  JFrame frame = new JFrame("");
  JFrame popupFrame = new JFrame();
  JPanel p = new JPanel();
  final JLabel frontAni[] = new JLabel[3];
  final JLabel backAni[] = new JLabel[3];
  final JLabel rightAni[] = new JLabel[3];
  final JLabel leftAni[] = new JLabel[3];
  
  int x = 8, y = 100, velx =0, vely =0, count = 0;
  public ball2(){
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
        if (keybrd == KeyEvent.VK_C){
          new VisualNovel (Main.getPuzzles(), Main.getItems());
        }
        
        if (keybrd == KeyEvent.VK_Z){
          //close the inventory window
           popupFrame.setVisible(false);
          //check which sprite is visible
          //check if it's facing anything in each of the if statments
          Object temp = null;
          for (int i = 0; i<3; i++){
            if (frontAni[i].isVisible()){
              //if its facing the front
              for (int j = 0; j< interactObj.size(); j++){
                Object indexObj = interactObj.get(j);
                if (x > indexObj.getX() && x < indexObj.getSx() &&  y < indexObj.getSy() && (y + 5) > indexObj.getY()){
                  temp = indexObj;
                }
              }
            }
            else if (backAni[i].isVisible()){
              //if it's showing its back
              for (int j = 0; j< interactObj.size(); j++){
                Object indexObj = interactObj.get(j);
                if (x > indexObj.getX() && x < indexObj.getSx() &&  (y - 5) < indexObj.getSy() && y > indexObj.getY()){
                  temp = indexObj;
                }
              }
            }
            else if (rightAni[i].isVisible()){
              //if it's looking right
              for (int j = 0; j< interactObj.size(); j++){
                Object indexObj = interactObj.get(j);
                if ((x+5) > indexObj.getX() && x < indexObj.getSx() &&  y < indexObj.getSy() && y > indexObj.getY()){
                  temp = indexObj;
                }
              }
            }
            else if (leftAni[i].isVisible()){
              //if it's looking left
              for (int j = 0; j< interactObj.size(); j++){
                Object indexObj = interactObj.get(j);
                if (x > indexObj.getX() && (x-5) < indexObj.getSx() &&  y < indexObj.getSy() && y > indexObj.getY()){
                  temp = indexObj;
                }
              }
            }
          }
          //if an item is detected in front of the player, check if it's a special item
          if (temp != null){
            if (temp.getNum()!= -1){
              //change the item double linked list to it being found
              itemList.get(temp.getNum()).setFound();
            }
            //display the description
            JOptionPane.showMessageDialog(null, temp.getDesc());
          }
        }
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
          popupFrame.setVisible(false);
          inventoryPopUp(popupFrame);
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
  //creates the inventory list
    public static void inventoryPopUp(JFrame frame){
      frame.setVisible(true);
      frame.setSize(210,600);
    JPanel panel = new JPanel();
    SimpleLinkedList <JLabel> itemName = new  SimpleLinkedList <JLabel>();
    SimpleLinkedList <JTextArea> itemDesc = new  SimpleLinkedList <JTextArea>();
    Font boldFont = new Font("Courier", Font.BOLD,12);
    int count = 0;
    for (int i=0; i<Main.getInventory().size(); i++){
      Item tempItem = Main.getInventory().get(i);
      //if the user already found the item, add it into the list
      if (tempItem.getFound() == true){
      itemName.add(new JLabel((4-tempItem.getNum()) + ". " + tempItem.getName()));
      itemName.get(count).setFont(boldFont);
      
      itemDesc.add(new JTextArea(tempItem.getDesc()));
      itemDesc.get(count).setLineWrap(true); //so that the text doesn't go beyond the frame
      itemDesc.get(count).setWrapStyleWord(true);
      
      panel.add(itemName.get(count)); //add items to panel
      panel.add(itemDesc.get(count));
      count++;
      }
    }
    frame.add(panel);
    }
}