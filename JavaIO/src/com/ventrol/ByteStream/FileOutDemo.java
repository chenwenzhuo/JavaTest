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
        //�����ļ���������ֱ�Ӵ�����������ɾ�������´���
        FileOutputStream out = new FileOutputStream("out.dat");
        out.write('A');
        out.write('B');

        int num = 10;
        out.write(num >>> 24);
        out.write(num >>> 16);
        out.write(num >>> 8);
        out.write(num);

        byte[] gbk = "�й�".getBytes("gbk");
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
            throw new IllegalArgumentException("�ļ���" + srcFile + "������");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "����һ���ļ�");
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
