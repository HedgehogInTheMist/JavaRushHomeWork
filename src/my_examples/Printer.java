package my_examples;

/**
 * Created by advirtys on 26.11.15.
 */
public class Printer implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("I'm printer!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        Printer printer = new Printer();
        Thread thread = new Thread(printer);
        thread.start();
        Thread.sleep(10000);
        thread.join();
        Printer printer2 = new Printer();
        Thread thread2 = new Thread(printer2);
        thread2.start();


    }
}
