package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 回溯：是一种通过穷举所有可能情况来找到所有解的算法，如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，
 * 并在前面的一些步骤做出一些修改，并重新尝试找到可行解，回溯算法一般会结合在搜素算法中
 */

/*
 * 深度优先
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合，给出数字到字母的映射如下（与电话按键相同），
 * 注意1不对应任何字母
 * 例如：输入23
 *      输出["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * */
public class AllMight {
    public static ArrayList<String> test(String str) {



        ArrayList<String> lists=new ArrayList<>();

        if(str==null){

            return  lists;
        }
        dfs(str,0,"",lists);
        return lists;
    }

    public static void dfs(String str, int index, String curStr, ArrayList<String> lists){
        String[] strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(str.length()==curStr.length()){
            lists.add(curStr);
            return;
        }
       for(int i=index;i<str.length();i++){
           String s= strings[str.charAt(index)-'0'];
           for(int j=0;j<s.length();j++) {
               dfs(str,i+1,curStr+s.charAt(j),lists);
           }
        }
    }

    public static void main(String[] args) {


        String  str="234";
        ArrayList<String> list=test(str);
        System.out.println(list);
    }
}
