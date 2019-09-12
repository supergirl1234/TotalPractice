package comm;


class Test1 {
    public static void hello() {
         System.out.println("hello");
    }
}

public class MyApplication {
    public static void main(String[] args) {
       Test1 test=null;
       test.hello();//能正常编译，且能运行
    }
}