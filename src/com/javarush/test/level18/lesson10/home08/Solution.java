package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        readFiles();
        postFileNameToReadTread();

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

    public static class ReadThread extends Thread {
        private volatile String fileName;
        private volatile FileInputStream fis;
        public ReadThread(String fileName) {

                this.fileName = fileName;
            try
            {
                fis = new FileInputStream(fileName);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            List<Integer> bytes = new ArrayList<>();
            try
            {
                while (fis.available()>0){
                    int b = fis.read();
                    bytes.add(b);
                }
                fis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


            int[] count = new int[bytes.size()];
            for (int i = 0; i < bytes.size(); i++)
            {
                count[i] = 0;
                for (int j = 0; j < bytes.size(); j++)
                {   int a = bytes.get(i);
                    int b = bytes.get(j);
                    if (a == b)
                        count[i]++;
                }
            }

            int max = 0;
            for (int i = 0; i < count.length; i++)
            {
                if (max < count[i]){
                    max = count[i];
                }
            }

            int index = 0;
            for (int i = 0; i < count.length; i++)
            {
                if (max == count[i]){
                    index = i;
                    break;
                }
            }

            resultMap.put(fileName, bytes.get(index));
        }
    }

    // Читайте с консоли имена файлов, пока не будет введено слово "exit"
    public static void readFiles() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")){
            list.add(fileName);
            fileName = reader.readLine();
        }
        reader.close();
    }

    // Передайте имя файла в нить ReadThread
    public static void postFileNameToReadTread(){
        for (String file : list){
           Thread t = new ReadThread(file);
            t.start();
        }
    }
}
