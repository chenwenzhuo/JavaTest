package com.heythere.SocketTest;

import java.io.*;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 客户端
 */
public class Socket_Client {
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket clientSocket = new Socket("localhost", 8888);

            //2.获取输出流，向服务器端发送消息（OutputStream   PrintWriter）
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            pw.write("John;");
            pw.write("passwordJohn");
            pw.flush();
            clientSocket.shutdownOutput();//关闭输出流

            //3.接收服务端的相应信息
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String infoRespond;
            while (null != (infoRespond = br.readLine())) {
                System.out.println(infoRespond);
            }

            //4.关闭相关资源
            br.close();
            pw.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
