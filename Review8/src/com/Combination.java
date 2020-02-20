package com;

import java.util.ArrayList;

/*
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使candidates中所有数字和为target的组合
 * candidates中的数字可以无限制重复被选取
 *
 *
 * */
public class Combination {

    /*
     *
     *
     * */
    public static  void dfs2(int target,int curTarget,int index, ArrayList<Integer> candidates,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> lists) {


        if(curTarget>=target){

            if(curTarget==target){
                ArrayList<Integer> newList=new ArrayList<>(list);
                lists.add(newList);

            }
            return ;
        }

        for(int i=index;i<candidates.size();i++){
            list.add(candidates.get(i));
            dfs2(target,curTarget+candidates.get(i),i+1,candidates,list,lists);
            /*回退*/
            list.remove(list.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> test(int target, ArrayList<Integer> candidates) {


        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        dfs2(target,0, 0,candidates,list, lists);
         return  lists;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> candidates=new ArrayList<>();
        candidates.add(1);
        candidates.add(2);
        candidates.add(3);
        candidates.add(4);
        candidates.add(5);
        candidates.add(6);
        candidates.add(7);

        lists=Combination.test(8,candidates);
        System.out.println(lists);
    }
}
