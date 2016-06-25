/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylor.dandy.cs2420.Assignment07;

import java.util.NoSuchElementException;

/**
 * @author dandy.taylor
 */
public class MinMaxPQ<Key extends Comparable<Key>>
{
    private int[] minHeap;
    private int[] maxHeap;
    private Key[] heap;
    private int size = 0;
    
    public MinMaxPQ(int initialSize)
    {
        
        heap = (Key[]) new Comparable[initialSize+1];
        minHeap = new int[initialSize+1];
        maxHeap = new int[initialSize+1];
        
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return this.size;
    }
    
    public int capacity()
    {
        return heap.length;
    }
    
    public void add(Key v) throws NullPointerException
    {
        if (v == null)
            throw new NullPointerException();
        
        size++;
        
        heap[size] = v;
        
        minHeap[size] = size;
        maxHeap[size] = size;

        swim(size);

    }
    
    public Key min() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException();
        
        return heap[minHeap[1]];
        
    }
    
    public Key removeMin() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException();
        
        Key min = min();
        int minIndex = minHeap[1];
        
        minHeap[1] = minHeap[size];
        minHeap[size] = 0;
        
        
        for (int i = size; i > 0; i--)
        {
            if (maxHeap[i] == minIndex)
            {
                maxHeap[i] = maxHeap[size];
                maxHeap[size] = 0;
                break;
            }
        }
        
        heap[minIndex] = null;
        
        size--;

        sink(1);

        return min;

    }
    
    public Key max() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException();
            
        return heap[maxHeap[1]];
        
    }
    
    public Key removeMax() throws NoSuchElementException
    {
        if (isEmpty())
            throw new NoSuchElementException();
        
        Key max = max();
        int maxIndex = maxHeap[1];
        
        maxHeap[1] = maxHeap[size];
        maxHeap[size] = 0;
        
        
        for (int i = size; i > 0; i--)
        {
            if (minHeap[i] == maxIndex)
            {
                minHeap[i] = minHeap[size];
                minHeap[size] = 0;
                break;
            }
        }
        
        heap[maxIndex] = null;
        
        size--;

        sink(1);
        
        return max;

    }

    private int swim(int k)
    {
        while(k > 1)
        {
            if (heap[minHeap[k]].compareTo(heap[minHeap[k/2]]) < 0)
            {
                int temp = minHeap[k];
                minHeap[k] = minHeap[k/2];
                minHeap[k/2] = temp;
            }
            
            if (heap[maxHeap[k]].compareTo(heap[maxHeap[k/2]]) > 0)
            {
                int temp = maxHeap[k];
                maxHeap[k] = maxHeap[k/2];
                maxHeap[k/2] = temp;
            }

            k = k/2;
            
        }

        return 1;

    }

    private void sink(int k)
    {
        int minIndex = k;
        int maxIndex = k;
        
        while (minIndex * 2 <= size)
        {
            int n = minIndex * 2;
            
            if (n < size && heap[minHeap[n]].compareTo(heap[minHeap[n+1]]) > 0)
                n++;
            
            if (heap[minHeap[minIndex]].compareTo(heap[minHeap[n]]) > 0)
            {
                int temp = minHeap[minIndex];
                minHeap[minIndex] = minHeap[n];
                minHeap[n] = temp;
                    
            }
            
            minIndex = n;
            
        }
        
        while (maxIndex*2 <= size)
        {
            int n = maxIndex * 2;
            
            if (n < size && heap[maxHeap[n]].compareTo(heap[maxHeap[n+1]]) < 0)
                n++;
        
            if (heap[maxHeap[maxIndex]].compareTo(heap[maxHeap[n]]) < 0)
            {
                int temp = maxHeap[maxIndex];
                maxHeap[maxIndex] = maxHeap[n];
                maxHeap[n] = temp;
                
            }
            
            maxIndex = n;
            
        }
        
    }

//    public void print()
//    {
//        System.out.println("heap:: " + Arrays.toString(heap));
//        System.out.println("minHeap:: " + Arrays.toString(minHeap));
//        System.out.println("maxHeap:: " + Arrays.toString(maxHeap));
//    }
    
}
