package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {

    static  byte[] bytes=new byte[1024];
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket=new ServerSocket();//1.这个Socket对象是用来监听的·listener；
            serverSocket.bind(new InetSocketAddress(8080));

            System.out.println("等待连接");
            /*阻塞*/
            Socket socket=serverSocket.accept();//2.这个Socket对象，是专门用来和客户端进行通信的Socket
            System.out.println("连接成功");

            System.out.println("等待读取数据");

            /*阻塞  value表示读了多少字节，读了多少数据*/
            int value=socket.getInputStream().read(bytes);//read会阻塞，读取出来的数据会存放在bytes数组中
            System.out.println("读取数据成功");
            String content=new String(bytes);
            System.out.println(value+":"+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
