package commm;


/*
* 题目：
* 判断题目给出的字符串是不是回文，仅考虑字符串中的字母字符和数字字符，并且忽略大小写
例如："A man, a plan, a canal: Panama"是回文
"race a car"不是回文
注意：
你有没有考虑过字符串可能为空？这是面试时应该提出的一个好问题。
针对这个问题，我们定义空字符串是回文
*
*
* */
public class Solution27 {

    public boolean isPalindrome(String s) {


        if(s==null ||s.length()==0|| s.equals(" ")){

            return  true;
        }
        int  length=s.length();

        s=s.toLowerCase();

        int i=0;
        int j=length-1;
        while(i<j){
            while(i<j&&!((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9') )){

                i++;
            }
            while(i<j&&!((s.charAt(j)>='a'&&s.charAt(j)<='z')||(s.charAt(j)>='0'&&s.charAt(j)<='9'))){

                j--;
            }

            if(i<j && s.charAt(i) != s.charAt(j)) {

                return false;

            }
            i++;
            j--;

        }

        return  true;
    }
}
