package com.heythere.SocketTest_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务器端，实现基于UDP的用户登陆
 */
public class UDP_Server {
    public static void main(String[] args) throws IOException {
        /*
         *接收客户端发送的数据
         */
        //1.创建服务端DatagramSocket，指定端口
        DatagramSocket serverDatagramSocket = new DatagramSocket(8899);

        //2.创建数据报，用于保存客户端发送的数据
        byte[] dataBytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(dataBytes, dataBytes.length);

        //3.接收客户端发送的数据
        System.out.println("*****服务器端即将启动，等待客户端发送数据*****");
        serverDatagramSocket.receive(packet);//在调用此方法后，接收到数据前，此方法会阻塞

        //4.读取数据
        String info = new String(dataBytes, 0, packet.getLength());
        System.out.println("这是服务器，客户端的信息：\n" + info);

        /*
         *对客户端进行响应
         */
        //1.定义客户端的地址、端口号及发向客户端的数据
        InetAddress clientAddress = packet.getAddress();
        int clientPort = packet.getPort();
        byte[] dataToClient = "尊敬的用户，欢迎您连接！".getBytes();

        //2.创建数据报，包含响应的数据信息
        DatagramPacket datagramToClient =
                new DatagramPacket(dataToClient, dataToClient.length, clientAddress, clientPort);

        //3.响应客户端，发送数据
        serverDatagramSocket.send(datagramToClient);

        //4.关闭资源
        serverDatagramSocket.close();
    }
}
