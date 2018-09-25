package com.heythere;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        File file = new File("E:\\Programs\\Java\\JavaTest\\FileDemo\\FileForTest");
//        System.out.println("File exists: " + file.exists());
//        if (!file.exists()) {
//            file.mkdir();
//        } else {
//            file.delete();
//        }
//
//        //是否是文件（目录）
//        //以下两个方法，文件（目录）存在返回true，不是文件（目录）或文件（目录）不存在返回false
//        System.out.println("Is file: " + file.isFile());
//        System.out.println("Is directory: " + file.isDirectory());
//
//        File file1 = new File("E:\\Programs\\Java\\JavaTest\\FileDemo\\fileOne.txt");
//        if (!file1.exists()) {
//            try {
//                file1.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            file1.delete();
//        }
//
//        //常用的File对象的API
//        System.out.println(file1);
//        System.out.println(file1.getAbsoluteFile());
//        System.out.println(file1.getAbsolutePath());
//        System.out.println(file1.getName());

        FileUtils fileUtils = new FileUtils();
        fileUtils.listDirectory(new File("E:\\Programs\\Java\\JavaTest\\FileDemo"));
    }
}
