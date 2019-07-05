package com;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Candidate2 {

    public static void main(String[] args) {

        //控制台输入数据
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            //候选人人数
            int n=scanner.nextInt();
            String[] s=new String[n];
            //记录候选人
            HashMap<String,Integer> hs=new HashMap<>();
            for(int i=0;i<n;i++){

                String temp=scanner.next();
                hs.put(temp,0);
                s[i]=temp;
            }

            //投票人数
            int m=scanner.nextInt();
            Set<String> keys=hs.keySet();
            int invalid=0;
            for(int i=0;i<m;i++){
                //投票
                String tick=scanner.next();
                if(keys.contains(tick)){
                    hs.put(tick,hs.get(tick)+1);
                }else{

                    invalid++;
                }

            }
            //输出结果
            for(String k:s){
                System.out.println(k+":"+hs.get(k));

            }
            System.out.println("Invalid"+invalid);
        }
    }
}
