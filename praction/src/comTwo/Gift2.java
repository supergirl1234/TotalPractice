package comTwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/13 0013
 *
 * 找出红包中，红包金额出现次数超过红包总数一半的红包金额，如果没有，则返回0
 */

//解题思路是：如果一个数出现次数超过一半了，排序过后，该数肯定会出现在中间
public class Gift2 {


    public int getValue(int[] gifts,int n){

        Arrays.sort(gifts);//数组排序
        int ans=gifts[n/2];//理论上超过半数的数字
        int num=0;
        //遍历数组，进行统计
        for(int i=0;i<gifts.length;i++){

            if(gifts[i]==ans){

                num++;
            }
        }

        return num<=n/2?0:ans;

    }

    public int getValue2(int[] gifts,int n){

     return 0;

    }

    public static void main(String[] args) {
        Gift p=new Gift();
        System.out.println("请输入红包个数以及红包金额");
        Scanner in=new Scanner(System.in);
        while (in.hasNext()) {
            int n=in.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){

                array[i]=in.nextInt();
            }

            int result=p.getValue(array,n);
            System.out.println(result);

        }

    }
}
