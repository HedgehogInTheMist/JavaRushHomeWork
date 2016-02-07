package com.javarush.test.level29.lesson05.task01;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

/* И еще раз рефакторинг
1. Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга)
2. Просмотрите методы класса ConcurrentMap.
3. В строке "String previousEntry = null;" у concurrentMap вызовите метод,
который вставит пару (randomInt, text) только для ключа, которого нет в concurrentMap.
Метод должен возвращать предыдущее значение либо null для новой пары.
*/
public class Solution {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(getRunnable(i, concurrentMap)).start();
        }
        sleepSecond();
    }

    private static void sleepSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable getRunnable(final int I, final ConcurrentMap<Integer, String> CONCURRENT_MAP) {
        return new Runnable() {
            @Override
            public void run() {
                final String NAME = "Thread #" + I;
                int randomInt = RANDOM.nextInt(20);
                String text = NAME + " вставил запись для " + randomInt;

                //previousEntry is null if it is new entry
                /* instead of null - call CONCURRENT_MAP.someMethodName(randomInt, text)*/
                String previousEntry = CONCURRENT_MAP.putIfAbsent(randomInt, text);;

                if (previousEntry != null) {

                    System.out.println(NAME + " хочет обновить " + randomInt + ", однако уже " + previousEntry);
                } else {
                    System.out.println(text);
                }
            }
        };
    }
}
