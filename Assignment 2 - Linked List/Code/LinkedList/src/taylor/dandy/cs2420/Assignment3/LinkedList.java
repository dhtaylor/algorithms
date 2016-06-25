package taylor.dandy.cs2420.Assignment3;

public class LinkedList <T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    
    /**
     * The size of the list
     * 
     * @return
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Method to insert a new element directly after the given element
     *
     * @param key
     * @param data
     * @throws IndexOutOfBoundsException
     */
    public void insertAfter(T key, T data) throws IndexOutOfBoundsException
    {
        Node<T> insertAfterNode = getNode(key);
        Node<T> newNode = new Node(data, null);

        if (insertAfterNode == null)
        {
            throw new IndexOutOfBoundsException();
        }
        
        newNode.next = insertAfterNode.next;
        insertAfterNode.next = newNode;
        size++;
        
    }
    
    /**
     * Remove an element from the list
     * 
     * @param key
     * @throws IndexOutOfBoundsException
     */
    public void remove(T key) throws IndexOutOfBoundsException
    {
        Node<T> previousNode = head;
        Node<T> currentNode = head;
        
        while (currentNode != null)
        {
            if (currentNode.data.equals(key))
            {
                if (currentNode == head)
                {
                    head = currentNode.next;
                }
                else
                {
                    previousNode.next = currentNode.next;
                    if (previousNode.next == null)
                    {
                        tail = previousNode;
                    }
                
                }

                currentNode.next = null;
                size--;
                return;
            }
            
            previousNode = currentNode;
            currentNode = currentNode.next;
            
        }
        
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Test to see if the list is empty
     * 
     * @return
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Append an element to the end of the list
     * 
     * @param item
     */
    public void append(T item)
    {
        Node<T> newNode = new Node<>(item, null);
        
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }
        
        tail = newNode;
        size++;
    }
    
    /**
     * Clear the list
     * 
     */
    public void clear()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Convert the list to a string for printing
     * 
     * @return
     */
    @Override
    public String toString()
    {
        int index;
        Node<T> currentNode;
        String outString;
        
        index = 0;
        currentNode = head;
        outString = "[";
        
        while (index < size)
        {
            String delimiter = (index == 0) ? "" : ", ";
            outString = outString + delimiter + currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        
        outString = outString + "]";
        
        return outString;
    }
        
    private Node<T> getNode(T key)
    {

        Node<T> returnNode;

        returnNode = head;
        
        while (returnNode != null)
        {
            if (returnNode.data.equals(key))
            {
                return returnNode;
            }
            
            returnNode = returnNode.next;

        }

        return null;
    }
    
    private static class Node<T>
    {
        private T data;
        private Node<T> next;
        
        public Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
