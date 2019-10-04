package comm;


import java.util.Scanner;

/*
* 求两个数的最大公约数
*
* 辗转相除法，又名欧几里德算法，是一种非常高效的求最大公约数（GCD）的算法，它无需分解两个整数的质因子，
* 辗转相除法的递推公式是GCD(a,b)==GCD(b,a%b)，当a%b==0时，b即为所求的最大公约数
* */
public class Test29 {

    public static  int test(int num1,int num2){


        if(num2==0){
            return  num1;
        }
        int temp=num1%num2;
        num1=num2;
        num2=temp;
        return test(num1,num2);

    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        int result=test(num1,num2);
        System.out.println(result);
    }
}
