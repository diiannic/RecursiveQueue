/** An interface for the Queue ADT.  Adapted from java.util.Queue.

    @author Jed Yang, 2017-01-28
    @author Cole DiIanni, 2018-05-07

    @param <E> The type of data that this queue stores.
*/
import java.util.NoSuchElementException;

public class RecursiveQueue<E> implements Queue<E>
{
   private E front;                   // not null if 1+ elements
   private RecursiveQueue<E> middle;  // not null if 3+ elements
   private E back; // not null if 2+ elements

   public RecursiveQueue()
   {
      front = null;
      middle = null;
      back = null;
   }
    
   /** Inserts the specified element into this queue.
       @throws NullPointerException if element is null
   */
   public void add(E e)
   {
      // Do not accept null values
      if (e == null)
         throw new NullPointerException("this stack does not allow null elements");

      if (front == null) // 0 elements
      {
          front = e;
          return;
      }
      if (back == null) // 1 element
      {
          back = e;
          return;
      }
      // if 2 elements, need to initialize middle queue
      if (middle == null)
      {
           middle = new RecursiveQueue<E>();
           middle.add(back);
           back = e;
           return;
      }
      else // if there is already a middle queue
      {
          middle.add(back);
          back = e;
          return;
      }
   }

   /** Retrieves, but does not remove, the head of this queue.
       @return the head of this queue
       @throws NoSuchElementException if this queue is empty
   */
   public E element()
   {
       if (front == null)
       {
           throw new NoSuchElementException("The queue is empty");
       }
       return front;
   }

   /** Retrieves and removes the head of this queue.
       @return the head of this queue
       @throws NoSuchElementException if this queue is empty
   */
   public E remove()
   {
      if (front == null) // 0 elements
      {
          throw new NoSuchElementException();
      }
      E toReturn = front; // save the first value
      if (middle == null && back == null) // 1 element
      {
         front = null;
      }
      else if (middle == null) // 2 elements
      {
          front = back;
          back = null;
      }
      else // 3+ elements
      {
         front = middle.remove();
         if (middle.isEmpty())
         middle = null; // de-allocate empty queue
      }
      return toReturn;
   }

   /** Returns true if this collection contains no elements.
       @return true if this collection contains no elements
   */
   public boolean isEmpty()
   {
       if (front == null && back == null)
       {
           return true;
       }
       return false;
   }

   /** Prints the contents of the queue to the screen in some clean,
       readable way.
   */
   public void display() // prints each item with an "enter" after it
   {
       if (middle != null)
       {
           System.out.print(front + "\n");
           middle.display();
           System.out.print(back + "\n");
       }
       else
       {
           if (back != null)
           {
               System.out.print(front + "\n" + back + "\n");
           }
           else
           {
               System.out.print(front + "\n");
           }
       }
   }
}
