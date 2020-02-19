package com;


import java.util.Arrays;

/*
* 快速排序
* */
public class FastSort {

    private static void sort(int[] array) {

        sortInner(array,0,array.length-1);//左闭右闭
    }

    private static void sortInner(int[] array, int left, int right) {

        if(left<0||right>array.length-1||right<0){
            return;
        }

        if(left>=right){

            return;
        }
        int obj=array[right];//基准值
        int start=left;
        int end=right;
        while(start<end){

            while(array[start]<obj&&start<end){
                start++;

            }
            while(array[end]>=obj&&start<end){
                end--;

            }
            int temp=array[start];
            array[start]=array[end];
            array[end]=temp;
        }
        int temp=array[start];
        array[start]=array[right];
        array[right]=temp;

        sortInner(array,left,start-1);
        sortInner(array,start+1,right);
    }

    public static void main(String[] args) {
        int[] array=new int[]{9,8,7,6,5,4,3,2,1};
        FastSort.sort(array);
        System.out.println(Arrays.toString(array));
    }



}
