package com;


/*冒泡排序*/
public class BubbleSort {

   public static void sort(int[] array){

       for(int i=0;i<array.length-1;i++){

           for( int j=0;j<array.length-1;j++){

               if(array[j]>array[j+1]){
                   Swap.swap(array,j,j+1);

               }

           }
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


