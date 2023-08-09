package com.example.reflect2;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Student(int age) {
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
