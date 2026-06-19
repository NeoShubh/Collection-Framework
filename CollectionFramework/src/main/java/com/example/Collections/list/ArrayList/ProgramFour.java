package com.example.Collections.list.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

class compareIntegers implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        System.out.println(o1+" "+ o2 +" -> "+(o2-o1));
        return o2 - o1;
    }
}

class compareStrings implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}

public class ProgramFour {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(0);
        list.add(2);
        list.sort(new compareIntegers());
        System.out.println(list);


        List<String> list1 = new ArrayList<>();
        list1.add("Banana");
        list1.add("Appleeee");
        list1.add("pineapple");
        list1.add("orange");
        list1.sort(new compareStrings());
        System.out.println(list1);


        Student s1 = new Student("Shubham", 8.9);
        Student s2 = new Student("Vikas", 3.9);
        Student s3 = new Student("Dhurandar", 2.9);
        Student s4 = new Student("Akash", 5.9);
        Student s5 = new Student("ram", 7.1);
        Student s6 = new Student("shya,", 6.9);

        List<Student> list3 = new ArrayList<>();
        list3.add(s1);
        list3.add(s2);
        list3.add(s3);
        list3.add(s4);
        list3.add(s5);
        list3.add(s6);
        list3.sort((o1, o2) -> {
            if ((o2.getGpa() - o1.getGpa()) < 0) return -1;
            else if ((o2.getGpa() - o1.getGpa()) > 0) return 1;
            return 0;
        });
        for (Student s : list3)
            System.out.println(s.getName() + " " + s.getGpa());
    }
}
