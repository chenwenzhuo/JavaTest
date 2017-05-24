package com.ventrol.CharStream;

import java.io.*;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("charIO.txt");
        InputStreamReader isr = new InputStreamReader(in);
        FileOutputStream out = new FileOutputStream("charIO_utf8.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

        int c;
        int numInLine = 1;
        while ((c = isr.read()) != -1) {
            System.out.print((char) c);//向控制台输出
            osw.write(c);
            if ((char) c == '。') {
                System.out.println();
            }
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
