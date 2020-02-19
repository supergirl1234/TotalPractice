package com;


import java.util.Arrays;

/*冒泡排序*/
public class BubbleSort {

    private static void sort(int[] array){

         for(int i=0;i<array.length;i++){
             for(int j=0;j<array.length-i-1;j++){
                 if(array[j]>array[j+1]){

                     int temp=array[j];
                     array[j]=array[j+1];
                     array[j+1]=temp;

                 }

             }

         }

     }

    public static void main(String[] args) {

         int[] array=new int[]{9,8,7,6,5,4,3,2,1};
         BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
