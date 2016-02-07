package my_examples;

/**
 * Created by advirtys on 26.11.15.
 */
public class Replacer {
    private String name1 = "Оля";
    private String name2 = "Лена";

    public synchronized void swap(){
        String s = name1;
        name1 = name2;
        name2 = s;
    }


    public static void main(String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Replacer replacer = new Replacer();
                for (int i = 0; i < 2; i++)
                {

                    System.out.println(replacer.name1);
                    System.out.println(replacer.name2);
                    replacer.swap();


                    System.out.println(replacer.name1);
                    System.out.println(replacer.name2);

                }

            }
        });
        thread.start();
    }
}
