package com.huaweimianshi.serverSocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author frank
 * @create 2020-01-05 19:11
 */
public class SimpleSocketClient {
    public static void main(String[] args){
        Socket client = null;
        PrintStream ps = null;
        try {
            client = new Socket("localhost",8888);
            System.out.println("连接成功");
            ps = new PrintStream(client.getOutputStream());
            ps.println("您好 hello");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
