package comm;


/*
* 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。

给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
若没有金额超过总数的一半，返回0。
* */

//思路：数据可能有不存在超过红包一半的，这个时候就要输出0；即该金额的数目必须 大于 红包数一半，不能小于
//等于。
//如果一个数出现次数超过一半了，排序过后，必然排在中间，则最后遍历整个排序后的数组查看是否符合条
//件。

import java.util.Arrays;

public class Test22 {


    public static int test(int[] array, int n) {

        Arrays.sort(array);
        int num = array[n / 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) {
                count++;
            }

        }
        if (count >= n / 2) {
            return num;

        } else {

            return 0;
        }

    }

    public static int test2(int[] array, int n) {

        int count=0;
        int temp=0;
        for(int i=0;i<n;i++){

            if(count==0){

                temp=array[i];
                count=1;
            }else if(temp==array[i]){
                count++;

            }else{

                count--;
            }

        }

        int size=0;
        for(int i=0;i<n;i++){

            if(array[i]==temp){
                size++;

            }

        }
        if (size >= n / 2) {
            return temp;

        } else {

            return 0;
        }


    }

    public static void main(String[] args) {

        int[] array = new int[]{7, 5, 7, 3, 7, 21, 5, 7, 5, 7,};
        int result = test(array, array.length);
        System.out.println(result);
    }
}
