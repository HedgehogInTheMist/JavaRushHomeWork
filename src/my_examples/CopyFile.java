package my_examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by advirtys on 26.11.15.
 */
public class CopyFile
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream stream = new FileInputStream("/home/advirtys/test");
        FileOutputStream stream1 = new FileOutputStream("/home/advirtys/test2");
        byte[] buffer = new byte[100];
        while (stream.available() > 0){
            int count = stream.read(buffer);
            stream1.write(buffer, 0, count);
        }
        stream.close();
        stream1.close();

    }
}
