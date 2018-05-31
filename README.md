# 12U-summative
title: undecided

Basic Premise:
- Player is trapped in a locked room, along with an NPC (non player character)
- In order to get out of the room, the player must explore the room and find the required
items to solve the NPC’s riddles
- Once the riddles are all solved, the player obtains a key which they can use to unlock the
room

Controls:
- Player can control their movement using the WASD keys
- Player can trigger/continue dialogue with the NPC using the Z key
- Player can pick up items using the X key
- Player can view their inventory using the C key
- Player can choose which item from their inventory using the 1,2,3,4 keys

Items:
- envelope, fork, mirror, key
- envelope, fork, mirror are the items you must give NPC to solve the riddles (the
answer to the riddle)
- you get a key to unlock the room and escape once you solve all the riddles





Misc. Classes

Item
- Items in the game
- Variables
- String name, description - the item’s name and description
- boolean isFound - if user found the item or not
- isFound means that the item is in the user’s “inventory” so they can use it
to unlock
- int locationX, locationY - location of the item
- Program can refer to these variables when checking if user is in the area
with the item (so they can pick it up)
- int number - the number in the inventory associated with the item
- Either 1,2,3, or 4
- Methods
- setFound(), getFound(), setLocation(), getX(), getY()

Puzzle
- Must solve puzzles in order to get to the key
- Variables:
- String question - stores the question
- int answer - the inventory number that stores the item (the correct answer)
- boolean isCorrect - if the question has been solved
- Methods:
- getQuestion(), getAnswer(), setCorrect(), checkCorrect()

Character (abstract)
- Variables:
- Name, image
- Methods:
- talk()
- public void talk(){
- Read in text file & add scanner
- While (there’s still text)
- Set character label to name of current person speaking
- Set text label to the text in which they’re saying
- Wait for a button on keyboard to be pressed

Player (extends Character)
- Variables:
- String [] dialogue - stores the player’s dialogue
- Name - name of player
- Image - the image that represents the player
- int xPosition, yPosition - stores the player’s position on the map
- talk() allows the player to talk to the NPC

NonPlayer (extends Character)
- Variables:
- String [] dialogue - stores the NPC’s dialogue
- Name - name of NPC
- Image - the image that represents the player
- talk() uses the NPC’s pre-set dialogue text

Main
- Read puzzles etc. in by a text file
- Methods:
- public void readIn(String name){
while (there are still more lines left in the file){
puzzles.add(the riddle question)
}
}

Linked List
- Use linked list we coded in class
- Uses of linked list in program:
- 1) list of items
- 2) list of player’s inventory
- 3) list of puzzles

GUI
- Classes:
- Menu - the menu screen
- End screen - the end screen
- Gameplay - the actual gameplay
- Use actionListeners to use the keyboard in order to perform actions
- Methods:
- pickUp(), choose(), moveX(), moveY() etc.
- public void pickUp(int xPosition, yPosition){
int index=0;
boolean isFound;
while (item has not been found and the entire list isn’t looked at
yet)
if (xPosition==items.get(index).getX &&
yPosition==items.get(index).getY){
isFound=true;
inventory.add(items.get(index));
}
}
- public Item choose(int number){
return inventory.get(number);
}
- public void moveX(){
if (key being pressed down = d){
increase the x position of the player
}
else if (key being pressed down==a){
decrease the x position of the player
}
}
- public void moveY(){
if (key being pressed down = s){
increase the y position of the player
}
else if (key being pressed down==w){
decrease the y position of the player
}
}
