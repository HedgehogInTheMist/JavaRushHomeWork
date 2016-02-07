package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
8       30                              8       4
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        Integer id = 0;


                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                List<String> idList = new ArrayList<String>();

                while (reader.ready()){
                    String s = reader.readLine();
                    if (s.length() > 8){
                        idList.add(s.substring(0,8).trim());
                    } else {
                        idList.add(s.trim());
                    }
                }
                reader.close();

                for (int i = 0; i < idList.size(); i++)
                {
                    int n = Integer.parseInt(idList.get(i));
                    if (id < n){
                        id = n;
                    }
                }


        if (args[0].equals("-c") && args.length == 4){
            String productName = args[1].trim();
            String price = args[2].trim();
            String quantity = args[3].trim();
            String idAI = "";
            id = id + 1;
            idAI = id.toString();

            idAI = lengthString(idAI, 8);
            productName = lengthString(productName,30);
            price = lengthString(price, 8);
            quantity = lengthString(quantity, 4);
            FileOutputStream fos = null;
            byte[] b = (idAI + productName + price + quantity + "\n").getBytes();

                fos = new FileOutputStream(file, true);
                fos.write(b);

            fos.close();
        }
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
}
