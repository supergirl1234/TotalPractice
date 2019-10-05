package com;


/*
* 给定两个单词word1和word2，找到最小的修改步数，把word1转换成word2
每一个操作记为一步
允许在一个word上进行如下3种操作：
a) 插入一个字符
b) 删除一个字符
c) 替换一个字符

编辑距离（Edit Distance）：
是指两个字串之间,由一个转成另一个所需的最少编辑操作次数
* */
public class Test9 {

    public  static  int test(String word1,String word2){


        int m=word1.length();
        int n=word2.length();
        if(m==0||n==0){

            return Math.max(m,n);
        }
        int[][] result=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            result[i][0]=i;

        }
        for(int i=0;i<n+1;i++){
            result[0][i]=i;

        }

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    result[i][j]=1+Math.min(result[i-1][j],result[i][j-1]);
                    result[i][j]=Math.min(result[i][j],result[i-1][j-1]);

                }else{

                    result[i][j]=1+Math.min(result[i-1][j],result[i][j-1]);
                    result[i][j]=Math.min(result[i][j],1+result[i-1][j-1]);
                }

            }
        }

        return  result[m][n];

    }
    public static void main(String[] args) {

        String word1="htewrq";
        String word2="htdwwq";
        int result=test(word1,word2);
        System.out.println(result);
    }
}
