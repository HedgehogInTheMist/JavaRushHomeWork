package my_examples;

/**
 * Created by advirtys on 26.11.15.
 */
public class ClockManager
{


    public static void main(String[] args) throws InterruptedException
    {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        System.out.println("Останавливаю поток!");
        clock.cancel();
    }
}
