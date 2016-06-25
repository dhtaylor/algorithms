
package taylor.dandy.cs2420.Assignment03;

import java.util.EmptyStackException;

/**
 *
 * @author dandy.taylor
 * @param <T>
 */
public class ArrayStack <T>
{
    private final int DEFAULT_CAPACITY = 8;

    private int initialCapacity;
    private int capacity;
    private int size;
    private T[] array;
    
    /**
     *
     */
    public ArrayStack()
    {
        this(-1);
    }

    /**
     *
     * @param numberOfElements
     */
    public ArrayStack(int numberOfElements)
    {
        capacity = (numberOfElements < 0) ? DEFAULT_CAPACITY : numberOfElements;
        initialCapacity = capacity;
        size = 0;

        array = (T[]) new Object[capacity];
        
    }
    
    /**
     *
     * @return
     */
    public int size()
    {
        return size;
    }
    
    /**
     *
     * @return
     */
    public int capacity()
    {
        return capacity;
    }
    
    /**
     *
     * @param element
     */
    public void push (T element)
    {
        array[size++] = element;

        if(size == capacity)
            expand();

    }
    
    /**
     *
     * @return
     * @throws EmptyStackException
     */
    public T pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        
        T element = array[--size];
        array[size] = null;
        
        if(size <= (capacity / 4) && capacity > initialCapacity)
            shrink();
        
        return element;
    }
    
    /**
     *
     */
    public void clear()
    {
        array = (T[]) new Object[initialCapacity];
        capacity = initialCapacity;
        size = 0;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        String outString = "[";
        String delimiter;
        
        int counter = 0;
        
        while (counter < size)
        {
            delimiter = (counter == 0) ? "" : ", ";
            outString += delimiter + array[counter];
            counter++;

        }
        
        outString += "]";
        
        return outString;
        
    }
    
    private void expand()
    {
        
        int expandedCapacity = capacity * 2;
        T[] expandedArray = (T[]) new Object[expandedCapacity];
        
        for (int i = 0; i < size; i++)
        {
            expandedArray[i] = array[i];
        }
        
        array = expandedArray;
        expandedArray = null;
        
        capacity = expandedCapacity;
    }
    
    private void shrink()
    {
        
        int collapsedCapacity = (size == 0) ? initialCapacity : capacity / 2;
        T[] collapsedArray = (T[]) new Object[collapsedCapacity];
        
        for (int i = 0; i < size; i++)
        {
            collapsedArray[i] = array[i];
        }
        
        array = collapsedArray;
        collapsedArray = null;
        
        capacity = collapsedCapacity;
    }

}
