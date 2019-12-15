package com;


/*
* 题目：
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
* 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
* */


/*
* 思路：
* 使用归并排序的思路
* */
public class Solution3 {

    int count=0;
    public int InversePairs(int [] array) {

        GuiBing(array,0,array.length-1);

        return count;

    }

    private void GuiBing(int[] array, int left, int right) { //左闭右闭
        if(left>=right){
            return;

        }
        int medium=(right+left)/2;
        GuiBing(array,left,medium);
        GuiBing(array,medium+1,right);
        merge(array,left,medium,right);
    }

    public void merge(int[] array,int left,int medium,int right){

        int[] extra=new int[right-left+1];

        int p=left;
        int q=medium+1;
        int i=0;
        while(p<=medium && q<=right){

            if(array[p]<=array[q]){
                extra[i++]=array[p++];

            }else{
                extra[i++]=array[q++];
                count=(count+(medium-p+1))%1000000007;
            }
        }

        while (p<=medium){

            extra[i++]=array[p++];
        }
        while (q<=right){

            extra[i++]=array[q++];
        }

        for(int k=0;k<extra.length;k++){

            array[k+left]=extra[k];

        }

    }



    public static void main(String[] args) {

    }
}
