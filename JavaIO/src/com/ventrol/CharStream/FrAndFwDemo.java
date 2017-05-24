package com.ventrol.CharStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("charIO.txt");
        FileWriter fw = new FileWriter("charIO_1.txt");

        int c;
        while ((c = fr.read()) != -1) {
            fw.write(c);
            System.out.print((char) c);
            /*if ((char) c == '¡£') {
                System.out.println();
            }*/
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
