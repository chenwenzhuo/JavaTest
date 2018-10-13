package com.heythere.IO_ByteStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
    public static void main(String[] args)throws IOException {
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("fileFour.txt"));
        dos.writeInt(1024);
        dos.writeInt(-2048);
        dos.writeLong(100L);
        dos.writeDouble(1.234);
        dos.writeFloat(2.34f);

        //使用utf-8编码写出
        dos.writeUTF("中国");
        //使用utf-16be编码写出
        dos.writeChars("中国");
        dos.close();

        IOUtil util = new IOUtil();
        util.printHex("fileFour.txt");
    }
}
