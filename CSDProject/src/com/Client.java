package com;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",8080);//3.客户端Socket对象

            //socket.getOutputStream().write("111".getBytes());

            Scanner scanner=new Scanner(System.in);
            String text=scanner.nextLine();
            socket.getOutputStream().write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
