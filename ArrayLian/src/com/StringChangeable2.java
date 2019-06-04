package com;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 */
public class StringChangeable2 {

    public static String sovle(String str,int n,Scanner scan){

        for(int i=0;i<n;i++){
            int p=scan.nextInt();
            int len=scan.nextInt();

            String first=str.substring(0,p+len);
            String mid=str.substring(p,p+len);
            String end=str.substring(p+len,str.length());
            StringBuilder res=new StringBuilder();
            res.append(first);
            StringBuilder sb=new StringBuilder(mid);
            res.append(sb.reverse());//将mid的那一部分字符串反转
            res.append(end);
            str=res.toString();

        }
        return str;

    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            int n=in.nextInt();
            System.out.println(sovle(str,n,in));

        }
        in.close();
    }
}
