package com;

import java.util.HashSet;
import java.util.Set;

/*
* 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。

例如:
给定s=“leetcode”；
dict=["leet", "code"].
返回true，因为"leetcode"可以被分割成"leet code".

* */
public class Test3 {

    /*
    * 前1，2，3，...,n个字符能否根据词典中的词被成功分词
    * */
    public  static boolean test(String s,Set<String> set){

        int length=s.length();
        boolean[] isTrue=new boolean[length+1];//用于存放前n的字符是否能够根据词典中的词被成功分词的结果
        isTrue[0]=true;
        for(int i=1;i<isTrue.length;i++){

            isTrue[i]=false;
        }

         for(int i=1;i<=s.length();i++){

             for(int j=i-1;j>=0;j--){

                 if(isTrue[j]&&set.contains(s.substring(j,i))){

                       isTrue[i]=true;
                       break;

                 }

             }
         }
         return  isTrue[isTrue.length-1];
    }

    public static void main(String[] args) {


        String s="leetcode";
        Set<String> set=new HashSet<>();
        set.add("leet");
        set.add("code");
        boolean result=test(s,set);
        System.out.println(result);

    }
}
