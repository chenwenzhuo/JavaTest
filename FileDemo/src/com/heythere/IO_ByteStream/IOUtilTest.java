package com.heythere.IO_ByteStream;

import java.io.IOException;

public class IOUtilTest {
    public static void main(String[] args) throws IOException {
        IOUtil util = new IOUtil();
        /*try {
            //使用相对路径，在当前文件夹下查找fileOne.txt
            util.printHex("fileOne.txt");
            util.printHexByByteArray("fileOne.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*util.writeToFile("fileTwo.txt");
        util.printHex("fileTwo.txt");*/

        //startTime和endTime用于计时，测量拷贝需要的时间
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        util.copyFile("爱情转移.mp3", "爱情转移copy_1.mp3");
//        util.printHex("fileThree.txt");
        endTime = System.currentTimeMillis();
        System.out.println("Copy by byte,cost time:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        util.copyFileByBuffer("爱情转移.mp3", "爱情转移copy_2.mp3");
//        util.printHex("fileFive.txt");
        endTime = System.currentTimeMillis();
        System.out.println("Copy by buffer,cost time:" + (endTime - startTime));
    }
}
