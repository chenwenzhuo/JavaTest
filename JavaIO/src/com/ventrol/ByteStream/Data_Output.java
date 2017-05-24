package com.ventrol.ByteStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class Data_Output {
    public static void main(String[] args) throws IOException{
        File file = new File("dos.dat");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(20L);
        dos.writeDouble(3.14);
        dos.writeUTF("中国");//以utf-8编码方式写入
        dos.writeChars("中国");//以utf-16be编码方式写入

        dos.close();
        InputUtil.printHex(file.getName());
    }
}
