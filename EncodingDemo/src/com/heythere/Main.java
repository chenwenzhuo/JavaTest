package com.heythere;

import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        String string = "慕课ABC";
        byte[] strBytes = string.getBytes();
        for (byte b : strBytes) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        byte[] strBytes2 = string.getBytes("gbk");
        for (byte b : strBytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        byte[] strBytes3 = string.getBytes(StandardCharsets.UTF_8);
        for (byte b : strBytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        //JAVA是双字节编码 utf-16be
        byte[] strBytes4 = string.getBytes(StandardCharsets.UTF_16BE);
        for (byte b : strBytes4) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
        System.out.println();

        /*
        当字节序列是某种编码时，要将其转换成字符串，
        也需要使用同种编码方式，否则会出现乱码
         */
        String string1 = new String(strBytes4);
        System.out.println(string1);
        String string2 = new String(strBytes4, StandardCharsets.UTF_16BE);
        System.out.println(string2);
    }
}
