package com.lei.comm;


/*
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * */


/*
 *
 * 思路：
 * 比较两个字符串s1, s2大小的时候，先将它们拼接起来，
 * 比较s1+s2,和s2+s1那个大，如果s1+s2大，说明s1>s2,那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面
 *
 * */
public class Solution31 {

    public String PrintMinNumber(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-1-i; j++) {

                String str1= numbers[j]+""+numbers[j+1];
                String str2= numbers[j+1]+""+numbers[j];
                if(str1.compareTo(str2) > 0){

                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }

            }
        }

        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            sb.append(numbers[i]);

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3334,3,3333332};
        Solution31 solution31 = new Solution31();
        String str = solution31.PrintMinNumber(numbers);
        System.out.println(str);

    }
}
