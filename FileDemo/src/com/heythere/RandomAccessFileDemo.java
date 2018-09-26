package com.heythere;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("Demo");
        if (!demo.exists()) {
            demo.mkdir();
        }
        File file = new File(demo, "raf.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        //新建RandomAccessFile实例，并将指针定位到文件头
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(0);
        System.out.println("指针位置:" + raf.getFilePointer());//指针位置

        //写入两个字符，并读出
        raf.writeChar('A');
        System.out.println("指针位置:" + raf.getFilePointer());
        raf.writeChar('B');
        System.out.println("指针位置:" + raf.getFilePointer());
        raf.seek(0);
        char c1 = raf.readChar();
        char c2 = raf.readChar();
        System.out.println("c1=" + c1 + ",c2=" + c2);

        //以两种方式写入int数字，并读出
        int num = 6127;
        raf.write(num >>> 24 & 0xff);
        raf.write(num >>> 16 & 0xff);
        raf.write(num >>> 8 & 0xff);
        raf.write(num & 0xff);
        System.out.println("指针位置:" + raf.getFilePointer());
        raf.seek(4);
        int wroteNum = raf.readInt();
        System.out.println("读到：" + wroteNum);

        raf.writeInt(2333);
        raf.seek(8);
        wroteNum = raf.readInt();
        System.out.println("读到：" + wroteNum);

        String str = "中国";
        byte[] strBytes = str.getBytes(StandardCharsets.UTF_16BE);
        raf.write(strBytes);
        System.out.println("File length: " + raf.length());

        //读文件时必须把指针移到头部
        raf.seek(0);
        //一次性读出raf.txt的内容
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        String str1 = new String(buf, StandardCharsets.UTF_16BE);
        System.out.println(str1);

        raf.close();
    }
}
