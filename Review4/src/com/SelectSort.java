package com;


/*选择排序*/
public class SelectSort {
    public static void  sort(int[] array){
        int max=0;
        for(int i=0;i<array.length;i++){

            for(int j=1;j<array.length-i;j++) {
                if (array[j] > array[max]) {

                    max =j;
                }
            }

            int temp=array[array.length-1-i];
            array[array.length-1-i]=array[max];
            array[max]=temp;

        }

    }
    public static void main(String[] args) {
        int[] a=new int[]{1,5,9,11,14,5,0};
        sort(a);
        for(int i=0;i<a.length;i++){

            System.out.print(a[i]+" ");
        }

    }
}
