package com.example.relfect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> class1 = Class.forName("com.example.relfect4.Student");
        //获取所有方法对象(包含父类中所有的公共方法)
        Method[] methods = class1.getMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
        //public java.lang.String com.example.relfect4.Student.getName()
        //public java.lang.String com.example.relfect4.Student.toString()
        //public void com.example.relfect4.Student.sleep()
        //public void com.example.relfect4.Student.setName(java.lang.String)
        //public int com.example.relfect4.Student.getAge()
        //public void com.example.relfect4.Student.setAge(int)
        //public boolean java.lang.Object.equals(java.lang.Object)
        //public native int java.lang.Object.hashCode()
        //public final native java.lang.Class java.lang.Object.getClass()
        //public final native void java.lang.Object.notify()
        //public final native void java.lang.Object.notifyAll()
        //public final void java.lang.Object.wait(long) throws java.lang.InterruptedException
        //public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        //public final void java.lang.Object.wait() throws java.lang.InterruptedException

        System.out.println();

        //获取所有方法对象(不能获取父类的，但是可以获取本类中私有方法)
        Method[] methods1 = class1.getDeclaredMethods();
        for(Method method : methods1){
            System.out.println(method);
        }
        //public java.lang.String com.example.relfect4.Student.getName()
        //public java.lang.String com.example.relfect4.Student.toString()
        //public void com.example.relfect4.Student.sleep()
        //public void com.example.relfect4.Student.setName(java.lang.String)
        //public int com.example.relfect4.Student.getAge()
        //public void com.example.relfect4.Student.setAge(int)
        //private void com.example.relfect4.Student.eat(java.lang.String,int)
        //private void com.example.relfect4.Student.eat(java.lang.String)

        System.out.println();

        //获取指定的单一方法
        Method methods2 = class1.getDeclaredMethod("eat", String.class);
        System.out.println(methods2);
        //private void com.example.relfect4.Student.eat(java.lang.String)

        System.out.println();

        //获取方法的修饰符
        int modifiers = methods2.getModifiers();
        System.out.println(modifiers);
        //2

        System.out.println();

        //获取方法的名字
        String name = methods2.getName();
        System.out.println(name);
        //eat

        System.out.println();

        //获取方法的形参
        Parameter[] parameters = methods2.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        //java.lang.String arg0
        //int arg1

        System.out.println();

        //获取方法抛出的异常
        Class[] exceptionTypes = methods2.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
        //class java.io.IOException
        //class java.lang.NullPointerException
        //class java.lang.ClassCastException

        System.out.println();

        //参数s: 表示方法的调用者
        //参数"披萨": 表示者调用方法的时候传递的实际参数
        Student s = new Student();
        methods2.setAccessible(true);
        methods2.invoke(s, "披萨");
        //在吃披萨

        System.out.println();


    }
}
