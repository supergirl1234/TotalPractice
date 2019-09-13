package commmm;

public class ZeroTest {
    public static void main(String[] args) {
        try {

            int i = 100 / 0;
            System.out.print(i);
        } catch (Exception e) {
            System.out.print(1);
            throw new RuntimeException();//当执行 thrownewRuntimeException();  又会抛出异常，这时，除了会执行finally中的代码，其他地方的代码都不会执行
        } finally {
            System.out.print(2);
        }
        System.out.print(3);
    }
}