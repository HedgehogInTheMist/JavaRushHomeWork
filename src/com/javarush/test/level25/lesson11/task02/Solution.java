package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {

            this.index = index;
        }

        public void run() {

            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args)
    {
        Solution.YieldRunnable y = new Solution.YieldRunnable(0);
        Thread thread = new Thread(y);
        thread.start();
        Solution.YieldRunnable y2 = new Solution.YieldRunnable(1);
        Thread thread2 = new Thread(y2);
        thread2.start();
    }
}
