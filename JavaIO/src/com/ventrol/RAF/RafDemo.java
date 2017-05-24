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
        raf.write(num >>> 24 & 0xff);//ÿ�����ƣ�д��int�ĵ�8λ��һ���ֽڣ�
        raf.write(num >>> 16 & 0xff);
        raf.write(num >>> 8 & 0xff);
        raf.write(num & 0xff);
        System.out.println(raf.getFilePointer());

        raf.writeInt(num);

        System.out.println("pointer:" + raf.getFilePointer());
        String str = "��";
        byte[] bytes = str.getBytes("gbk");
        raf.write(bytes);
        System.out.println("length:" + raf.length());

        //���ļ��������ָ���Ƶ��ļ�ͷ��
        raf.seek(0);//seek()�������ļ�ָ���Ƶ�����λ��
        //һ���Զ�ȡ�ļ�����
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        //������ȡ�����ֽڣ���gbk��װ��ɵõ�����
        raf.seek(10);
        byte[] chineseWordBytes = new byte[2];
        raf.read(chineseWordBytes);
        String chineseWord = new String(chineseWordBytes, "gbk");
        System.out.println(chineseWord);
        raf.close();
    }
}
