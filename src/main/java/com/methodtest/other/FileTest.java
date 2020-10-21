package com.methodtest.other;

import java.io.File;

/**
 * @author wudeyuan
 * @date 2020/10/13 16:49
 * @description
 */
public class FileTest {
    public static void main(String[] args){

        // F:\wudeapespace\learnfile
        File file = new File("F:\\wudeapespace\\learnfile");
        if (file.exists() && file.isDirectory()) {
            String parent = file.getParent();
            file.mkdirs();
            System.out.println(file);
        }

    }
}
