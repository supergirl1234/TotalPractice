package comm;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * n皇后问题研究的是如何将n个皇后放置在n x n的棋盘上，并且使皇后彼此之间不能相互攻击，
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案
 * 每一种解法包含一个明确的n皇后问题的棋子放置方案，该方案中Q和. 分别代表了皇后和空位
 *
 * */

public class Prince {


    public void dfs(int n, int curRow, ArrayList<Pair<Integer, Integer>> list, ArrayList<ArrayList<Pair<Integer, Integer>>> lists) {


        /*所有行皇后的位置都已经确定，保存这种解决方案*/
        if(curRow==n){

            lists.add(list);
            return;
        }
        /*尝试该行每一列的位置*/
        for (int i=0;i<n;i++){

            /*如果该位置与之前的位置不冲突，当前位置的坐标（x，y）保存*/
            if(isValid(list,curRow,i)){
                list.add(new Pair<>(curRow,i));
                dfs(n,curRow+1,list,lists);

                /*回退*/
                list.remove(list.size()-1);
            }
        }
    }


    private boolean isValid(ArrayList<Pair<Integer,Integer>> list, int curRow, int curCol) {

        /*
        * 不在同一行，同一列、同一斜线上则不冲突
        * */
        for(Pair<Integer,Integer> item:list ){

            int row=item.getKey();
            int col=item.getValue();
            if(col==curCol||(row+col)==(curRow+curCol)||Math.abs(row-col)==Math.abs(curRow-curCol)){

                return  false;
            }

        }
        return  true;
    }

    public ArrayList<ArrayList<String>> solve(int n) {

        ArrayList<Pair<Integer, Integer>> list=new ArrayList<>();
        ArrayList<ArrayList<Pair<Integer, Integer>>> lists=new ArrayList<>();

        dfs(n,0,list,lists);

        ArrayList<ArrayList<String>> result=new ArrayList<>();
        ArrayList<String>  stringList=new ArrayList<>();

        char[][] chars=new char[n][n];
        for(int i=0;i<n;i++){

           for(int j=0;j<n;j++){
               chars[i][j]='.';

           }
        }
        for(ArrayList<Pair<Integer, Integer>> item:lists){
            /*将每一行的皇后的坐标位置改为Q*/
            for(Pair<Integer, Integer> value:item){
               chars[value.getKey()][value.getValue()]='Q';
                stringList.add(Arrays.toString(chars));
            }
            result.add(stringList);
        }

        return  result;

    }

    public static void main(String[] args) {


    }
}
