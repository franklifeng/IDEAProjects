package com.huaweimianshi.serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author frank
 * @create 2020-01-05 18:53
 */
public class SimpleSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =null;
        BufferedReader br =null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket sk = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
            serverSocket.close();
        }
    }
}
