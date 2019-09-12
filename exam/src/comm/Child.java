package comm;

class Person {
    private String name = "Person";
    int age = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Child extends Person {
    public String grade;

    public static void main(String[] args) {
        Person p = new Child();
        //System.out.println(p.name);//错误，编译就出错
       System.out.println(p.getName());//可以   父类的私有变量子类会继承，但不能直接访问，要通过父类的方法来进行访问
    }
}
