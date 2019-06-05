package comTwo;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/4 0004
 * 两个超长正整数的1加法
 */
public class LonglongNumAdd{


    public static BigInteger AddLongInteger(String addend, String augend){


        BigInteger num1=new BigInteger(addend);
        BigInteger num2=new BigInteger(augend);

        BigInteger result=num1.add(num2);


        return   result;
    }

    public static void main(String[] args) {

        System.out.println("请输入两个字符串数字");
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String addend=in.nextLine();
            String augend=in.nextLine();


            System.out.println( AddLongInteger(addend,augend));
        }

    }
}