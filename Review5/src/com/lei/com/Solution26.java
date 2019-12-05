package com.lei.com;

import java.util.ArrayList;

import java.util.Comparator;

/*
* 题目：
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba,按大小顺序打印。
*
* 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
* */
public class Solution26 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        if(str.length()==0){
            return list;

        }
        if(str.length()==1){

            list.add(str);
            return  list;
        }

        /*先拿出一个字符，先求出剩余字符的排列组合，然后将这个字符插在剩余字符的排列组合中*/
        ArrayList<String> preList=Permutation(str.substring(1,str.length()));
        for(String item:preList){

            for(int i=0;i<=item.length();i++){
                StringBuffer sb=new StringBuffer(item);
                sb.insert(i,str.substring(0,1));
                String st=sb.toString();
                if(!list.contains(st)){

                    list.add(st);
                }
            }



        }

         list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int i=0;
                int length=o1.length();
              while(i<length){

                  if(o1.charAt(i)!=o2.charAt(i)){
                      return o1.charAt(i)-o2.charAt(i);

                  }else{

                      i++;
                  }
              }
              return  0;
            }
        });

        return  list;
    }

    public static void main(String[] args) {
        String str="abc";
        Solution26 solution26=new Solution26();
       ArrayList<String> list= solution26.Permutation(str);
       for(String item:list){

           System.out.println(item);
       }
    }
}
