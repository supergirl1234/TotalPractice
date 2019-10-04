package comm;


import java.util.Scanner;

/*
* ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

* */

//输入
//1 输入IP地址
//2 输入10进制型的IP地址

//输出
//1 输出转换成10进制的IP地址
//2 输出转换后的IP地址
public class Test25 {


    /*将IP地址转化为10进制*/
    public static Long convertToNum(String str) {

        String[] strings = str.split("\\.");//这个地方要添加\\,否则出错；
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(TWO(Integer.parseInt(strings[i])));

        }
        return Long.parseLong(sb.toString(),2);//二进制转化为10进制
    }

    /*将某个数转化为二进制*/
    public static String TWO(int num) {

        StringBuilder sb = new StringBuilder();
        while (num != 0) {

            sb.append(num % 2);
            num = num / 2;

        }
        int len = sb.length();
        if (len < 8) {

            for (int i = 0; i < 8 - len; i++) {

                sb.append(0);
            }

        }
        return sb.reverse().toString();


    }

    //将10进制转化为IP地址
    public static String convertToStr(String str) {

        String ss = Long.toBinaryString(Long.parseLong(str));//长整型转二进制字符串
        int len = ss.length();
        String s = "";
        if (len < 32) {

            s += "0";
        }
        ss = s + ss;
        String[] ips = new String[4];
        ips[0] = ss.substring(0, 8);
        ips[1] = ss.substring(8, 16);
        ips[2] = ss.substring(16, 24);
        ips[3] = ss.substring(24);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.parseInt(ips[i], 2));
            if (i != 3) {
                sb.append(".");

            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String strNum = scanner.nextLine();
        Long result1=convertToNum(str);
        String result2=convertToStr(strNum);
        System.out.println(result1);
        System.out.println(result2);

    }
}
