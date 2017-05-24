package com.ventrol.FileAPI;

import java.io.File;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */

//�г�File���һЩ���ò�������ˡ������Ȳ���
public class FileUtils {
    /**
     * �г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir)throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("Ŀ¼ " + dir + " ������");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " ����һ��Ŀ¼");
        }

        /*
        list()���������г���ǰĿ¼�µ�ֱ����Ŀ¼���ļ���
        ��String�������ʽ����Ŀ¼�����ļ�����
         */
        /*String[] fileNames = dir.list();
        for (String s : fileNames) {
            System.out.print(s + "   ");
        }
        System.out.println();*/

        /*
        listFile()���������г���ǰĿ¼�µ�������Ŀ¼���ļ���
        ��File�������ʽ������Ŀ¼���ļ���File����
         */
        File[] files = dir.listFiles();
        //Ҫ�г�Ŀ¼�µ�������Ŀ¼���ļ�������еݹ�
        if (null != files && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //�ݹ�
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }
}
