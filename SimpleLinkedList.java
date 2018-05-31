// ********************** Simple Linked List class in the linked list *********
class SimpleLinkedList<E> { 
  private Node<E> head;
  
  public void add(E item) { //add an item to the list
    Node<E> tempNode = head; //creates a tempNode so we can manipulate head
    
    //no items in the list
    if (head==null) { //creates a new head with value item, next node is null
      head=new Node<E>(item,null);
      return;
    }
    
    //1 or more items already in the list 
    while(tempNode.getNext()!=null) { //middle of the list
      tempNode = tempNode.getNext();
    }
    
    tempNode.setNext(new Node<E>(item,null)); //creates the last element of the list, next holds null
    return;
  }
  
  public E get(int index) { //gets the value of item at index
    Node<E> tempNode = head;
    for (int i=0; i<index; i++){
      tempNode=tempNode.getNext();   
    }
    return tempNode.getItem();
  }
  
  public int indexOf(E item) { //returns index of item
    Node<E> tempNode = head;
    int counter=0;
    while (tempNode!=null){
      //compare the values
      if (tempNode.getItem().equals(item)){
        return counter;
      }
      tempNode=tempNode.getNext(); 
      counter++;
    }
    return 0;
  }
  
  public E remove(int index) { //removes an element of the list
    int counter=0;
    if (index==0){ //if you need to remove the first item
      head=new Node<E>(head.getNext().getItem(), head.getNext().getNext());
    }
    Node <E> tempNode=head;
    while (tempNode!=null){
      //compare the values
      if ((counter+1)==index){ //if the next item is what you want to remove
        System.out.println ("Removing: " + tempNode.getNext().getItem());
        if (tempNode.getNext().getNext()!=null){
          tempNode.setNext(tempNode.getNext().getNext());
        }                                
        else{ //last item in the list
          tempNode.setNext(null);
        }
      }
      tempNode=tempNode.getNext(); 
      counter++;
    }
    return null;
  }
  
  public void clear() { //clear the list
    head=null;
  }
  
  public int size() { //returns size of list
    Node <E> tempNode=head;
    int counter=0;
    while (tempNode!=null){
      counter++;
      tempNode=tempNode.getNext();
    }
    return counter;
  }
}