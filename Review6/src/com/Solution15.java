package com;


/*
* 题目：
* 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
*
* */
public class Solution15 {
    public int Sum_Solution(int n) {


        /*利用短路与的特性*/
        int sum=n;
        boolean isLing=(sum!=0) &&(sum+=Sum_Solution(n-1))!=0;//&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
                                                                  //只有当n不等于0时，才计算
        return sum;
    }

    public static void main(String[] args) {

        Solution15 solution15=new Solution15();

        int result=solution15.Sum_Solution(5);
        System.out.println(result);
    }

}
