package com.heythere.SocketTest_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

/**
 * 服务端线程处理类
 */
public class Socket_ServerThread extends Thread {
    //和本线程相关的Socket
    private Socket thread_Socket;

    //建立几个用户名和密码的键值对，用于判断输入的用户名密码是否正确
    private HashMap<String, String> userName_Pwd;


    public Socket_ServerThread(Socket socket) {
        this.thread_Socket = socket;
        this.userName_Pwd = new HashMap<>();

        userName_Pwd.put("admin", "passwordAdmin");
        userName_Pwd.put("John", "passwordJohn");
        userName_Pwd.put("Michael", "passwordMichael");
    }

    //线程执行的操作，相应客户端请求
    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            //3.通过输入流，获取客户端发送的信息
            br = new BufferedReader(
                    new InputStreamReader(thread_Socket.getInputStream()));

            String info = null;
            String infoPreserve = null;
            while (null != (info = br.readLine())) {
                System.out.println("这是服务器，客户端信息是：");
                infoPreserve = info;
                System.out.println(info);
            }
            thread_Socket.shutdownInput();//关闭输入流

            //4.获取输出流，相应客户端的请求
            pw = new PrintWriter(thread_Socket.getOutputStream());//将输出流包装为打印流

            //检查来自客户端的用户名密码是否正确
            int separatorIndex = infoPreserve.indexOf(";");
            String userName = infoPreserve.substring(0, separatorIndex);
            String pwd = infoPreserve.substring(separatorIndex + 1);
            if (userName_Pwd.containsKey(userName)) {
                if (userName_Pwd.containsValue(pwd)) {
                    pw.write("尊敬的用户，欢迎您登录！");
                } else {
                    pw.write("对不起，密码错误");
                }
            } else {
                pw.write("对不起，用户名不存在");
            }
            pw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭相关资源
                if (null != br)
                    br.close();
                if (null != pw)
                    pw.close();
                thread_Socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
