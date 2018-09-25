package com.heythere;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //指针位置
        System.out.println(raf.getFilePointer());

        raf.write('A');
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());

        int num = 0x7fffffff;
        raf.write(num >> 24);
        raf.write(num >> 16);
        raf.write(num >> 8);
        raf.write(num);
        System.out.println(raf.getFilePointer());

        //raf.writeInt(num);
        String str = "中国";
        byte[] gbkBytes = str.getBytes("gbk");
        raf.write(gbkBytes);
        System.out.println("File length: " + raf.length());

        //读文件时必须把指针移到头部
        raf.seek(0);
        //一次性读出raf.txt的内容
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        String str1 = new String(buf, "gbk");
        System.out.println(str1);
    }
}
