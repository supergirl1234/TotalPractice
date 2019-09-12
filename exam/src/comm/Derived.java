package comm;

class Base {
    public Base(String s) {
        System.out.print("B");
    }
}

public class Derived extends Base {

    /*public Derived(String s) {    //这种是错误的
        System.out.print("D");
    }
    */
    public Derived(String s) {
        super(s);
        System.out.print("D");
    }




    public static void main(String[] args) {
        new Derived("C");
    }
}
