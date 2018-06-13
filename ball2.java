/*
 * Main gui 
 */
import javax.swing.*;  
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ball2 implements MouseListener{
  Object tako = new Object();
  JFrame frame = new JFrame("Key Listener");
  JPanel p = new JPanel();
  final JLabel frontAni[] = new JLabel[3];
  final JLabel backAni[] = new JLabel[3];
  final JLabel rightAni[] = new JLabel[3];
  final JLabel leftAni[] = new JLabel[3];
  
  int x = 8, y = 100, velx =0, vely =0, count = 0;
  public ball2(){
    frame.addMouseListener(this);
    
    
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
        
        if(y < 100){//upper bounds
          y = 100;  
        }
        
        if(y > 320){//lower bounds
          y = 320;  
        }
        //tako boundary test
        //currently left, trying to move right
        //if the character sprite is inside the object image
        if (x>tako.getX() && x<tako.getX() + 2*tako.getSx()  && //x-bounds
            y > tako.getY() && y < (tako.getY() + tako.getSy())){//y-bounds
          //teleport the player sprite to the appropriate side of the object image
          //if it's on the left side of the image
          if (x - 1 == tako.getX()){
            x = tako.getX();
          }
          //if it's on the right side of the image
          else if (x + 1 == tako.getX() + 2*tako.getSx()) {
            x = tako.getX() + 2*tako.getSx();
          }
          //if it's on the top of the image
          else if (y - 1 == tako.getY()){
            y = tako.getY();
          }
          //else on bottom of image
          else {
            y = tako.getY() + tako.getSy();
          }
        }
        //set x and  y
        else {
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
      
      //readItems();
      public void keyTyped(KeyEvent event) {
        System.out.println (event.getKeyChar());
        //for action buttons
        //x for interacting with objects
        if (event.getKeyChar()=='x'){
          boolean isItem = Main.checkItem(x,y);
          // if (isItem==true){
          System.out.println ("JJJJ");
          //3 possible item locations
          boolean alreadyInside = false;
          //if (x>10 && x<100 && y>10 && y<100){ //example coordinates, please put in the correct ones later
          //try to find the item in the inventory to prevent duplicates
          for (int i=0; i<Main.getInventory().size(); i++){
            if (Main.getInventory().get(i).getName().equals("Envelope")){
              System.out.println ("hi");
              alreadyInside=true;
            }
          }
          //}
          System.out.println (alreadyInside);
          if (alreadyInside==false){
            System.out.println (Main.getItems().get(0).getName());
            //add envelope into inventory
            Main.getInventory().add(Main.getItems().get(0));
          }
//            if (alreadyInside==false){
//              //add envelope into inventory
//              inventory.add(items.get(0));
//            }
          // }
//            else if (){
//              for (i=0; i<inventory.size(); i++){
//                if (Main.inventory.get(i).getName().equals("Fork")){
//                  alreadyInside=true;
//                }
//              }
//              
//              if (alreadyInside==false){
//                //add fork into inventory
//                Main.inventory.add(Main.items.(get(1)));
//              }
//            }
//            else if (){
//              for (i=0; i<inventory.size(); i++){
//                if (Main.inventory.get(i).getName().equals("Mirror")){
//                  alreadyInside=true;
//                }
//              }
          
//              if (alreadyInside==false){
//                //add envelope into inventory
//                Main.inventory.add(Main.items.get(2));
//              }
//        }
        }
        //press c for inventory
        else if (event.getKeyChar()=='c'){
          JFrame frame = new JFrame("Inventory");
          inventoryPopUp(frame);
        }
        //press z to talk to npc
        else if (event.getKeyChar()=='z'){
         // if (x>10 && x<100 && y>40 && y<300){ //if user is standing in front of NPC
            new VisualNovel (Main.getPuzzles(), Main.getItems());
          //}
        }
        
        //press v to open the door
        else if (event.getKeyChar()=='v'){
          Main.getInventory().clear();
          Main.getInventory().add(Main.getItems().get(3));
          System.out.println ("Item: " + Main.getInventory().get(0).getName());
          System.out.println (x+", "+y);
          if (x>476 && x<539 && y>90 && y<120 && Main.getInventory().size()!=0 && 
              Main.getInventory().get(0).getName().equals("Key")){ //use door's coordinates
            System.out.println ("yes");
            //triger the ending dialogue
            new VisualNovel ("end.txt");
            frame.dispose();
          }
        }
        System.out.println ("\nItem added into inventory!");
        for (int i=0; i<Main.getInventory().size(); i++){
          System.out.println (Main.getInventory().get(i).getName());
        }
      };
      
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
      }
      
    };//end of key listner
    p.setLayout(null);
    //add tako sprite test
    JLabel takoTemp = tako.getSprite();
    takoTemp.setBounds(tako.getX() + tako.getSx(), tako.getY() +  tako.getSy(), 
                       tako.getSx(), tako.getSy());//location (x,y), size(x,y)
    p.add(takoTemp);
    //add the keyboard listener
    frame.addKeyListener(listener);
    
    //add bg image
    ImageIcon bgImage = new ImageIcon("IMAGE.jpg");
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
  public static void inventoryPopUp(JFrame frame){
  //  JFrame frame = new JFrame("Inventory");
    JPanel panel = new JPanel();
    SimpleLinkedList <JLabel> itemName = new  SimpleLinkedList <JLabel>();
    SimpleLinkedList <JTextArea> itemDesc = new  SimpleLinkedList <JTextArea>();
    Font boldFont = new Font("Courier", Font.BOLD,12);
    
    for (int i=0; i<Main.getInventory().size(); i++){
      itemName.add(new JLabel(i+ ". " + Main.getInventory().get(i).getName()));
      itemName.get(i).setFont(boldFont);
      
      itemDesc.add(new JTextArea(Main.getInventory().get(i).getDesc()));
      itemDesc.get(i).setLineWrap(true); //so that the text doesn't go beyond the frame
      itemDesc.get(i).setWrapStyleWord(true);
      
      panel.add(itemName.get(i)); //add items to panel
      panel.add(itemDesc.get(i));
    }
    frame.add(panel);
    
    frame.setSize(400, 800);
    frame.setVisible(true);
  }
  
  
//  
      public void mousePressed(MouseEvent e) {
System.out.println ( e.getX());
System.out.println ( e.getY());
    }

    public void mouseReleased(MouseEvent e) {
       saySomething("Mouse released; # of clicks: "
                    + e.getClickCount(), e);
    }

    public void mouseEntered(MouseEvent e) {
       saySomething("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
       saySomething("Mouse exited", e);
    }
      public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        System.out.println(x+","+y);//these co-ords are relative to the component
      }
      
      void saySomething(String eventDescription, MouseEvent e) {
      }
      
      public static void main(String args[]) {
        //readItems();
    new ball2();
    
  }
  
}