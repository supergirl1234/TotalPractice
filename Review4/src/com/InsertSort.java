package com;


/*插入排序*/
public class InsertSort {


    public static void  sort(int[] array){

        for(int i=1;i<array.length;i++){
            int temp=array[i];
            int k=i-1;
            for(;k>=0;k--){
                if(temp>array[k]){
                    break;

                }

            }
            for(int j=i-1;j>k;j--){
                array[j+1]=array[j];

            }
            array[k+1]=temp;


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
