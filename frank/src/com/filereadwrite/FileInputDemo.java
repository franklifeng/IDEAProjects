package com.filereadwrite;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author frank
 * @create 2020-04-02 11:01
 */
public class FileInputDemo {
    public static void main(String[] args) {
        File file = new File("D:\\123.txt");
        FileInputStream fileInputStream = null;
        InputStreamReader ir = null;
        BufferedReader b = null;
        try {
            fileInputStream = new FileInputStream(file);
            ir = new InputStreamReader(fileInputStream);
            b = new BufferedReader(ir);
            String len =null;
            while ((len = b.readLine())!=null){
                System.out.println(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
