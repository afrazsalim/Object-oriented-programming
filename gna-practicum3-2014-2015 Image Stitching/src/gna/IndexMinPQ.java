package gna;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author Algorithm taken from the book (Algorithms 4th edition by Robert Sedgewick and Kevin Wayne).
 */


public class IndexMinPQ<Key extends Comparable<Key>> {
    private int numberOfMaxElements;        
    private int size;           
    private int[] array;        
    private int[] contain;        
    private Key[] keys;   

    
   
    
    
    public IndexMinPQ(int NMAX) {
        if (NMAX < 0) throw new IllegalArgumentException();
        this.numberOfMaxElements = NMAX;
        keys = (Key[]) new Comparable[NMAX + 1];    
        array   = new int[NMAX + 1];
        contain   = new int[NMAX + 1];                   
        for (int i = 0; i <= NMAX; i++) contain[i] = -1;
    }

  
    public boolean isEmpty() {
        return size == 0;
    }

  
    public boolean contains(int i) {
        return contain[i] != -1;
    }

   
    public int size() {
        return size;
    }

   
    public void insert(int i, Key key) {
        size++;
        contain[i] = size;
        array[size] = i;
        keys[i] = key;
        swim(size);
    }


   

    public int delMin() { 
        int min = array[1];        
        exchange(1, size--); 
        sink(1);
        contain[min] = -1;            
        keys[array[size+1]] = null;    
        array[size+1] = -1;           
        return min; 
    }
   
   
    public void decreaseKey(int i, Key key) {
        keys[i] = key;
        swim(contain[i]);
    }


   
    private boolean isGreater(int i, int j) {
        return keys[array[i]].compareTo(keys[array[j]]) > 0;
    }

    private void exchange(int i, int j) {
        int swap = array[i]; array[i] = array[j]; array[j] = swap;
        contain[array[i]] = i; contain[array[j]] = j;
    }


    private void swim(int k)  {
        while (k > 1 && isGreater(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && isGreater(j, j+1)) j++;
            if (!isGreater(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

}
