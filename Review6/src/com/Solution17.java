package com;


/*
 * 题目：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入一个字符串,包括数字字母符号,可以为空
 * */

/*
* ？
*
* */
public class Solution17 {

    public int StrToInt(String str) {

        if (str.equals("")) {
            return 0;

        }

        int i = 0;
        int num = 0;
        int flag = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            i++;
            if (str.charAt(0) == '+') {
                flag = 1;
            } else if (str.charAt(0) == '-') {
                flag = -1;
            }

        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
        }


        if (i == str.length()) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                i = 1;
            } else {

                i = 0;
            }
           int  overValue =0;
            for (; i < str.length(); i++) {

                overValue = flag*num - Integer.MAX_VALUE/10
                        + (((flag+1)/2 + str.charAt(i)-'0' > 8) ? 1:0);//判断是否越界

                if (overValue > 0) return 0;


                num=num*10+(str.charAt(i)-'0')*flag;
            }
        }

        return num ;

    }

    public static void main(String[] args) {

        Solution17 solution17=new Solution17();
        int result=solution17.StrToInt("-2147483648");
        System.out.println(result);
    }
}
