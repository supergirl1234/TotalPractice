package com;


class Person implements  Cloneable{


    public   Object[] array;
    public int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {

        Person result= (Person) super.clone();
        result.array=array.clone();
        return result;
    }
}
public class TestClone {


    public static void main(String[] args) {

        Person   person1=new Person(12);
        person1.array= new Object[] {1, 2};
        System.out.println(person1);
        System.out.println(person1.array);

        try {
            Person person3= (Person) person1.clone();

            System.out.println(person3);

            System.out.println(person3.array);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
