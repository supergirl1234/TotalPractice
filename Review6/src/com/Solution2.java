package com;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* 题目：
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
* 如果没有则返回 -1（需要区分大小写）.
* */
public class Solution2 {

    public int FirstNotRepeatingChar(String str) {

        HashMap<Character,Integer> hashMap=new LinkedHashMap<>();//特别注意：只有LinkedHashMap是按照插入顺序排序的
        for(int i=0;i<str.length();i++){
            if(hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i),hashMap.get(str.charAt(i))+1);

            }else{
                hashMap.put(str.charAt(i),1);

            }
        }
        for(Map.Entry<Character,Integer> item:hashMap.entrySet()){

            if(item.getValue()==1){

                return  str.indexOf(item.getKey());

            }

        }
        return -1;
    }

    public static void main(String[] args) {

        String str="google";
        Solution2 solution2=new Solution2();
        int result=solution2.FirstNotRepeatingChar(str);
        System.out.println(result);
    }
}
