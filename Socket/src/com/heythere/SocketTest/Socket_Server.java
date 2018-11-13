package com.heythere.SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Socket_Server {
    public static void main(String[] args) {
        try {
            //1.创建一个ServerSocket，指定绑定的端口并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);

            //2.调用accept()方法开始监听，等待客户端的连接
            System.out.println("*****服务器端即将启动，等待客户端的连接*****");
            Socket s_Socket;

            //计数器，记录连接的客户端的数量
            int clientCount = 0;

            //循环调用accept(),监听客户端的连接
            while (true) {
                s_Socket = serverSocket.accept();

                //开启一个线程，对客户端进行相应
                Socket_ServerThread serverThread = new Socket_ServerThread(s_Socket);
                serverThread.start();

                //统计并输出已连接的客户端的数量
                clientCount++;
                System.out.println("已连接的客户端数量：" + clientCount);

                //获取客户端IP地址
                InetAddress inetAddress = s_Socket.getInetAddress();
                System.out.println("客户端IP地址：" + inetAddress.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
