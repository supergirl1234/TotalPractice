package comm;

import java.util.Scanner;

/*
* 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

例如：

1^3=1

2^3=3+5

3^3=7+9+11

4^3=13+15+17+19

* 输出分解后的string
* */
/*
* 思路：总结归纳，连续奇数求和就是等差数列求和，难点立即转换为等差数列的首项，得出首项 a = m*(m-1)+1
* */
public class Test16 {


    public static  String test(int num){


        int start=num*(num-1)+1;
        StringBuilder sb=new StringBuilder();
        sb.append(start);
        for(int i=0;i<num-1;i++){

            start=start+2;
            sb.append("+"+start);
        }
        return  sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        String result=test(num);
        System.out.println(result);
    }
}
