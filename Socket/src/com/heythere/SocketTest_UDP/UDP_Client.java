package com.heythere.SocketTest_UDP;

import java.io.IOException;
import java.net.*;

/**
 * 客户端，实现基于UDP的用户登陆
 */
public class UDP_Client {
    public static void main(String[] args) throws IOException {
        /*
         *向服务器端发送数据
         */
        //1.定义服务器地址、端口号和要发送的数据
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort=8899;
        byte[] data = "用户名：admin\n密码：password".getBytes();

        //2.创建数据报，包含要发送的数据信息
        DatagramPacket dataPacket = new DatagramPacket(data, data.length, serverAddress, serverPort);

        //3.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();

        //4.向服务器端发送数据报
        socket.send(dataPacket);

        /*
         *接收服务端发送的数据
         */
        //1.创建数据报，接收服务端响应的数据
        byte[] dataFromServer = new byte[1024];
        DatagramPacket datagramFromServer = new DatagramPacket(dataFromServer, dataFromServer.length);

        //2.接收服务端响应的数据
        socket.receive(datagramFromServer);

        //3.读取数据
        String reply = new String(dataFromServer, 0, datagramFromServer.getLength());
        System.out.println("这是客户端，服务端的信息：\n" + reply);

        //4.关闭资源
        socket.close();
    }
}
