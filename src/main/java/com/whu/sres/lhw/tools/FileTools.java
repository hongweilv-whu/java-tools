package com.whu.sres.lhw.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Desc: 文件工具类
 * Created by lvhongwei on 2018/4/14.
 */
public final class FileTools {

    private FileTools() {
    }

    private static final String DEFAULT_CHARSET = "UTF-8";

    public static void saveFile(String fileName, byte[] content) {
        saveFile(fileName, System.getProperty("java.io.tmpdir"), content);
    }

    public static void saveFile(String fileName, String path, byte[] content) {
        try {
            File filePath = new File(path);
            OutputStream ops = new FileOutputStream(new File(filePath, fileName));
            ops.write(content);
            ops.flush();
            ops.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取文本文件
     */
    public static String readTextFile(File file) {
        BufferedReader br= null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFile() {

    }

    public static void deleteFile() {

    }
}
