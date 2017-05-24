package com.ventrol.Encoding;

/**
 * Created by ventrol on 17-3-3.
 * 本项目默认编码方式设置为GBK
 */
public class EncodingTest {
    public static void main(String[] args) throws Exception {
        String string = "慕课ABC";

        byte[] bytes1 = string.getBytes();//转换成字节序列，编码方式为GBK
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        //GBK编码中文占用两个字节，英文一个字节
        byte[] bytes2 = string.getBytes("GBK");
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        //utf-8编码中文占用三个字节，英文一个字节
        byte[] bytes3 = string.getBytes("utf-8");
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        //utf-16be编码中文占用两个字节，英文两个字节
        byte[] bytes4 = string.getBytes("utf-16be");
        for (byte b : bytes4) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        /*
         * 当字节序列使用某种编码方式时，
         * 若想把字节序列转换成字符串，
         * 则也需要使用同样的编码方式。
         * 否则会出现乱码
         */
        String str1 = new String(bytes4);//使用默认的编码
        System.out.println(str1);
        String str2 = new String(bytes4, "utf-16be");//指定编码格式为utf-16be
        System.out.println(str2);

    }
}
