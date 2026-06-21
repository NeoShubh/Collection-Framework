package com.example.Collections.comparableInterface.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class ProgramOne {
    public static void main(String [] args){
        Student s1 = new Student("Shubham",120);
        Student s2 = new Student("Mohit",150);
        Student s3 = new Student("abhishek",259);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);list.add(s2);list.add(s3);
        list.sort(null);
        System.out.println(list);

    }
}



class Student implements Comparable<Student> {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
//uncomment this two methods and they will start comparing the way you want them to
    @Override
    public int hashCode() {
        return Objects.hash(name, marks);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return marks == other.getMarks() && Objects.equals(name, other.getName());
    }

    @Override
    public String toString() {
        return "name:" + name + " marks:" + marks;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getMarks(),this.getMarks());
    }
}

