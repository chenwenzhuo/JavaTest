package com.ventrol.FileAPI;

import java.io.File;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */

//列出File类的一些常用操作如过滤、遍历等操作
public class FileUtils {
    /**
     * 列出指定目录下（包括其子目录）的所有文件
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir)throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录 " + dir + " 不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是一个目录");
        }

        /*
        list()方法用于列出当前目录下的直接子目录和文件，
        以String数组的形式返回目录名和文件名。
         */
        /*String[] fileNames = dir.list();
        for (String s : fileNames) {
            System.out.print(s + "   ");
        }
        System.out.println();*/

        /*
        listFile()方法用于列出当前目录下的所有子目录和文件，
        以File数组的形式返回子目录和文件的File对象
         */
        File[] files = dir.listFiles();
        //要列出目录下的所有子目录和文件，则进行递归
        if (null != files && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }
}
