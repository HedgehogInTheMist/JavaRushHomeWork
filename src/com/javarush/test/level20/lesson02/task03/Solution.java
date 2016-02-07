package com.javarush.test.level20.lesson02.task03;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String,String>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        try
        {
            load(new FileInputStream(scanner.nextLine()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()){
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.save(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        prop.list(System.out);
        String res = outputStream.toString();
        System.setOut(consoleStream);

        Iterator iterator = prop.stringPropertyNames().iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }



    }


}
