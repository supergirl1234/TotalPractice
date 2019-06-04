package com;

/**
 * Author:Fanleilei
 * Created:2019/5/30 0030
 */
/*
public class TestClass {

    private static void testMethod(){
        System.out.println("tet");
    }

    public static void main(String[] args) {

        ((TestClass)null).testMethod();
        int i=0;
        Integer j=new Integer(0);
        System.out.println(i==j);

    }


}
*/
/*
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {

        empID = id;
    }
}
public class TestClass {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }*/
public class TestClass{

    public static void main(String[] args) {


    }
}

class Person{
    String name="No name";

    public Person(String nm) {
        this.name = nm;
    }

    public static void print(){


    }
}

class Employee extends Person {

    String ID="000";


    public Employee(String nm) {
        super(nm);
    }
}
