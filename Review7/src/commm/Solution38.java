package commm;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 题目L给出一个可能包含重复元素的整数集合S，返回该整数集合的所有子集。
注意：
你给出的子集中的元素要按非递增的顺序排列
给出的解集中不能包含重复的子集
例如：
如果S =[1,2,2], 给出的解集应该是：
[↵  [2],↵  [1],↵  [1,2,2],↵  [2,2],↵  [1,2],↵  []↵]
*
* */

/*
* 思路：回溯法
*
* 重点
*
* */
public class Solution38 {

    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

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
                if(i>start&&num[i]==num[i-1]){

                    continue;  //遇到相同的数字就跳过
                }
                list.add(num[i]);
                search(num,numOfjihe-1,i+1,list);
                list.remove(list.size()-1);

            }
        }

    }


    ArrayList<ArrayList<Integer>> listAll=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        if (num == null || num.length <= 0)
            return listAll;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);

        Findsubset(num, 0, list);

        return listAll;
    }

    public void Findsubset(int[] set, int start, ArrayList<Integer> list) {
        listAll.add(new ArrayList<>(list));

        for (int i = start; i < set.length; i++) {
            if (i > start && set[i] == set[i - 1])
                continue;
            list.add(set[i]);
            Findsubset(set, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] num=new int[]{2,3,5,7,1,2};
        Solution38 solution38=new Solution38();
        ArrayList<ArrayList<Integer>> result=solution38.subsetsWithDup(num);
        System.out.println(result);
    }

}
