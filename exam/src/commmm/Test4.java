package commmm;

public class Test4 {

    public static void main(String[] args) {

        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        //b3 = (b1 + b2);如果这样写会编译报错，因为byte+byte结果为int，要进行强转，下面的写法正确，而上一句，因为b4和b5都是被final修饰的，所以结果还是byte的
        b3 = (byte) (b1 + b2);
        System.out.println(b3 + b6);
    }
}
