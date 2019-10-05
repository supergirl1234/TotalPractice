package com;


/*
* 在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动，
机器人试图到达网格的右下角，有多少可能的路径。
* */
public class Test2 {

      public static int test(int m,int n){

        int[][] array=new int[m][n];//用来存放（0,0）处到该点的路径条数
        for(int i=0;i<m;i++){//第0行

            array[i][0]=1;
        }
          for(int i=0;i<n;i++){//第0列

              array[0][i]=1;
          }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){

                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }

        return array[m-1][n-1];

      }


      /*递归*/
    public static int test2(int m,int n){


          if(m==1||n==1){
              return 1;

          }
          return test2(m-1,n)+test2(m,n-1);
    }
    public static void main(String[] args) {
        int result=test(4,4);
        System.out.println(result);
        int result2=test2(4,4);
        System.out.println(result2);
    }
}
