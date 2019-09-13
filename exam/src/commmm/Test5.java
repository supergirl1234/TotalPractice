package commmm;

public class Test5 {
    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print("a="+a + " ");//-128
        add(b);
        System.out.print("b="+b + "");//127
    }

    public static void main(String[] args) {
        Test5 p=new Test5();
        p.test();
    }
}