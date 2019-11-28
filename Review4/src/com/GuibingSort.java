package com;


/*归并排序*/
public class GuibingSort {
    public static void  sort(int[] array){

        SortInner(array,0,array.length);
    }

    private static void SortInner(int[] array, int left, int right) {/*左闭右开*/
        if(left==right){

           return;
        }
        if(left+1==right){
            return;

        }
        int medium=(left+right)/2;
        SortInner(array,left,medium);
        SortInner(array,medium,right);

        merge(array,left,medium,right);

    }

    private static void merge(int[] array, int left,int medium, int right) {
       int[] extra=new int[right-left];
       int p=left;
       int q=medium;
       int i=0;
       while(p<medium&&q<right){
           if(array[p]<=array[q]){
               extra[i++]=array[p++];

           }
           if(array[q]<array[p]){

               extra[i++]=array[q++];
           }

       }
       while (p<medium){
           extra[i++]=array[p++];
       }
        while (q<right){
            extra[i++]=array[q++];
        }
        for(int j=0;j<extra.length;j++){

           array[j+left]=extra[j];
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
