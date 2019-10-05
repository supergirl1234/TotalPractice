package com;


/*
在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动，
如果在图中加入了一些障碍，障碍物用表示
机器人试图到达网格的右下角，有多少可能的路径。
* */
public class Test5 {


    public static int test(int[][] array){


        int[][] result=new int[array.length][array[0].length];

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array[i].length;j++){
                result[i][j]=0;  //先把存放从[0][0]到该点的路径条数初始化为0

            }
        }
        /*先考虑第0行、第0列*/
        for(int i=0;i<array.length;i++){

                if(array[i][0]==1){
                    break;  //如果第0列上某一行有障碍物了，则第0列中，这一行下面的都不能通过了

                }else{

                    result[i][0]=1;
                }

        }
        for(int i=0;i<array[0].length;i++){

            if(array[0][i]==1){
               break; //如果第0行上某一列有障碍物了，则第0行中，这一列后面的都不能通过了

            }else{

                result[0][i]=1;
            }

        }

        for(int i=1;i<array.length;i++){

            for(int j=1;j<array[i].length;j++){

                if(array[i][j]==1){//如果该点处有障碍物，则到达该点的路径为0

                    result[i][j]=0;
                }else{

                    result[i][j]=result[i-1][j]+result[i][j-1];
                }
            }

        }

        return result[result.length-1][result[0].length-1];

    }
    public static void main(String[] args) {

        int[][] array=new int[4][4];
        array[2][1]=1;
        int result=test(array);
        System.out.println(result);

    }
}
