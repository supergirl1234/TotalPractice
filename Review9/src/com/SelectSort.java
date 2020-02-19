package com;

import java.util.Arrays;

/*选择排序*/
public class SelectSort {

    private static void sort(int[] array){


        for(int i=0;i<array.length;i++){

            int max=0;//数值最大的数的下标
            for(int j=1;j<array.length-i;j++){

                if(array[j]>array[max]){
                    max=j;
                }

            }
            int temp=array[array.length-1-i];
            array[array.length-1-i]=array[max];
            array[max]=temp;

        }
    }

    public static void main(String[] args) {

        int[] array=new int[]{9,8,7,6,5,4,3,2,1};
        SelectSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
