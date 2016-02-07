package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private String id;
    private String productName;
    private String price;
    private String quantity;

    public Solution()
    {
    }

    public Solution(String id, String productName, String price, String quantity)
    {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    private static List<Solution> list = new ArrayList<Solution>();


    public static void main(String[] args) throws IOException
    {
        list.clear();
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while (reader.ready()){
            String s = reader.readLine();

            String  id = s.substring(0,8);
            String pr = s.substring(8,38);
            String price = s.substring(38, 46);
            String q = s.substring(46, 50);
            list.add(new Solution(id, pr, price, q));
        }
        reader.close();


        if (args[0].equals("-d") && args.length == 2){
            String data = lengthString(args[1],8);
            data = data.trim();
            int id = Integer.parseInt(data);

            for (int i = 0; i < list.size(); i++)
            {
                if (id == list.get(i).getIdInt()){
                    list.remove(i);
                }
            }
            FileOutputStream fos = new FileOutputStream(file);
            for(Solution s : list){
                byte[] bytes = s.toString().getBytes();
                fos.write(bytes);
            }
            fos.close();
        } else if (args[0].equals("-u") && args.length == 5){
            String data = lengthString(args[1],8);
            data = data.trim();
            int id = Integer.parseInt(data);
            int index = 0;
            for (int i = 0; i < list.size(); i++)
            {
                if (id == list.get(i).getIdInt()){
                    index = i;
                }
            }

            Solution s = new Solution();
            s.setId(String.valueOf(id));
            s.setProductName(args[2]);
            s.setPrice(args[3]);
            s.setQuantity(args[4]);
            list.remove(index);
            list.add(index,s);

            FileOutputStream fos = new FileOutputStream(file);
            for(Solution ss : list){
                byte[] bytes = ss.toString().getBytes();
                fos.write(bytes);
            }
            fos.close();
        }
    }

    public String getId()
    {
        return lengthString(id, 8);
    }

    public int getIdInt()
    {
        return Integer.parseInt(id.trim());
    }

    public void setId(String id)
    {
        this.id = lengthString(id, 8);
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = lengthString(price, 8);
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = lengthString(productName, 30);
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = lengthString(quantity, 4);
    }

    public static String lengthString(String str, int len){
        if (str.length() > len){
            return str.substring(0, len);
        } else {
            StringBuilder stb = new StringBuilder(str);
            int space = len - str.length();
            for (int i = 0; i < space; i++)
            {
                stb.append(" ");
            }
            return stb.toString();
        }
    }

    @Override
    public String toString()
    {
        return id+productName+price+quantity+"\n";
    }
}
