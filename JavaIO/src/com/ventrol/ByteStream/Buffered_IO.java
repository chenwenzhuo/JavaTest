package com.ventrol.ByteStream;

import java.io.*;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class Buffered_IO {
    public static void main(String[] args) throws IOException {
        File srcFile = new File(
                "F:\\Programs\\TestPrograms\\JAVA\\JavaIO\\src\\com\\ventrol\\IO\\Buffered_IO.java");
        File destFile = new File("F:\\Programs\\TestPrograms\\JAVA\\Buffered_IO.txt");
        copyFileByBuffer(srcFile, destFile);
    }

    /**
     * 利用带缓冲的字节流进行文件的拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile,File destFile)throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是一个文件");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int n;
        while ((n = bis.read()) != -1) {
            bos.write(n);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }
}
