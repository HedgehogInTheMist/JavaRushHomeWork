package my_examples.wait_notify;

/**
 * Created by advirtys on 25.01.16.
 */
public class Stand implements Runnable
{

    private  StendUp ss;

    public Stand(StendUp ss)
    {
        this.ss = ss;
    }
    @Override
    public void run()
    {
        int i = 0;
            try
                {
                    Thread.sleep(1000);
                        while (i < 5)
                            {
                                synchronized (ss)
                                {

                                    while (ss.isSit_stand())
                                        {
                                            ss.wait();
                                        }

                                    System.out.println("Stand");
                                        ss.notify();
                                            ss.sit();
                                }

                                i++;
                            }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

    }
}
