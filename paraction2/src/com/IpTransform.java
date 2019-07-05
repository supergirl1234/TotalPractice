package com;


import java.util.Scanner;

/*
* 将ip地址与10进制的ip地址进行转换
* 如：10.0.3.193 即00001010  00000000 00000011  11000001 转换成10进制为：167773121
*
* 要求：输入:1.输入IP地址
*           2.输入10进制型的IP地址
*      输出：1.输出转换成10进制的Ip地址
*            2.输出转换后的Ip地址
*
* */
public class IpTransform {
    //IP地址转换为10进制型的IP地址
    public static  void IpTranForNum(String str){
        int sum=0;
        String [] strArray=str.split("\\.");



        for(int i=0;i<strArray.length;i++){
            StringBuilder sb=new StringBuilder();
            int num=Integer.parseInt(strArray[i]);
            //将其转化为二进制
            while(num!=0) {
                sb.append(num % 2);
                num=num/2;
            }
            int length=sb.length();
            if(length<8){
                for(int j=0;j<8-length;j++){

                    sb.append(0);
                }
            }
            strArray[i]=sb.reverse().toString();
        }
        StringBuilder sbb=new StringBuilder();
        for(int i=0;i<strArray.length;i++){

            sbb.append(strArray[i]);
        }
        for(int k=0;k<sbb.length();k++){
            sum+=Integer.parseInt(sbb.substring(k,k+1))*Math.pow(2,31-k);

        }
        System.out.println(sum);
    }

    //  10进制型的IP地址转换为IP地址
    public static void NumTransForIp(int num){
        StringBuilder sb=new StringBuilder();
        String[] array=new String[4];
        while(num!=0){

            int mod=num%2;
            sb.append(mod);
            num=num/2;

        }
        int length=sb.length();
        if( sb.length()<32){
            for(int i=0;i<32-length;i++) {
                sb.append(0);
            }
        }
        sb.reverse();


        int j=0;
        for(int i=0;i<4;i++){

            array[i]=sb.substring(j,j+8);
            j=j+8;
        }

        for(int k=0;k<4;k++) {
            int sum=0;
            for (int m=0;m<8;m++) {
                sum+=Integer.parseInt(array[k].substring(m, m + 1)) * Math.pow(2,7-m);


            }
            array[k] = String.valueOf(sum);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<array.length;i++){
            stringBuilder.append(array[i]);
            if(i!=array.length-1){

                stringBuilder.append(".");
            }

        }
        System.out.println(stringBuilder.toString());


    }

    public static void main(String[] args) {

        System.out.println("输入Ip地址和10进制型的Ip地址：");
        Scanner scanner=new Scanner(System.in);
        String Ip=scanner.nextLine();
        int IpNum=scanner.nextInt();
        IpTranForNum(Ip);
        NumTransForIp(IpNum);





    }
}
