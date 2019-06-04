package com;

/**
 * Author:Fanleilei
 * Created:2019/5/30 0030
 *
 * 求一个数的阶乘的末尾有几个0
 *
 */
//思路：在计算n的阶乘时，实际上，就是把所有小于等于n的正整数分解成质因数，然后再将其乘到一起，
//那么末尾0的个数实际上就是2*5的个数，而2的个数明显是很多很多，所以问题就转化为了5的个数，
//而只有5的倍数才有5这个因数，所以，问题就进一步转化为小于等于n的数中有多少个数是5的倍数
import java.util.Scanner;
public class Fact{
   /* public static int ZeroNum(int n){

        if(n<1||n>1000){

           throw new Error("数据不合法");
        }

        int count=0;
        long result=Factorial(n);

        String str=String.valueOf(result);
        for(int i=str.length()-1;i>0;i--){
            if(!(str.charAt(i)=='0')){
                break;

            }else{

                count++;
            }


        }

        return count;
    }

    public static long Factorial(int n){
        long result=0;
        if(n==1){

            return 1;
        }else{
            result=n*Factorial(n-1);

        }
         return result;

    }*/



    public static void main(String[] args){
        System.out.println("请输入一个数n'");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        /*int result=ZeroNum(n);
        System.out.println(n+"的阶乘末尾0的个数为："+result+"个10");*/
        int res=0;
        for(int i=n;i>=5;i--){
            int tmp=i;
            while(tmp%5==0){
                res++;
                tmp/=5;

            }

        }
        System.out.println(res);
    }
}