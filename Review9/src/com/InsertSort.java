package com;


import java.util.Arrays;

/*插入排序*/
public class InsertSort {
    private static void sort1(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int num=i;
            for (int j = i-1;j>=0;j--) {
                if(array[num]<array[j]){

                    int temp=array[num];
                    array[num]=array[j];
                    array[j]=temp;
                    num--;

                }else{

                    break;
                }
            }
        }
    }
    public static void main(String[] args) {


        int[] array=new int[]{9,8,7,6,5,4,3,2,1};
        InsertSort.sort1(array);
        System.out.println(Arrays.toString(array));
    }


}
