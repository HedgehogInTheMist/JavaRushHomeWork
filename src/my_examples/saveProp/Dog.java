package my_examples.saveProp;

import java.io.*;

/**
 * Created by advirtys on 02.12.15.
 */
public class Dog
{
    public String name;
    public int age;
    public int weight;

    public void save(OutputStream os){
        PrintWriter pw = new PrintWriter(os);
        pw.println(name);
        pw.println(age);
        pw.println(weight);
        pw.flush();
    }

    public void load(InputStream is) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(is));
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }
}
