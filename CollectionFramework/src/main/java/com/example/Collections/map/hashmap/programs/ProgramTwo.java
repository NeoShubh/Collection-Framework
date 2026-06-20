package com.example.Collections.map.hashmap.programs;

import java.util.HashMap;

//you can watch there we have done the same thing in two different scenario one where
//have object as a key and String in another. but in hm map we put the same key two times it will
//override the values for it but if we talk about mp in case of object they calculate the index
//on the basis of memory loaction So each time you create a object will have different memory
//so irrespective of the object pair (s1 and s3 are similar) they still take it as different value and
//not overrirde it


public class ProgramTwo {
    public static void main(String[] args) {
        HashMap<Student, String> mp = new HashMap<>();
        Student s1 = new Student("Shubham", 100);
        Student s2 = new Student("Vikas", 500);
        Student s3 = new Student("Shubham", 100);
        mp.put(s1, "Teacher"); //hashcode --> index1
        mp.put(s2, "Engineer");//hashcode --> index2
        mp.put(s3, "plumber"); //hashcode --> index3
        System.out.println(s1);
        System.out.println(s3);
        System.out.println(mp.get(s1));
        System.out.println(mp.get(s3));
        System.out.println(mp.size()); //here the size is 3

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Shubham", 90); // hashcode --> index1
        hm.put("Neha", 92); //hashcode --> index2
        hm.put("Shubham", 98); //hashcode --> index1
        System.out.println(hm.size()); // here the size is 2
    }
}


class Student {
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
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, marks);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (this.getClass() != obj.getClass()) return false;
//        Student other = (Student) obj;
//        return marks == other.getMarks() && Objects.equals(name, other.getName());
//    }

    @Override
    public String toString() {
        return "name:" + name + " marks:" + marks;
    }
}
