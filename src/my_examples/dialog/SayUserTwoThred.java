package my_examples.dialog;

/**
 * Created by advirtys on 25.01.16.
 */
public class SayUserTwoThred implements Runnable
{
    private volatile Say say;
    private String[] str = {"привет :)",
            "Может быть то что Вас интересует больше всего?))",
            "ладно)))",
            "учусь в колледже на бухгалтера :)\n" +
                    "а ты чем просто Макс?))",
            "не интересно для кого? для тебя возможно, а мне вот очень интересно)) где работаешь? \n" +
                    "\n" +
                    "ахаха, это такой тонкий намёк на парня?))) с каким-то конкретным парнем или вообще со всеми?))) \n" +
                    "если честно свободного времени практически нет из-за теха)"
    };

    public SayUserTwoThred(Say say)
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
                    while (!say.isSay())
                    {
                        say.wait();
                    }
                    System.out.println(str[i]);
                    Thread.sleep(2000);
                    say.sayUseOne();
                    say.notify();
                }
            }

        } catch (InterruptedException e){

        }
    }
}
