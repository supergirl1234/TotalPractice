package comm;

/*
* 题目：
* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
*
*
* 思路：从左下角的值进行判断，因为左下角的值是这一列的最大值，是这一行的最小值，如果target<该值，则往上走，如果targe>该值，则往右走；
*
* 还有一种思路：从右上角1判断，原理同上
* */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        for(int i=row-1, j=0;i>=0&&j<col;){
            if(target==array[i][j]){

                return true;
            } else if(target<array[i][j]){
                i--;

            } else if(target>array[i][j]){
                j++;

            }


        }
        return  false;

    }

    public static void main(String[] args) {

         int[][] array=new int[][]{
                 {1,2,3,4,5},
                 {6,7,8,9,10},
                 {8,10,11,13,15},
                 {22,23,30,35,40}
         };

         int target=8;
         Solution solution=new Solution();
        boolean result=solution.Find(target,array);
        System.out.println(result);

    }
}