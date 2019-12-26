package commm;


/*
* 题目：
* 给出三个字符串s1, s2, s3,判断s3是否可以由s1和s2交织而成。
例如：
给定
s1 ="aabcc",
s2 ="dbbca",
如果s3 ="aadbbcbcac", 返回true
如果s3 ="aadbbbaccc", 返回false

*
* */

/*
*
* 思路：
* 动态规划

s3是由s1和s2交织生成的，意味着s3由s1和s2组成，在s3中s1和s2字符的顺序是不能变化的，和子序列题型类似，这种题我们一般是用动态规划来解。

设dp[i][j]表示s3的前i+j个字符可以由s1的前i个字符和s2的前j个字符交织而成。
状态转移方程：有两种情况
第一个状态转移方程：
dp[i][j]= {(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)}
dp[i-1][j]表示若s3的前i+j-1个字符能够由s1前i-1个字符和s2的前j个字符交织而成，那么只需要s1的第i个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true;
第二个状态转移方程：
dp[i][j]= {(dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)}
dp[i-1][j]表示若s3的前i+j-1个字符能够由s1前i个字符和s2的前j-1个字符交织而成，那么只需要s2的第j个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true;

*
* */
public class Solution36 {

    public boolean isInterleave(String s1, String s2, String s3) {

        int length1=s1.length();
        int length2=s2.length();
        int length3=s3.length();

        if(length1+length2!=length3){

            return  false;
        }

        boolean[][] result=new boolean[length1+1][length2+1];
        result[0][0]=true;
        for(int i=1;i<length2+1;i++){

            result[0][i]=result[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        for(int i=1;i<length1+1;i++){

            result[i][0]=result[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for(int i=1;i<length1+1;i++){

            for(int j=1;j<length2+1;j++){

                result[i][j]=result[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1))
                            ||result[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1));
            }

        }

        return  result[length1][length2];

    }

    public static void main(String[] args) {

        String s1="a";
        String s2="";
        String s3="a";
        Solution36 solution36=new Solution36();
        boolean result=solution36.isInterleave(s1,s2,s3);
        System.out.println(result);
    }

}
