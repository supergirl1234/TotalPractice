package com;
import java.util.*;
/*
* 广度优先
* 你有一个带有四个圆形拨轮的转盘锁，每个拨轮都有10个数字，'0'，'1'，'2'，'3'，'4'，'5'，'6'，'7'，'8'，'9'.
* 每个拨轮可以自由旋转,例如把9变为0，0变为9，每次旋转都只能旋转一个拨轮的一位数字。
* 锁的初始数字为0000，一个代表四个拨轮的数字的字符串；
* 列表deadends包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转；
* 字符串target代表可以解锁的数字，你需要给出最小的旋转次数，如果如论如何不能解锁，返回-1；
* */
public class MinRotary {
    public static  int minNum(ArrayList<String> deadends,String target){

        if(deadends.contains("0000")){

            return  -1;
        }
        Queue<String> queue=new LinkedList<>();
        queue.add("0000");
        Set<String> set=new HashSet<>();
        set.add("0000");
        int count=0;
        int size=queue.size();
        while(!queue.isEmpty()){
            while(size-->0){
                String  str= queue.poll();
                for(int i=0;i<4;i++){
                    char[] chars1=str.toCharArray();
                    char[] chars2=str.toCharArray();
                    if(chars1[i]=='0'){

                        chars1[i]='9';
                        chars2[i]='1';
                    }else if(chars1[i]=='9'){

                        chars1[i]='0';
                        chars2[i]='8';
                    }else{
                        chars1[i]=chars1[i]++;
                        chars2[i]=chars2[i]--;

                    }

                    if(!deadends.contains(new String(chars1))&&!set.contains(new String(chars1))){

                        if(new String(chars1).equals(target)) {

                            return count + 1;

                        }
                        queue.add(new String(chars1));
                        set.add(new String(chars1));
                    }
                    if(!deadends.contains(new String(chars2))&&!set.contains(new String(chars2))){

                        if(new String(chars2).equals(target)){

                            return  count+1;
                        }
                        queue.add(new String(chars2));
                        set.add(new String(chars2));
                    }
                }

            }
            count++;

        }

        return  -1;
    }
    public static void main(String[] args) {


    }
}
