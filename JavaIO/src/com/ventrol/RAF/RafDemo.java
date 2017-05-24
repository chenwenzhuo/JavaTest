package com.ventrol.RAF;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if (!demo.exists()) {
            demo.mkdir();
        }
        File file = new File("raf.dat");
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        System.out.println(raf.getFilePointer());

        raf.write('A');
        raf.write('B');
        System.out.println(raf.getFilePointer());

        int num = 0x7fffffff;
        raf.write(num >>> 24 & 0xff);//每次右移，写入int的低8位（一个字节）
        raf.write(num >>> 16 & 0xff);
        raf.write(num >>> 8 & 0xff);
        raf.write(num & 0xff);
        System.out.println(raf.getFilePointer());

        raf.writeInt(num);

        System.out.println("pointer:" + raf.getFilePointer());
        String str = "中";
        byte[] bytes = str.getBytes("gbk");
        raf.write(bytes);
        System.out.println("length:" + raf.length());

        //读文件，必须把指针移到文件头部
        raf.seek(0);//seek()方法把文件指针移到所需位置
        //一次性读取文件内容
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        //单独读取两个字节，按gbk包装则可得到中文
        raf.seek(10);
        byte[] chineseWordBytes = new byte[2];
        raf.read(chineseWordBytes);
        String chineseWord = new String(chineseWordBytes, "gbk");
        System.out.println(chineseWord);
        raf.close();
    }
}
