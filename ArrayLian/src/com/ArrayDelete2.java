package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 * 在一个数组中，每隔两个数，删除一个数，循环删除
 */
public class ArrayDelete2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n>1000){
                n=999;

            }
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int i=0;
            while(list.size()>1){
                i=(i+2)%list.size();
                list.remove(i);//List每remove掉一个元素之后，后面的元素都会向前移动
            }
            System.out.println(list.get(0));

        }

    }
}
