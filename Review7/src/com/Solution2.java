package com;


import java.util.ArrayList;
import java.util.LinkedList;


/*
* 题目：
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
* 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
* 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
  * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
  * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
   * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*
* */
public class Solution2 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(size<=0){

            return list;
        }

        LinkedList<Integer> indexDeque = new LinkedList<>();//用来存储最大值的下标
        int i=0;

        for(;i<size-1;i++){
            while(!indexDeque.isEmpty() && num[i]>num[indexDeque.peekLast()]){

                indexDeque.removeLast();

            }
            indexDeque.addLast(i);

        }
       while(i<num.length) {
             while(!indexDeque.isEmpty() && num[i]>num[indexDeque.peekLast()]){

                 indexDeque.removeLast();

             }
             indexDeque.addLast(i);


             /*说明前面的大值过期了*/
             if(i-indexDeque.peekFirst()>=size){

                 indexDeque.pollFirst();

             }

             list.add(num[indexDeque.getFirst()]);


             i++;
       }


        return  list;
    }


}
