package comm;

/*
* 题目：斐波那契
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
* */
public class Solution7 {


    /*递归的思想*/
    public int Fibonacci1(int n) {

       if(n==1||n==2){
           return 1;

       }
       return  Fibonacci1(n-1)+Fibonacci1(n-2);


    }

    /*非递归的思想*/
    public int Fibonacci2(int n) {

        if(n==0){

            return 0;
        }
        if(n==1){

            return 1;
        }

        int a=0;
        int b=1;
        int result=0;
        while(n>=2){


            result=a+b;
            a=b;
            b=result;
            n--;
        }
        return  result;
    }

    }
