package threads;

public class GreetingThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println("GreetingThread printing...");
    }

    // Test
    @Override
    public String toString()
    {
        return "This is the new Thread toString method!";
    }
}
