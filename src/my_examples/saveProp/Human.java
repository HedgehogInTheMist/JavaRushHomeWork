package my_examples.saveProp;

import java.io.*;

/**
 * Created by advirtys on 02.12.15.
 */
public class Human
{
    public Cat cat;
    public Dog dog;

    public void save(OutputStream os){
        PrintWriter pw = new PrintWriter(os);
        String isCatPresent = cat!=null?"yes":"no";
        pw.println(isCatPresent);
        pw.flush();
        if(cat!=null){
            cat.save(os);
        }
        String isDogPresent = dog!=null?"yes":"no";
        pw.println(isDogPresent);
        pw.flush();
        if (dog!=null){
            dog.save(os);
        }

    }

    public void load(InputStream is) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String isCatPresent = reader.readLine();

        if (isCatPresent.equals("yes")){
            cat = new Cat();
            cat.load(is);
        }


        String isDogPresent = reader.readLine();
        if (isDogPresent.equals("yes")){
            dog = new Dog();
            dog.load(is);
        }

    }
}
