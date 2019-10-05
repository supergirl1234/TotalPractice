package com;


/*给定一个数组，求出其最大连续子序列的和*/
public class Test1 {

    public static  int test(int[] array){

         int sum=0;
         int maxSum=0;
         for(int i=0;i<array.length;i++){

             if(sum>=0){  //如果该数前面的数的和是大于0的，才能起到使和增大的作用

                 sum+=array[i];
             }else{
                 sum=array[i];
             }

             if(sum>maxSum){
                 maxSum=sum;

             }

         }

        return maxSum;
    }

    public static void main(String[] args) {

          int[] array=new int[]{6,-3,-2,7,-15,1,2,2};
         int result=test(array);
        System.out.println(result);
    }
}
