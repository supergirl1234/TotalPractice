package comTwo;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/11 0011
 *
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
 *
 * 给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 *
 * 现给定数字，请编写程序输出能够组成的最小的数。
 *
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字
 */
public class MakeMinNun {


    public static String MakeMinNum(int[] array){


        StringBuilder sb=new StringBuilder();
        //先构造不含0的
        for(int i=1;i<array.length;i++) {
            if(array[i]!=0) {
                for(int k=0;k<array[i];k++) {
                    sb.append(i);
                }
            }
        }
        //如果含有0，则将0插入到第一个数字后面
        if(array[0]!=0){
            for(int k=0;k<array[0];k++){
                sb.insert(1,0);
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println("请输入0-9的个数");
        int[] array=new int[10];
        Scanner in=new Scanner(System.in);

           for(int i=0;i<10;i++){

               array[i]=in.nextInt();
           }

         String result=MakeMinNum(array);
        System.out.println(result);

    }
}
