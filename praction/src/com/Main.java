package com;

import java.util.*;

/**
 * Author:Fanleilei
 * Created:2019/6/9 0009
 * 火车进站，输入进站火车的序列号1-9，按字典排序输出出栈序列
 */
public class Main {
    //求出所有排列
    public static void Permutation(int[] a, int start, int n, ArrayList<int[]> result) {

        if (start==n) {
           return;
        }
        if (start==n-1) {
            int[] B=a.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){

            swap(a,start,i);
            Permutation(a,start+1,n,result);
            swap(a,start,i);
        }

    }

    public  static  boolean isLegal(int[] in,int[] out,int n){


        //栈：存储进站的火车编号
        LinkedList<Integer> stack=new LinkedList<>();
        int i=0;
        int j=0;
        while(i<n){

            if(in[i]==out[j]){//相等的时候就不用进栈，直接后移

                i++;
                j++;
            }else{

                if(stack.isEmpty()){//空stack，就只有入栈了
                    stack.push(in[i]);
                    i++;


                }else{

                    int top=stack.peek();//栈顶元素想到能，进行出栈
                    if(top==out[j]){
                        j++;
                        stack.pop();

                    }else if(i<n){//不相等时候入栈，说明还有待进站的车
                        stack.push(in[i]);

                        i++;
                    }
                }
            }

        }
        while(!stack.isEmpty()&&j<n){
            int top=stack.pop();
            if(top==out[j]){
                j++;

            }else{
                return false;
            }

        }
        return true;
    }
    public static void swap(int[] array, int a, int b) {

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }

    public static void main(String[] args) {


        System.out.println("请输入内容:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();


        int[] array = new int[num];
        for (int i = 0; i < num; i++) {

            array[i] = in.nextInt();
        }


        int start = 0;
        //计算n个火车的出站的编号的排列组合
        ArrayList<int[]> result = new ArrayList<>();

        Permutation(array, start, num, result);
        //出栈的结果，一个元素一个记录
        Set<String> sortResult=new TreeSet<>();
        //循环排列组合
        for(int[] out : result){
         //判断是否满足出栈要求（后进先出）
            if(isLegal(array,out,num)){
               //满足的组合，输入结果，每一个编号用空格分隔
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<num-1;i++){
                    sb.append(out[i]+" ");
                }
                sb.append(out[num-1]);
                sortResult.add(sb.toString());
            }
        }
        //最后输出所有的符合出栈要求的组合
        for(String list:sortResult){ System.out.
                println(list);
        }
        in.close();
    }
}
