package com;


/*
*
* 给定两个字符串S和T，求S有多少个不同的子串与T相同。
S的子串定义为在S中任意去掉0个或者多个字符形成的串。
子串可以不连续，但是相对位置不能变。
比如“ACE”是“ABCDE”的子串，但是“AEC”不是。
问题翻译：S有多少个不同的子串与T相同
S[1:m]中的子串与T[1:n]相同的个数
由S的前m个字符组成的子串与T的前n个字符相同的个数
* */


/*
* 思路：我们需要一个二维数组dp(i)(j)来记录长度为i的字串在长度为j的母串中出现的次数，这里长度都是从头算起的，
* 而且遍历时，保持子串长度相同，先递增母串长度，母串最长时再增加一点子串长度重头开始计算母串。
 * 首先我们先要初始化矩阵，当子串长度为0时，所有次数都是1，当母串长度为0时，所有次数都是0.当母串子串都是0长度时，次数是1（因为都是空，相等）。
 * 接着，如果子串的最后一个字母和母串的最后一个字母不同，说明新加的母串字母没有产生新的可能性，可以沿用该子串在较短母串的出现次数，所以dp(i)(j) = dp(i)(j-1)。
 * 如果子串的最后一个字母和母串的最后一个字母相同，说明新加的母串字母带来了新的可能性，我们不仅算上dp(i)(j-1)，也要算上新的可能性。
 * 那么如何计算新的可能性呢，其实就是在既没有最后这个母串字母也没有最后这个子串字母时，子串出现的次数，我们相当于为所有这些可能性都添加一个新的可能。所以，这时dp(i)(j) = dp(i)(j-1) + dp(i-1)(j-1)。
* 计算元素值时，当末尾字母一样，实际上是左方数字加左上方数字，当不一样时，就是左方的数字。
*
*
*
* */
public class Test10 {

    public static  int test(String T,String S){//T是子串，S是母串


        int m=T.length();
        int n=S.length();
        if(m>n){
            return  0;

        }
        int[][] result=new int[m+1][n+1];
        //初始化：当子串长度为0时，所有次数都是1，当母串长度为0时，所有次数都是0.当母串子串都是0长度时，次数是1
        for(int i=0;i<m+1;i++){

            result[i][0]=0;//每一行的第0列
        }
        for(int i=0;i<n+1;i++){

            result[0][i]=1;//每一列的第0行
        }

        for(int i=1;i<m+1;i++){
           for(int j=1;j<n+1;j++){


               if(T.charAt(i-1)==S.charAt(j-1)){

                   result[i][j]=result[i][j-1]+result[i-1][j-1];

               }else{

                   result[i][j]=result[i][j-1];
               }
           }

        }

        return result[m][n];

    }
    public static void main(String[] args) {

        String S="rabit";
        String T="rabbbit";
        int result=test(S,T);
        System.out.println(result);
    }
}
