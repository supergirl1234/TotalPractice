package comm;


/*
* 题目：
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*
* */
public class Solution2 {

    public String replaceSpace(StringBuffer str) {

      int num=-1;
      while((num=str.indexOf(" "))!=-1) {
          str.replace(num,num+1, "%20");
      }
      return  str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str=new StringBuffer(" 7hello world ht ");
        Solution2 solution2=new Solution2();
        String result=solution2.replaceSpace(str);
        System.out.println(result);


    }
}
