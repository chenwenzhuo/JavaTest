package com.ventrol.CharStream;

import java.io.*;

/**
 * Created by --C-W-Z-- on 2017/3/4 0004.
 */
public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("charIO.txt")));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("charIO_2.txt")));
        PrintWriter pw = new PrintWriter("charIO_3.txt");

        String string;
        while ((string = br.readLine()) != null) {
            System.out.println(string);

            bw.write(string);
            bw.newLine();
            bw.flush();

            pw.println(string);
            pw.flush();
        }
        br.close();
        bw.close();
        pw.close();
    }
}
