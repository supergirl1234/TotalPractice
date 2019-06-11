package comTwo;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/11 0011
 *
 *
 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

 例如：

 1^3=1

 2^3=3+5

 3^3=7+9+11

 4^3=13+15+17+19



 接口说明

 原型：


 /*
 功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 原型：
 int GetSequeOddNum(int m,char * pcSequeOddNum);
 输入参数：
 int m：整数(取值范围：1～100)

 返回值：
 m个连续奇数(格式：“7+9+11”);

 输出分解后的string
 */


public class NicholsTheory {

    public static String GetOddNum(int mm){


        //首项=mm*(mm-1)+1
        StringBuilder sb=new StringBuilder();
        int a1=mm*(mm-1)+1;
        sb.append(a1);
        for(int i=1;i<mm;i++){
            sb.append("+");
            sb.append(a1+2*i);

        }
        return  sb.toString();

    }

    public static void main(String[] args) {

        System.out.println("请输入一个数：");
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();

        String result=GetOddNum(num);
        System.out.println(result);

    }
}
