package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class Test11 {

    public static boolean test(int[][] array,int startX,int startY,int endX,int endY){

        int m=array.length;
        int n=array[0].length;
        Queue<Point> queue=new LinkedList<>();
        queue.add(new Point(startX,startY));

        boolean result=false;

        /*用来标记该点坐标否走过*/
        int[][] book=Arrays.copyOf(array,array.length);
        for(int i=0;i<book.length;i++){
            for(int j=0;j<book[i].length;j++) {

                book[i][j] = 0;
            }
        }
        book[startX][startY]=1;


        /*走动的四个方向*/
        int[][] next=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){

            int x=((LinkedList<Point>) queue).get(0).getX();
            int y=((LinkedList<Point>) queue).get(0).getY();
            for(int i=0;i<4;i++){

                int nextX=x+next[i][0];
                int nextY=x+next[i][1];

                if(nextX>m||nextX<0||nextY>n||nextY<0){

                    continue;
                }
                if(book[nextX][nextY]!=1&&array[nextX][nextY]!=1){//如果该点既没有障碍，也没有走过，则入队列，并且标记
                    queue.add(new Point(nextX,nextY));
                    book[nextX][nextY]=1;

                }
                /*如果到达终点*/
                if(nextX==endX&&nextY==endY){

                    result=true;
                    break;
                }

            }

            if(result){
                break;

            }
            queue.poll();//将已经走过的点坐标出队列


        }
        return  result;

    }
    public static void main(String[] args) {


    }
}
