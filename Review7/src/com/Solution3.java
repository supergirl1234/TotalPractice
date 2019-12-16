package com;


/*
 * 题目：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 *
 * */
public class Solution3 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        int[][] flag = new int[rows][cols];//用来标记每个字符的位置是否已经走过，1代表已经走过该位置

         for(int i=0;i<rows;i++){

             for(int j=0;j<cols;j++){
                 flag[i][j]=0;

             }
         }
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的
                if( hasPathInner(matrix, flag, i, j, rows, cols, str, 0)){//这个k代表str的第几个字符
                    return  true;

                }

            }
        }
        return false;
    }

    boolean hasPathInner(char[] matrix, int[][] flag, int startX, int startY, int rows, int cols, char[] str, int k) {


        int index = startX * cols + startY;  //计算二维数组的下标在一维数组中的位置
        if (k == str.length) {  //说明前面都匹配成功了
            return true;

        }

        if (startX < 0 || startY < 0 || startX  >=rows || startY >= cols) {

            return false;
        }



        if (matrix[index] == str[k] && flag[startX][startY] != 1) {

            flag[startX][startY] = 1;
            if( hasPathInner(matrix, flag, startX - 1, startY, rows, cols, str, k + 1) ||
                    hasPathInner(matrix, flag, startX + 1, startY, rows, cols, str, k + 1) ||
                    hasPathInner(matrix, flag, startX, startY - 1, rows, cols, str, k + 1) ||
                    hasPathInner(matrix, flag, startX, startY + 1, rows, cols, str, k + 1)){


                return  true;
            }else {

                //那就说明这个位置不符合，不是从这个位置开始的，再将其还原
                flag[startX][startY] = 0;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        Solution3 solution3=new Solution3();
        char[] matrix=new char[]{'A','A','A','A','A','A','A','A','A','A','A','A'};
        char[]  str=new char[]{'A','A','A','A','A','A','A','A','A','A','A','A'};
        boolean result=solution3.hasPath(matrix,3,4,str);
        System.out.println(result);
    }
}
