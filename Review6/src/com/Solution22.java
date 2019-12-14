package com;


/*
 * 题目：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * */
public class Solution22 {

    //仿照hash表实现，str存储插入的字符，hash[256]存储插入字符的个数.一个字符占8位，因此不会超过256个

    int[] hash = new int[256];
    StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        hash[ch]++;

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {

            if (hash[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }
        return '#';

    }


    public static void main(String[] args) {


    }
}
