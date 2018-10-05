package com.heythere.FileTest;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    /**
     * 列出指定目录下（包括子目录）的所有文件
     * @param dir
     * @throws IOException
     */
    public void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("Directory " + dir + " does not exist!");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " is not a directory!");
        }

        //要遍历子目录，需要做递归操作
        File[] subdirectory = dir.listFiles();//获得所有直接子目录下的所有文件
        if (null != subdirectory && 0 != subdirectory.length) {//若dir非空
            for (File f : subdirectory) {//遍历
                if (f.isDirectory()) {
                    listDirectory(f);//是目录则递归
                } else {
                    System.out.println(f);//不是目录则输出
                }
            }
        }
    }
}
