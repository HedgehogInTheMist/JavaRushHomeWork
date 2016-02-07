package my_examples.wait_notify;

/**
 * Created by advirtys on 25.01.16.
 */
public class StendUp
{
    private boolean sit_stand = false;

    public void sit(){
        sit_stand = true;
    }

    public void stand(){
        sit_stand = false;
    }

    public boolean isSit_stand()
    {
        return sit_stand;
    }

    public static void main(String[] args)
    {
        StendUp ss = new StendUp();

        Thread t1 = new Thread(new Sit(ss));
        Thread t2 = new Thread(new Stand(ss));

        t1.start();
        t2.start();
    }
}
