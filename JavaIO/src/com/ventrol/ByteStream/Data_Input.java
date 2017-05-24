package com.ventrol.ByteStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class Data_Input {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("dos.dat"));
        InputUtil.printHex("dos.dat");
        System.out.println();

        int num = dis.readInt();
        System.out.println(num);
        num = dis.readInt();
        System.out.println(num);
        long longNum = dis.readLong();
        System.out.println(longNum);
        double doubleNum = dis.readDouble();
        System.out.println(doubleNum);
        String str = dis.readUTF();
        System.out.println(str);

        dis.close();
    }
}
