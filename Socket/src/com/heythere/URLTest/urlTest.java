package com.heythere.URLTest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL类的常用方法
 */
public class urlTest {
    public static void main(String[] args) {
        try {
            //获取URL对象
            URL url_Super = new URL("https://www.baidu.com");
            //通过已有的URL对象，获取子URL对象
            //?后面表示参数，#后面表示锚点
            URL url_son = new URL(url_Super, "file.html?username=Jack#test");

            System.out.println("协议：" + url_son.getProtocol());
            System.out.println("主机：" + url_son.getHost());
            //若未指定端口号，则使用协议默认的端口号，此时getPort()方法返回值为-1
            System.out.println("端口：" + url_son.getPort());
            System.out.println("文件路径：" + url_son.getPath());
            System.out.println("文件名：" + url_son.getFile());
            System.out.println("相对路径：" + url_son.getRef());
            System.out.println("查询字符串：" + url_son.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
