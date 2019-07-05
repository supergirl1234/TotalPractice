package com;

import java.util.Scanner;

public class IpTransform2 {

    public static long convertIpNum(String ip){

        //使用 .分割
        String[] ips=ip.split("\\.");
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<ips.length;i++){

            sb.append(binaryString(ips[i]));
        }
        return Long.parseLong(sb.toString(),2);

    }

    //将十进制书转换为二进制字符串
    private static String binaryString(String s) {

        StringBuffer sb=new StringBuffer();
        int num=Integer.parseInt(s);
        int k=1<<7;
        for(int i=0;i<8;i++){
            int flag=(num&k)==0?0:1;
            sb.append(flag);
            num=num<<1;

        }
        return sb.toString();
    }

    public static String convertIp(String ipNum){

          StringBuffer sb=new StringBuffer();
          String ipTwo=Long.toBinaryString(Long.parseLong(ipNum));//长整型转换为二进制字符串

          String as="";
          if(ipTwo.length()<32){
              for(int i=0;i<32-ipTwo.length();i++){

                  as+="0";
              }

          }
          ipTwo=as+ipTwo;
          //IP地址每一段进行拼接
        String[] ips=new String[4];
        ips[0]=ipTwo.substring(0,8);
        ips[1]=ipTwo.substring(8,16);
        ips[2]=ipTwo.substring(16,24);
        ips[3]=ipTwo.substring(24);
        for(int i=0;i<4;i++){
            sb.append(Integer.parseInt(ips[i],2));
            if(i!=3){
                sb.append(".");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String ip=scanner.nextLine();
            String ipNum=scanner.nextLine();
            System.out.println(convertIpNum(ip));
            System.out.println(convertIp(ipNum));

        }
    }

}
