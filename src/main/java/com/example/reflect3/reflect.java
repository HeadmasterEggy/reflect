package com.example.reflect3;

import java.lang.reflect.Field;

public class reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> class1 = Class.forName("com.example.reflect3.Student");

        //获取所有成员变量
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //private java.lang.String com.example.reflect3.Student.name
        //private int com.example.reflect3.Student.age
        //public java.lang.String com.example.reflect3.Student.gender

        //获取单个成员变量
        Field name = class1.getDeclaredField("name");
        System.out.println(name);
        //private java.lang.String com.example.reflect3.Student.name

        //获取权限修饰符
        int modifiers = name.getModifiers();
        System.out.println(modifiers);
        //2

        //获取成员变量名
        String s = name.getName();
        System.out.println(s);
        //name

        //获取成员变量的数据类型
        Class<?> type = name.getType();
        System.out.println(type);
        //class java.lang.String

        //获取成员变量记录的值
        Student c = new Student("张三", 23, "男");
        name.setAccessible(true);
        String value = (String) name.get(c);
        System.out.println(value);
        //张三

        //修改对象里面记录的值
        name.set(c, "李四");
        System.out.println(c);
        //Student{name='李四', age=23, gender='男'}
    }
}
