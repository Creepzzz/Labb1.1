import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> {

    static public int numberOfNodes;
    public Node head;
    public Node tail;

    public class Node {
        private Item item;
        private Node next;
    }

    public CircularLinkedList() {
        head = new Node();
        tail = new Node();
    }

    public boolean isEmpty() {
        return numberOfNodes == 0;
    }

    public Iterator<Item> itemIterator(){
        return new CircularLinkedListIterator(head, tail);
    }

    private class CircularLinkedListIterator implements Iterator<Item>{

        public Node current;
        public Node tail;
        public CircularLinkedListIterator(Node head, Node tail){
            current = head;
            this.tail = tail;
        }

        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public void addFirst(Item item) {
      Node n = new Node();
      if(isEmpty()){
          head = tail = n;
      }
      n.item = item;
      tail.next = n;
      n.next = head.next.next;
      head = n;
      numberOfNodes++;
      StdOut.println(item.toString());
      StdOut.println(listToString());
    }

    public void addLast(Item item) {
        Node n = new Node();
        if(isEmpty()){
            head = tail = n;
        }
        n.item = item;
        tail.next = n;
        n.next = head;
        tail = n;
        numberOfNodes++;
        StdOut.println(item.toString());
        StdOut.println(listToString());
    }

    public void removeFirst() {
        if(isEmpty()){
            StdOut.println("Empty list, no elements to delete");
            return;
        }

        StdOut.println("Hello");
        StdOut.println(head.item.toString());
    }

    public void removeLast() {
    }

    public String listToString(){
        CircularLinkedList.Node n = head;
        int i = 0;
        if(isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        while(i < numberOfNodes){
            sb.append("[");
            sb.append(n.item.toString());
            sb.append("],");
            n = n.next;
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main (String[] args){
        CircularLinkedList<Character> list = new CircularLinkedList<>();
        char c = 'a';
        list.addFirst(c);
        c = 'b';
        list.addFirst(c);
        //list.addLast(c);

    }

}
