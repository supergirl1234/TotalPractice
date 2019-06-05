package comTwo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/5 0005
 *
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 *  *
 *  * 使用递归的方法生成N位的格雷码。
 *  *
 *  * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 *  * n=2的gray码是(0,1)
 *  * n=2的gray码是(00,01,11,10)
 *  * n=2的gray码是(000,001,011,010,100,101,111,110)
 */
public class GeLeiMa {

    public static String[] MakeGeLeiMa(int n){

        String[] result=null;
        if(n==1){
             result=new String[]{"0","1"};


        }else {
            //先求出前一个数的格雷码
            String[] strs=MakeGeLeiMa(n-1);
            //该数的格雷码的个数是前一个格雷码的个数的两倍
            result=new String[2*strs.length];
            //在前一个数的格雷码的前面加0或加1
            for(int i=0;i<strs.length;i++) {
              result[i]="0"+strs[i];
              result[result.length-1-i]="1"+strs[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数：");

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String[] result=MakeGeLeiMa(n);



    }
}
