package commm;

public class StaticClass {

    static {
        System.out.println("静态代码块");
    }

    public StaticClass() {
        System.out.println("构造方法");
    }

    private  static  String name=staticMethod();

    private static String staticMethod() {
        System.out.println("执行静态方法");
        return "静态方法";
    }

}
