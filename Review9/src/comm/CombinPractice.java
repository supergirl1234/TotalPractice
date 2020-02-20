package comm;

/*
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使candidates中所有数字和为target的组合
 * candidates中的数字可以无限制重复被选取
 *
 * 深度优先
 * */

import java.util.ArrayList;

public class CombinPractice {

    public static ArrayList<ArrayList<Integer>> lookFor(int[] candidates,int target){

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();

            dfs(candidates, target, 0, 0, list, lists);

        return  lists;
    }
    private static void dfs(int[] candidates, int target, int curTarget, int curIndex, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if(curTarget>=target){
            if(curTarget==target){
                ArrayList<Integer> newList=new ArrayList<>(list);
                lists.add(newList);
            }
            return;
        }
        for(int i=curIndex;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,target,curTarget+candidates[i],i+1,list,lists);
            /*回退*/
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        int[] candidates=new int[]{1,2,3,4,5,6,7};
        lists=CombinPractice.lookFor(candidates,8);
        System.out.println(lists);
    }
}
