package com.example.reflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> class1 = Class.forName("com.example.reflect2.Student");

        /*
         * 获取public构造方法
         */
//        Constructor<?>[] constructors = class1.getConstructors();
//        for(Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }

        /*
         * 获取所有构造方法
         */
//        Constructor[] constructors1 = class1.getDeclaredConstructors();
//        for (Constructor constructor : constructors1) {
//            System.out.println(constructor);
//        }
        /*
         * public com.example.reflect2.Student()
         * public com.example.reflect2.Student(java.lang.String)
         * protected com.example.reflect2.Student(int)
         * private com.example.reflect2.Student(java.lang.String,int)
         */

        System.out.println(class1.getDeclaredConstructor(String.class));
        //public com.example.reflect2.Student(java.lang.String)


        System.out.println(class1.getDeclaredConstructor());
        //public com.example.reflect2.Student()

        System.out.println(class1.getDeclaredConstructor(int.class));
        //protected com.example.reflect2.Student(int)

        System.out.println(class1.getDeclaredConstructor(String.class, int.class));
        //private com.example.reflect2.Student(java.lang.String,int)

        System.out.println(class1.getModifiers());
        //1

        Constructor con4 = class1.getDeclaredConstructor(String.class, int.class);
        Parameter[] parameters = con4.getParameters();
        for(Parameter parameter : parameters){
            System.out.println(parameter);
        }
        //java.lang.String arg0
        //int arg1

        //暴力反射: 临时取消权限校验
        con4.setAccessible(true);
        Student stu = (Student)con4.newInstance("张三", 23);
        System.out.println(stu);
        //Student{name='张三', age=23}
    }
}
