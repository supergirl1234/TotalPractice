package com;


import java.util.*;

/*
* 广度优先
*
* 给定两个单词（beginWord和endWord）和一个字典，找到从beginWord到endWord的最短转换序列的长度，转换需要遵循如下规则：
* 每次转换只能改变一个字母，转换过程中的中间单词必须是字典中的单词
* beginWord="hit"
* endWord="cog"
* wordList=["hot","dot","dog","lot","cog"]
* 转换过程："hit"->"hot"->"dot"->"dog"->"cog"
*
* */
public class MinNeed {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList){

        Queue<String> queue=new LinkedList<>();//存放每一次转换的结果
        queue.add(beginWord);
        Set<String> set=new HashSet<>();
        set.add(beginWord);//用来保存已经用过的单词；
        int minLength=1;
        while(!queue.isEmpty()){

            /*获取一次转换之后的所有单词*/
            int size=queue.size();
            while (size--!=0){

                String str=queue.poll();
                /*每一个单词一次转换的结果有：str.length() * 26*/
                for(int i=0;i<str.length();i++){

                    char[] tempWord=str.toCharArray();
                    for(char ch='a';ch<='z';ch++){

                        tempWord[i]=ch;
                       /* strOfCopy.replace(strOfCopy.charAt(i),ch).intern();*/

                        /*转换后的单词是否在词典中，且之前没有用过*/
                        if(wordList.contains(new String(tempWord)) &&!set.contains(new String(tempWord))){

                            if(Arrays.equals(tempWord, endWord.toCharArray())){

                                return  minLength+1;
                            }else{

                                queue.add(new String(tempWord));
                                set.add(new String(tempWord));
                            }

                        }
                    }

                }

            }
            minLength++;
        }

        return 0;

    }


    public static void main(String[] args) {
        String beginWord="hit";
        String endWord= "cog";
        Set<String> wordList=new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("cog");
        int result=ladderLength(beginWord,endWord,wordList);
        System.out.println(result);


    }
}
