package com;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author:Fanleilei
 * Created:2019/6/13 0013
 *
 * 从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 *  例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
 *
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
 *
 * 输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
 */
public class ACGTD2 {


    public static int fun(String str){

        for(int i=1;i<=str.length();i++){

            Set<String> set=new TreeSet<>();
            for(int j=0;j<str.length()-i;j++){

                set.add(str.substring(j,j+i));
            }
            if(set.size()<Math.pow(4,i)){

                return i;
            }
        }
        return 1;
    }



    public static void main(String[] args) {


    }


}
