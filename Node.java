// ********************** A Node in the linked list *********
class Node<T> { //T is a placeholder, represents a generic type
  private T item; //item of type T
  private Node<T> next;

  public Node(T item) { //contructor for the head
  this.item=item;
  this.next=null;
}

public Node(T item, Node<T> next) { 
  this.item=item;
  this.next=next;
}

public Node<T> getNext(){ //gets value of next
  return this.next;
}

public void setNext(Node<T> next){ //sets the value of next
  this.next = next;
}

public T getItem(){ //gets the value of item
  return this.item;
}

}