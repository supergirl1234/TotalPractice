package comTwo;

/**
 * Author:Fanleilei
 * Created:2019/6/9 0009
 */
public class Test2 {
/*
    static boolean p;


    public static void main(String[] args) {
        System.out.println(p);
    }*/

  /*  private int count;
    public static void main(String[] args) {
        Test2 p=new Test2(2);
        System.out.println(p.count);
    }

    Test2(int count) {
        this.count = count;
    }*/

  private String name="abc";

    public static void main(String[] args) {
        Test2 test=new Test2();
        Test2 p=new Test2();
        System.out.println(test.equals(p));
        System.out.println(test.name.equals(p.name));
    }
}
