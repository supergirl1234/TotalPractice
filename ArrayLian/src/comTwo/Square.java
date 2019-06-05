package comTwo;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/5 0005
 */
public class Square {

    public static void Print(int num,String str){

        /*for(int i=0;i<num;i++){
            System.out.print(str);

        }
        System.out.println();
        for(int i=0;i<num-2;i++){

            System.out.print(str);
            for(int j=0;j<num-3;j++){

                System.out.print(" ");
            }
            System.out.print(str);
            System.out.println();
        }

        for(int i=0;i<num;i++){
            System.out.print(str);

        }*/

        for(int i=1;i<=num;i++){//输出第一行
            System.out.print(str);
        }
        System.out.println();//第一行换行
        for(int i=1;i<=Math.ceil((double)num/2)-2;i++){//输出中间行
            System.out.print(str);//中间行第一个字符
            for(int j=2;j<=num-1;j++){
                System.out.print(" ");//中间行其它字符为空字符串
            }
            System.out.println(str);//中间行最后一个字符
        }
        for(int i=1;i<=num;i++){//输出最后一行
            System.out.print(str);
        }
    }



    public static void main(String[] args) {
        System.out.println("请输入数字和字符：");
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){

            int num=in.nextInt();
            String c=in.nextLine();
            Print( num,c);

        }
    }
}
