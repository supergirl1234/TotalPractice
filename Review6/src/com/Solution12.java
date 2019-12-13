package com;

/*
 * 题目：
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * */
public class Solution12 {

    public String ReverseSentence(String str) {


        /*因为有字符串在开头与末尾有空格的问题，所以采用方法，先反转整个句子，再反转每个单词*/

        char[] chars = str.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {

            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;

        }

//        然后反转每个单词

        begin = 0;
        end = 0;
        while (begin < chars.length && end < chars.length) {
            if (chars[begin] == ' ') {
                begin++;
                end++;

            } else if (chars[end] == ' ') {
                for (int i = begin, j = end-1; i < j; i++, j--) {

                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }

                begin = end+1;


            } else if(end==chars.length-1) {
                for (int i = begin, j = end; i < j; i++, j--) {

                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }

                begin = end+1;
            } else if (chars[end] != ' ') {
                end++;

            }


        }

        return new String(chars);


    }

    public static void main(String[] args) {
        Solution12 solution12=new Solution12();

        String str = "I am a student";
        String newStr=solution12.ReverseSentence(str);
        System.out.println(newStr);

    }
}
