package com.heythere.IO_CharStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISReaderAndOSWriterDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("fileOne.txt"));//使用项目的默认编码

        int c;
        while (-1 != (c = isr.read())) {
            System.out.print((char) c);
        }

        /*
        批量读取，放入buffer数组中，
        从位置0开始放，最多放buffer.length个（放满）
        返回值是读到的字符个数，返回-1表示读到结尾
         */
        char[] buffer = new char[1024];
        int count;
        while (-1 != (count = isr.read(buffer, 0, buffer.length))) {
            String str = new String(buffer, 0, count);
            System.out.print(str);
        }

        isr.close();
    }
}
