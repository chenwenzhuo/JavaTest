package com.heythere.IO_ByteStream;

import java.io.*;

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
        int count = 0;//换行计数器
        while (-1 != (b = fis.read())) {
            //小于0xf时加0补成两位
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "   ");
            if (0 == (++count) % 10) {
                System.out.println();
            }
        }
        fis.close();
    }

    public void printHexByByteArray(String fileName) throws IOException {
        //将文件作为字节流进行读操作
        FileInputStream fis = new FileInputStream(fileName);

        byte[] buf = new byte[1024];//读取到数组buf中
        int count = 0;//换行计数器

        int bytes = fis.read(buf, 0, buf.length);//返回读到的字节数

        for (int i = 0; i < bytes; i++) {
            //小于0xf时加0补成两位
            if (buf[i] <= 0xf && buf[i] >= 0) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i] & 0xff) + "   ");
            if (0 == (++count) % 10) {
                System.out.println();
            }
        }
        fis.close();
    }

    public void writeToFile(String fileName) throws IOException {
        /**
         * true表示若文件存在，则向文件中追加内容
         * false表示若存在则删除再新建
         * 也可不选true和false，此时默认false，如：
         * FileOutputStream fos = new FileOutputStream(fileName);
         */
        FileOutputStream fos = new FileOutputStream(fileName, false);
        fos.write('A');
        fos.write('B');

        //写整数要分四次
        int num = 2345;
        fos.write(num >> 24);
        fos.write(num >> 16);
        fos.write(num >> 8);
        fos.write(num);

        String str = "中国";
        byte[] stringBytes = str.getBytes("gbk");
        fos.write(stringBytes);

        fos.close();
    }

    public void copyFile(String srcFileName, String destFileName) throws IOException {
        //避免出错，进行必要检查
        File srcFile = new File(srcFileName);
        if (!srcFile.exists()) {
            throw new FileNotFoundException("文件：" + srcFileName + "不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFileName + "不是一个文件！");
        }
        FileInputStream fis = new FileInputStream(srcFileName);
        FileOutputStream fos = new FileOutputStream(destFileName);//不选true或false则默认为false

        /**
         * 将字节读入aByte中，
         * 读一个字节写一个字节
         */
        int aByte;
        while (-1 != (aByte = fis.read())) {
            fos.write(aByte);
            fos.flush();
        }

        fis.close();
        fos.close();
    }

    public void copyFileByBuffer(String srcFileName,String destFileName)throws IOException {
        //避免出错，进行必要检查
        File srcFile = new File(srcFileName);
        if (!srcFile.exists()) {
            throw new FileNotFoundException("文件：" + srcFileName + "不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFileName + "不是一个文件！");
        }

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFileName));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFileName));

        /**
         * 将flush()写在while外，
         * 相当于先在while中把数据全部写入buffer，再将buffer区一次性写出到文件。
         * 这种方法速度更快
         */
        int aByte;
        while (-1 != (aByte = bis.read())) {
            bos.write(aByte);
//            bos.flush();//刷新缓冲区，否则不能写入
        }
        bos.flush();//刷新缓冲区，否则不能写入
        bis.close();
        bos.close();
    }
}
