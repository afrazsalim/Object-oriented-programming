package gna;

import java.util.Iterator;
import java.util.NoSuchElementException;

import libpract.Position;
import libpract.Stitch;
/**
 * @author Algorithm taken from the book (Algorithms 4th edition)
 */
public class Bag<Item> implements Iterable<Item> {
    private int N;               
    private Node<Item> first;    

    
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

  
    public int size() {
        return N;
    }

  
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


  
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { 
        	return current != null;                    
        	}

        public void remove()      {
        	throw new UnsupportedOperationException(); 
        	}
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
}


















