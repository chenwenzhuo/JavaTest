package com.heythere.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class IOUtil {
    /**
     * 按字节读取指定文件内容，以16进制输出到控制台
     * 每输出10个byte就换行
     *
     * @param fileName
     */
    public void printHex(String fileName) throws IOException {
        //将文件作为字节流进行读操作
        FileInputStream fis = new FileInputStream(fileName);

        int b;//将字节读到b中
        int count=0;//换行计数器
        while (-1 != (b = fis.read())) {
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b)+"   ");
            if (0 == (++count) % 10) {
                System.out.println();
            }
        }
    }
}
