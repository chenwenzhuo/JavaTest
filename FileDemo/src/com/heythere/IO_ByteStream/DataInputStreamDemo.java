package com.heythere.IO_ByteStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(
                new FileInputStream("fileFour.txt"));

        int int_1 = dis.readInt();
        System.out.println(int_1);
        int int_2 = dis.readInt();
        System.out.println(int_2);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        float f = dis.readFloat();
        System.out.println(f);

        String str_1 = dis.readUTF();
        System.out.println(str_1);

        char[] chars = new char[2];
        for (int i = 0; i < 2; i++) {
            chars[i] = dis.readChar();
        }
        System.out.println(new String(chars, 0, 2));
        System.out.println(chars[0] + "   " + chars[1]);
    }
}
