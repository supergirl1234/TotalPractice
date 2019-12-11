package com;


/*
* 题目：
* 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
* 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
* */
public class Solution1 {

    public int GetUglyNumber_Solution(int index) {
        if(index<=0){

            return 0;
        }

        int[] result=new int[index];
        result[0]=1;
        int p2=0;
        int p3=0;
        int p5=0;

        for(int i=1;i<index;i++){

            result[i]=Math.min(Math.min(2*result[p2],3*result[p3]),5*result[p5]);//找出三个中的最小值

            if(result[i]==2*result[p2]){
                 p2++;
            }
            if(result[i]==3*result[p3]){
                p3++;
            }
            if(result[i]==5*result[p5]){
                p5++;
            }
        }

        return result[index-1];
    }
    public static void main(String[] args) {

        Solution1 solution1=new Solution1();
        int result=solution1.GetUglyNumber_Solution(1);
        System.out.println(result);

    }
}
