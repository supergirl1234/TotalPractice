package com;


/*
*
* 回文串：正读和反读都一样的字符串，比如noon，level，字符串左右对称
题目描述：
给定一个字符串 s,把 s 分割成一系列的子串，分割的每一个子串都为回文串
返回最小的分割次数
比如，给定 s = "aab",
返回1，因为一次cut就可以产生回文分割["aa","b"]
* */
public class Test7 {

     public static int test(String s){


         int[] result=new int[s.length()+1];//用来存放[0,i)之间的字符串被分割的次数
         /*初始化，刚开始，[0,i]之间的字符串被分割的次数 均为最大值i-1*/
         for(int i=0;i<result.length;i++){
             result[i]=i-1;

         }
         for(int i=1;i<result.length;i++){

             for(int j=0;j<i;j++){

                 if(isHuiWen(s.substring(j,i))){//如果字符串[j,i）之间是回文，则分割的次数为：前j个字符串分割次数+1

                     result[i]=Math.min(result[j]+1,result[i]);

                 }
             }

         }
         return  result[s.length()];
     }

     /*判断一个字符串是不是回文字符串*/
    public static boolean isHuiWen(String s){

        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){

                return  false;
            }
            left++;
            right--;

        }

        return  true;
    }
    public static void main(String[] args) {

        String str="hreywewjujqw";
        int result=test(str);
        System.out.println(result);
    }
}
