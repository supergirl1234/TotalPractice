package comm;




import java.util.HashMap;
import java.util.Map;

/*
* 题目：
* 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
假设给出的数组中只存在唯一解
例如：
给出的数组为 {2, 7, 11, 15},目标值为9
输出 ndex1=1, index2=2
*
* */


public class Solution14 {

    public int[] twoSum(int[] numbers, int target) {

        /*不能使用哈希表来存放numbers里的每个数值，因为numbers中的数可能有重复的*/

        /*在这里的思路是：在hashMap中存放target-numbers[i]的值，然后遍历数组，如果数组中某个数载hashMap中存放的有，那就说明，我们找到了这两个数*/
         int[] result=new int[2];//存放结果

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){

            if(map.containsKey(numbers[i])){

                /*因为下表是从1开始的，所以要加1*/

                result[0]=map.get(numbers[i])+1;
                result[1]=i+1;
            }else{
               int sub=target-numbers[i];
               map.put(sub,i);//这里面存的是差值，以及原来的数的下标

            }

        }
        return  result;
    }

    public static void main(String[] args) {

        int[] numbers=new int[]{3,2,4};
        Solution14 solution14=new Solution14();
        int[] result=solution14.twoSum(numbers,6);
        System.out.println(result[0]+"  "+result[1]);
    }
}
