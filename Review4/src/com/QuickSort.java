package com;


/*快速排序*/
public class QuickSort {

    public static void  sort(int[] array){

      sortInner(array,0,array.length);
    }

    public static void sortInner(int[] array,int left,int right){  /*左闭右开*/

        if(left==right){

            return;
        }

       int part=partion(array,left,right);
       sortInner(array,left,part);
       sortInner(array,part+1,right);

    }

    public static  int partion(int[] array,int left,int right){

        int p=left;
        int q=right-1-1;
        while (p<q){

            while(p<q&&array[p]<array[right-1]){
                p++;

            }

            while(p<q&&array[q]>=array[right-1]){
                q--;

            }

            Swap.swap(array,p,q);
        }

        Swap.swap(array,p,right-1);
        return  p;

    }
    public static void main(String[] args) {
        int[] a=new int[]{1,5,9,11,14,5,0};
        sort(a);
        for(int i=0;i<a.length;i++){

            System.out.print(a[i]+" ");
        }
    }
}
