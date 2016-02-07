package my_examples.dialog;

/**
 * Created by advirtys on 25.01.16.
 */
public class Say
{
    private boolean say = false;

    public void sayUseOne(){
        say = false;
    }

    public void sayUserTwo(){
        say = true;
    }

    public boolean isSay()
    {
        return say;
    }


    public static void main(String[] args)
    {
        Say say = new Say();
        Thread t1 = new Thread(new SayUserOneThred(say));
        Thread t2 = new Thread(new SayUserTwoThred(say));

        t1.start();
        t2.start();
    }
}
