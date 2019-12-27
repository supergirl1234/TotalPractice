package commm;
import java.util.ArrayList;
import java.util.Arrays;

/*
*现在有一个没有重复元素的整数集合S，求S的所有子集
注意：
你给出的子集中的元素必须按非递增的顺序排列
给出的解集中不能出现重复的元素
例如：
如果S=[1,2,3], 给出的解集应为：
[↵  [3],↵  [1],↵  [2],↵  [1,2,3],↵  [1,3],↵  [2,3],↵  [1,2],↵  []↵]

*
* */

//该题与Solution38的方法一样，唯一不一样的地方在于：38中给出的集合中有重复的数字，在求取子集的时候，要注意去除重复的子集
/*
 * 思路：回溯法
 *
 * */
public class Solution382 {

    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {

        Arrays.sort(num);
        for(int i=0;i<=num.length;i++){
            ArrayList<Integer> list=new ArrayList<>();
            search(num,i,0,list);
        }
        return  result;
    }

    /*
     * numOfjihe：子集的个数
     * start：从数组的第几个数开始查找
     * */

    private void search(int[] num, int numOfjihe, int start, ArrayList<Integer> list) {

        if(numOfjihe<0){
            return;
        }else if (numOfjihe==0){

            result.add(new ArrayList<>(list));
        }else {


            for(int i=start;i<num.length;i++){

                list.add(num[i]);
                search(num,numOfjihe-1,i+1,list);
                list.remove(list.size()-1);

            }
        }

    }

    public static void main(String[] args) {
        int[] num=new int[]{2,3,5,7,1,2};
        Solution38 solution38=new Solution38();
        ArrayList<ArrayList<Integer>> result=solution38.subsetsWithDup(num);
        System.out.println(result);
    }

}
