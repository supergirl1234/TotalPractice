package com;


/*
* 给定一个字符串s和一个词典dict，确定s是否可以根据词典中的词分成一个或多个单词
* 比如：给定s="leetcode"  dict=["leet","code"],返回true
* */


import java.util.Set;
import java.util.TreeSet;

/*
* 状态F(i):s的前i个字符是否可以被分割
* F(i)=F(i-n)&&n-i个字符是否可以被分割,也可以写为：F(i)=F(j)&&s(j+1到i的字符)
*
* */
public class PartString {


    public static  boolean isPart(String s,Set<String> dict){

        if(s==null||dict.isEmpty()){

            return  false;
        }

        boolean[] result=new boolean[s.length()+1];
        result[0]=true;

        /*leetcode*/
        for(int i=1;i<=s.length();i++){

            for(int j=0;j<i;j++) {

                /*F(i)=F(j)&&s(j+1到i的字符)*/
                if (result[j] && dict.contains(s.substring(j, i))) {

                    result[i] = true;
                }
            }
        }
        return  result[result.length-1];

    }

    public static void main(String[] args) {

        String s="leetcode";
        Set<String> set=new TreeSet<>();
        set.add("leet");
        set.add("code");
        boolean result=isPart(s,set);
        System.out.println(result);
    }
}
