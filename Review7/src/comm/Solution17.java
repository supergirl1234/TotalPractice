package comm;


import java.util.ArrayList;
import java.util.Arrays;

/*
* 题目：
* 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
*三元组（a、b、c、d）中的元素必须按非降序排列。（即a≤b≤c）
解集中不能包含重复的四元组。
* */
public class Solution17 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>>  list=new ArrayList<>();

        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){

            if(i!=0&&num[i]==num[i-1]){

                continue;
            }

            int left=i+1;
            int right=num.length-1;

            while(left<right){

                int sum=num[left]+num[right];
                if(sum+num[i]==0){
                    ArrayList<Integer> list1=new ArrayList<>();
                    list1.add(num[i]);
                    list1.add(num[left]);
                    list1.add(num[right]);
                    list.add(list1);

                    left++;
                    right--;

                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }

                }else if(sum+num[i]<0){

                    left++;
                }else{

                    right--;
                }

            }
        }
        return  list;

    }


}
