package com.ventrol.FileAPI;

import java.io.File;
import java.io.IOException;

/**
 * Created by --C-W-Z-- on 2017/3/3 0003.
 */
public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        FileUtils.listDirectory(new File("F:\\Programs\\TestPrograms\\JAVA\\JavaIO"));
    }
}
