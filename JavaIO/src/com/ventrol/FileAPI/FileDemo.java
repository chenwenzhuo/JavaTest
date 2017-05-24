package com.ventrol.FileAPI;

import java.io.File;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //java.io.File类用于表示文件或目录
        /*
         * File类仅用于表示文件、目录的信息（名称、大小等），
         * 不能用于文件内容的访问
         */
        File file = new File("F:/Programs/TestPrograms/JAVA/abc");
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdir();//当需要创建多级目录时使用File.mkdirs()方法
        } else {
            file.delete();
        }

        //判断是否是一个目录,是目录返回true，不是目录or不存在返回false
        System.out.println(file.isDirectory());
        //判断是否是一个目录
        System.out.println(file.isFile());

        //不同构造函数的重载
        File file1 = new File("F:/Programs/TestPrograms/JAVA/abc.txt");
        File file2 = new File("F:/Programs/TestPrograms/JAVA", "abc1.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            file2.createNewFile();
        } else {
            file1.delete();
            file2.delete();
        }

        System.out.println(file);//打印file.toString的内容
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
    }
}
