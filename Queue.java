/** An interface for the Queue ADT.  Adapted from java.util.Queue.

    @author Jed Yang, 2017-01-28

    @param <E> The type of data that this queue stores.
*/
public interface Queue<E>
{
   /** Inserts the specified element into this queue.
       @throws NullPointerException if element is null
   */
   public void add(E e);

   /** Retrieves, but does not remove, the head of this queue.
       @return the head of this queue
       @throws NoSuchElementException if this queue is empty
   */
   public E element();

   /** Retrieves and removes the head of this queue.
       @return the head of this queue
       @throws NoSuchElementException if this queue is empty
   */
   public E remove();

   /** Returns true if this collection contains no elements.
       @return true if this collection contains no elements
   */
   public boolean isEmpty();

   /** Prints the contents of the queue to the screen in some clean,
       readable way.
   */
   public void display();
}
