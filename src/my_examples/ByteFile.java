package my_examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/** Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/
public class ByteFile
{
    public static void main(String[] args)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("/makc/JavaRushHomeWork/src/my_examples/test");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Set<Integer> tree = new TreeSet<Integer>();
        List<Integer> file = new ArrayList<Integer>();
        Map<Integer, Integer> byteCount = new HashMap<Integer, Integer>();
        try
        {
            while (fis.available() > 0){
                int b = fis.read();
                tree.add(b);
                file.add(b);
               System.out.print(b + " ");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("\n------------------------");

        int[] count = new int[tree.toArray().length];
        for (int i = 0; i < tree.toArray().length; i++)
        {
         //   System.out.println(tree.toArray()[i]);
            for (int j = 0; j < file.size(); j++)
            {
                if (tree.toArray()[i].equals(file.get(j))){
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < tree.toArray().length; i++)
        {
            byteCount.put(count[i], (Integer) tree.toArray()[i]);
            System.out.println(tree.toArray()[i] + " " + count[i]);
        }

        System.out.println("------------------------");




        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Object[] bytes = byteCount.values().toArray();
        Arrays.sort(bytes);

        System.out.println(bytes[0]);
        try
        {
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
