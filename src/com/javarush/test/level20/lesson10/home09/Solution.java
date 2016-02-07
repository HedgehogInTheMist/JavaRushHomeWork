package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<Solution>();

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution();
        solution.node = 5;
        solution.edges.add(new Solution());
        solution.edges.add(new Solution());
        solution.edges.add(new Solution());

        FileOutputStream fos = new FileOutputStream("/makc/out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution);

        FileInputStream fis = new FileInputStream("/makc/out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solution2 = (Solution) ois.readObject();
        System.out.println(solution2.node);


    }
}
