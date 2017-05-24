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
        dos.writeUTF("�й�");//��utf-8���뷽ʽд��
        dos.writeChars("�й�");//��utf-16be���뷽ʽд��

        dos.close();
        InputUtil.printHex(file.getName());
    }
}
