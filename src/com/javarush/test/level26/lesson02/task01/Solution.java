package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final double m;
        if (array.length % 2 == 0){
            m = (array[array.length/2-1] + array[array.length/2])/2;
        } else {
            m = array[array.length/2];
        }
        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double val = Math.abs(o1-m) - Math.abs(o2-m);
                if (val == 0){
                    val = o1 - o2;
                }
                return (int) val;
            }
        };
        System.out.println(m);
        Arrays.sort(array, comparator);
        return array;
    }


    public static void main(String[] args)
    {
        Integer[] ar = {2,3,1,8,9};

        sort(ar);

        for (Integer i : ar){
            System.out.print(i + ",");
        }

    }
}
