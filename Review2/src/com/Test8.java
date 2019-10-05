package com;


/*
*
* 背包问题
* 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
问最多能装入背包的总价值是多大?
* */
public class Test8 {

    public static int test(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] result = new int[n+1][m + 1];//用来保存物品存放在大小为i的背包中的总价值
                                             //前i个物品，放在大小为i的包装里，总价值
        for (int i = 0; i < n+1; i++) {

            for(int j=0;j<m+1;j++) {
                result[i][j] = 0;
            }
        }


        for (int i = 1; i <= n; i++) {//i代表第几个物品
            for (int j = 1; j <= m; j++) {//j代表包的大小

                if (A[i - 1] > j) {//装不下

                    result[i][j] = result[i-1][j];
                } else {//装的下

                    int newValue = result[i-1][j - A[i - 1]] + V[i - 1];//如果将该物品装进去，首先需要为该物品腾出来位置
                    result[i][j] = Math.max(result[i-1][j], newValue);//将该物品装进去之后，物品的总价值与该物品不装进去，物品的总价值进行比较；

                }
            }

        }

        return result[n][m];
    }

    public static void main(String[] args) {


        int m = 20;
        int[] A = new int[]{1, 3, 2, 7, 3, 5};
        int[] V = new int[]{5, 7, 2, 10, 7, 3};
        int result = test(m, A, V);
        System.out.println(result);
    }
}
