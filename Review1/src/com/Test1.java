package com;


import java.util.Scanner;

/*输入n个整数，输出出现次数大于等于数组长度一半的数。*/
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strings=str.split(" ");
            int[] arr=new int[strings.length];
            for(int i=0;i<strings.length;i++){

                arr[i]=Integer.valueOf(strings[i]);

            }
            int num=arr[0];
            int count=0;
            for(int k=1;k<arr.length;k++){
                if(arr[k]==num){
                    count++;
                }else if(count>0){
                    count--;
                }else{
                    num=arr[k];
                }

            }

            System.out.println(num);
        }
    }
}
