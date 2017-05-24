package com.ventrol.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class FileOutDemo {
    public static void main(String[] args)throws IOException {
        //若该文件不存在则直接创建，存在则删除后重新创建
        FileOutputStream out = new FileOutputStream("out.dat");
        out.write('A');
        out.write('B');

        int num = 10;
        out.write(num >>> 24);
        out.write(num >>> 16);
        out.write(num >>> 8);
        out.write(num);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        InputUtil.printHex("out.dat");

        for (int i = 0; i < 3; i++) {
            File srcFile = new File("out.dat");
            File destFile = new File("new_" + (i + 1) + "_" + srcFile.getName());
            copyFile(srcFile, destFile);
        }
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是一个文件");
        }

        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(destFile);

        byte[] buf = new byte[1024];
        int inLength;
        while ((inLength = inputStream.read(buf, 0, buf.length)) != -1) {
            outputStream.write(buf, 0, inLength);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }
}
