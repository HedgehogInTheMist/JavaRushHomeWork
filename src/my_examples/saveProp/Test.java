package my_examples.saveProp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by advirtys on 02.12.15.
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        Human max = new Human();




        max.load(new FileInputStream("/makc/max"));
        System.out.println(max.cat);
        System.out.println(max.cat.name);

    }
}
