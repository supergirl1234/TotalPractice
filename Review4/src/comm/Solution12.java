package comm;

/*
* 题目：
*
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
* */
public class Solution12 {
    public double Power(double base, int exponent) {

        /*exponent可能是负数*/
        double result=1;

        int e=0;
        if(exponent<0){
            e=-exponent;

        }else{

            e=exponent;
        }
        while (e!=0){

            result*=base;
            e--;
        }
        return  exponent>0?result:1/result;

    }
}
