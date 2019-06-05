package comTwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/5 0005
 *
 * 编写一个函数，函数内不使用任何临时变量，直接交换两个数的值
 */
public class Swap {


    public static int[] swap(int[] arr) {

      arr[0]=arr[0]+arr[1];
      arr[1]=arr[0]-arr[1];
      arr[0]=arr[0]-arr[1];

       return arr;

    }

    public static int[] swap2(int[] arr) {

        arr[0]=arr[0]^arr[1];
        arr[1]=arr[0]^arr[1];
        arr[0]=arr[0]^arr[1];

        return arr;

    }
    public static void main(String[] args) {

        System.out.println("请输入两个数");
        Scanner in=new Scanner(System.in);
        int[] array=new int[2];
        while (in.hasNext()) {
           array[0]=in.nextInt();
           array[1]=in.nextInt();
            //int[] result=swap(array);
            int[] result=swap2(array);
            for (int aResult : result) {

                System.out.print(aResult+" ");
            }
        }

    }
}
