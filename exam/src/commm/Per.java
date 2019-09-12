package commm;


class Person{

    public void say(){ //如果父类中的方法是私有的，则子类无法调用


        System.out.println("hi");

    }
}
public class Per  extends  Person{
    public static void main(String[] args) {
        Per per=new Per();
        per.say();
    }
}
