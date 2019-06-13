package comTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/10 0010
 *
 * 找出红包中，红包金额出现次数超过红包总数一半的红包金额，如果没有，则返回0
 */
public class Gift {

    public int getValue(int[] gifts, int n) {

        int finalResult=0;

        for(int i=0;i<gifts.length;i++){

            int count=0;
            int result=gifts[i];
            for(int j=0;j<gifts.length;j++){


                if(gifts[j]==result){
                    count++;

                }
            }
            if(count>n/2){
                finalResult=result;
                break;

            }
        }


        return finalResult;

    }

    public static void main(String[] args) {


        Gift p=new Gift();
        System.out.println("请输入红包金额以及红包个数");
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
