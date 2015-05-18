package gna;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author algorithms taken from the book "Algorithms 4th edition".
 *
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
    private Item[] q;           
    private int N = 0;           
    private int first = 0;       
    private int last  = 0;       


  
	public Queue(int n) {
        q = (Item[]) new Object[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

   
    public int size() {
        return N;
    }

    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = N;
    }


    public void enqueue(Item item) {
        if (N == q.length) resize(2*q.length);   
        q[last++] = item;                        
        if (last == q.length) last = 0;          
        N++;
    }

  
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            
        N--;
        first++;
        if (first == q.length) first = 0;           
        if (N > 0 && N == q.length/4) resize(q.length/2); 
        return item;
    }

   


    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}
