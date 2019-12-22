package commm;

/*
* 题目：
* 现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。
*
* */
/*
* 思路：
* 相同两个数异或为0。
* 0异或一个数为那个数本身。
*
* */
public class Solution23 {

    public int singleNumber(int[] A) {

        int num=0;
        for(int i=0;i<A.length;i++){

            num=num^A[i];
        }

        return num;

    }
}
