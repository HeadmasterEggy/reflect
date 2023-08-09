package com.example.reflect1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class reflect {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
         * 获取class对象的方式
         */

        Class<?> c1 = Class.forName("com.example.reflect1.Student");

        Class<?> c2 = Student.class;

        Student s = new Student();
        Class<?> c3 = s.getClass();

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
}
