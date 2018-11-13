package com.heythere.URLTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 使用URL读取网页内容
 */
public class URL_OpenStream {
    public static void main(String[] args) throws IOException {
        URL baiduURL = new URL("https://www.baidu.com");

        InputStream is = baiduURL.openStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while (null != (line = br.readLine())) {
            System.out.println(line);
        }

        br.close();
        isr.close();
        is.close();
    }
}
