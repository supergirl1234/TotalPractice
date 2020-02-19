package com;

import java.util.Arrays;

/*
* 归并排序
* */
public class GuibingSort {

    public static void sort(int[] array){

        guibingSort(array,0,array.length-1);


    }

    private static void guibingSort(int[] array, int left, int right) {

        if(left==right){
            return;
        }
        if(left-1==right){
            return;
        }
        int medium=(left+right)/2;
        guibingSort(array,left,medium);
        guibingSort(array,medium+1,right);

        merge(array,left,medium,right);

    }

    private static void merge(int[] array, int left, int medium, int right) {

        int[] extra=new int[right-left+1];
        int p=left;
        int q=medium+1;
        int i=0;
        while(p<=medium&&q<=right){
            if(array[p]<array[q]){

                extra[i++]=array[p++];
            }
            if(array[q]<array[p]){

                extra[i++]=array[q++];
            }

        }
        while(p<=medium){
            extra[i++]=array[p++];

        }
        while(q<=right){
            extra[i++]=array[q++];

        }

        for(int k=0;k<extra.length;k++){

            array[left++]=extra[k];
        }
    }


    public static void main(String[] args) {

        int[] array=new int[]{9,8,7,6,5,4,3,2,1};
        GuibingSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
