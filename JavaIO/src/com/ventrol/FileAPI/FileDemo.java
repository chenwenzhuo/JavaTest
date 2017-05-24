package com.ventrol.FileAPI;

import java.io.File;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //java.io.File�����ڱ�ʾ�ļ���Ŀ¼
        /*
         * File������ڱ�ʾ�ļ���Ŀ¼����Ϣ�����ơ���С�ȣ���
         * ���������ļ����ݵķ���
         */
        File file = new File("F:/Programs/TestPrograms/JAVA/abc");
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdir();//����Ҫ�����༶Ŀ¼ʱʹ��File.mkdirs()����
        } else {
            file.delete();
        }

        //�ж��Ƿ���һ��Ŀ¼,��Ŀ¼����true������Ŀ¼or�����ڷ���false
        System.out.println(file.isDirectory());
        //�ж��Ƿ���һ��Ŀ¼
        System.out.println(file.isFile());

        //��ͬ���캯��������
        File file1 = new File("F:/Programs/TestPrograms/JAVA/abc.txt");
        File file2 = new File("F:/Programs/TestPrograms/JAVA", "abc1.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            file2.createNewFile();
        } else {
            file1.delete();
            file2.delete();
        }

        System.out.println(file);//��ӡfile.toString������
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
    }
}
