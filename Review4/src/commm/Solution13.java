package commm;


import java.util.Arrays;

/*
* 题目：
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*
*
* */
public class Solution13 {


    /*
    * 对于每一个数的左边的数组，都已经满足了：奇数位于数组的前半部分，所有的偶数位于数组的后半部
    * */

    /*这个代码在牛客上不通过但思路是对的，且正确*/
    public static void reOrderArray(int [] array) {
        if(array==null || array.length ==0){
            return ;
        }
        for(int i=0;i<array.length;i++){

                if(array[i]%2!=0){  /*奇数*/
                    int temp=array[i];  //保存该值
                    int j=i-1;
                    while(j>=0){

                        if(array[j]%2!=0){  /*找到了左边的最右边的奇数*/
                            for(int k=i-1;k>j;k--){
                                array[k+1]=array[k];
                            }
                            break;
                        }else {
                            j--;
                        }
                    }

                    array[j+1]=temp;
                }

        }
    }
    public static void reOrderArray2(int [] array) {

        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){  /*奇数*/
                int temp=array[i];  //保存该值
                int j=i-1;
                while(j>=0){
                    /*在牛客上，这个判断必须放在前面，否则不通过*/
                    if(array[j]%2!=0){

                        break;
                    }
                    if(array[j]%2==0){  /*找到了左边的最右边的奇数*/
                       int  dev=array[j+1];
                        array[j+1]=array[j];
                         array[j]=dev;
                        j--;
                    }


                }

                array[j+1]=temp;
            }
        }
    }
    public static void reOrderArray3(int [] array) {


        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            if (array[i] % 2 != 0) {
                while (j >= 0) {
                    if (array[j] % 2 != 0) {
                        break;
                    }
                    if (array[j] % 2 == 0) {
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {


        int[] array=new int[]{7,8,3,8,5,6,11,13};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));
    }
}
