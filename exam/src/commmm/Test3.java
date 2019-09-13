package commmm;

class Person {

    String name = "No name";

    public Person(String nm) {
        name = nm;
    }
}

class Employee extends Person {
    String empID = "0000";

    public Employee(String nm) {
        super(nm);
    }

   /* public Employee(String id) { //这样写是编译报错的,里面必须调用父类的构造方法  super

        empID = id;
    }*/
}
public class Test3 {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}