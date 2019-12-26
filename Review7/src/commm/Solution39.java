package commm;


import java.util.ArrayList;

/*
* 题目：
* 格雷码是一种二进制编码系统，如果任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码（Gray Code）。
给定一个非负整数n，表示代码的位数，打印格雷码的序列。格雷码序列必须以0开头。
例如：给定n=2，返回[0,1,3,2]. 格雷码的序列为：
00 - 0↵01 - 1↵11 - 3↵10 - 2
注意：
对于一个给定的n，格雷码的序列不一定是唯一的，
例如：根据题目描述，[0,2,3,1]也是一个有效的格雷码序列
*
* */
public class Solution39 {

    public ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> list=new ArrayList<>();
        if(n==0){

            list.add(0);
            return  list;
        }
        if(n==1){
            list.add(0);
            list.add(1);
            return  list;

        }

        ArrayList<Integer> preList=grayCode(n-1);
        for(Integer item:preList){
            list.add(item);
            list.add(item+(1<<n));


        }
        return  list;
    }


    /*
    * 思路：
    * 自己与自己右移一位的异或
    * */
    public  ArrayList<Integer> grayCode2(int n){



        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num = 1 << n; //相当于2的n次方
        for(int i = 0; i < num; ++i){
            arr.add(i>>1^i);//i右移一位之后和原来i做位异或运算
        }
        return arr;
    }
}
