package my_examples;

/**
 * Created by advirtys on 26.11.15.
 */
public class Clock implements Runnable
{
    private volatile boolean isCancel = false;

    public void cancel(){
        this.isCancel = true;
    }

    @Override
    public void run()
    {
        while (!isCancel){
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Tik");


        }
    }
}
