package com.heythere.InetAddressTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public class IATest {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress类实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        //以字节数组形式获取IP地址
        byte[] ipByte = address.getAddress();
        System.out.println("以字节数组获得的IP地址：" + Arrays.toString(ipByte));
        //直接输出InetAddress对象
        System.out.println(address);
    }
}
