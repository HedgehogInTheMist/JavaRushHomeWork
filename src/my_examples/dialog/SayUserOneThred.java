package my_examples.dialog;

/**
 * Created by advirtys on 25.01.16.
 */
public class SayUserOneThred implements Runnable
{
    private volatile Say say;
    private String[] str = {"привет)))",
            "что бы у тебя такого интересного спросить что бы ты интересно рассказала???",
            "да можешь просто Максом называть...ок?",
            "вот и договорились...чем вообще занимаешься???",
            "а я учусь на программиста в СГА...и работаю))) но это не интересно,\n" +
                    "так что давай поговорим о том чем ты увлекаешься в свободное время?!!!" +
                    "\nпоешь танцуешь гуляешь читаешь вяжешь встречаешься с парнем???"
    };

    public SayUserOneThred(Say say)
    {
        this.say = say;
    }

    @Override
    public void run()
    {
        try
        {

            for (int i = 0; i < str.length; i++)
            {

                synchronized (say)
                {
                    while (say.isSay())
                    {
                        say.wait();
                    }
                    System.out.println(str[i]);
                    Thread.sleep(2000);
                    say.sayUserTwo();
                    say.notify();
                }
            }

        } catch (InterruptedException e){

        }
    }
}
