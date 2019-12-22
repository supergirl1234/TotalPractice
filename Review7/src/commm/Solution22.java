package commm;


import java.util.Set;
import java.util.TreeSet;

/*
* 题目:
* 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
例如:
给定s=“leetcode”；
dict=["leet", "code"].
返回true，因为"leetcode"可以被分割成"leet code".
*
* */

/*
* 思路：
*  状态转移方程：
* f(i) 表示s[0,i]是否可以分词
* f(i) = f(j) && f(j+1,i); 0 <= j < i;
*
* */
public class Solution22 {

    public boolean wordBreak(String s, Set<String> dict) {

       if(s==null || s.length()==0){
           return  true;

       }
       if(dict==null){

           return  false;
       }
       boolean[] result=new boolean[s.length()+1];

       result[0]=true;
       for(int i=0;i<=s.length();i++){

           for(int j=0;j<i;j++){

               if(result[j]&&dict.contains(s.substring(j,i))){

                   result[i]=true;
               }
           }

       }
       return  result[result.length-1];


    }

    public static void main(String[] args) {

        String s="a";
        Set<String> set=new TreeSet<>();
        set.add("a");
        Solution22 solution22=new Solution22();
        boolean result=solution22.wordBreak(s,set);
        System.out.println(result);
    }
}
