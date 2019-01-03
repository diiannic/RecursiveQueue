import java.util.NoSuchElementException;

public class tester
{
    public static void main(String args[])
    {
        RecursiveQueue<String> queue = new RecursiveQueue();
        String a = "first";
        String b = "second";
        String c = "third";
        String d = "fourth";
        String e = "fifth";
        
        // test for removing from empty list
        if (queue.isEmpty() != true)
        {
            System.out.println("isEmpty() from empty list should be true");
        }
        queue.add(a); // test add for an empty list
        if (queue.isEmpty() != false)
        {
            System.out.println("isEmpty() from empty list should be false");
        }
        System.out.println(queue.remove());
        queue.add(a);
        System.out.println(queue.element());
        queue.remove();
        try
        {
            String fff = null;
            queue.add(fff);
        }
        catch (NullPointerException ddd)
        {
            System.err.println(ddd);
        }
        try
        {
            queue.element();
        }
        catch(NoSuchElementException ddd)
        {
            System.err.println(ddd);
        }
        try
        {
            queue.remove();
        }
        catch(NoSuchElementException ddd)
        {
            System.err.println(ddd);
        }
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);
        queue.display();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
