package comm;

public class StaticTest {

    static  int i;
    public int m;//成员变量、实例变量,必须创建对象才能调用该变量

    public static void main(String[] args) {

        System.out.println("i="+i);//静态变量默认为0
        //System.out.println("m="+m);//这句代码是错误的，m是成员变量，非静态的，不能在静态方法中使用

        StaticTest p=new StaticTest();
        int result1=p.m;
        int result2=p.i;
        System.out.println("result1="+result1);//0  成员变量默认为0
        System.out.println("result2="+result2);//0

    }

}
