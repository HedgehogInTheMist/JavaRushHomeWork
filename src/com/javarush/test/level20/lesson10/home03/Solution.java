package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    static final long SerialVersionUID = -4862926644813433707L;
    public static class A {

        protected String name = "A";
        public A() {}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {

        public B() {}

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String)in.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s = new Solution();
        Solution.B b = s.new B("M");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/makc/out"));
        oos.writeObject(b);

        System.out.println(b.name);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/makc/out"));
        Solution.B b2 = (B) ois.readObject();
        System.out.println(b2.name);
    }

}
