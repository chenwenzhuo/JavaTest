package com.ventrol.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class InputUtil {
    public static void main(String[] args) {
        try {
            printHex("F:\\jetBrains注册码.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 每输出10个byte换行
     *
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int input;
        int i = 1;
        while ((input = in.read()) != -1) {
            if (input <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(input) + "   ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
    }
}
