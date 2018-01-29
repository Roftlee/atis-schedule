package com.yd.atis.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * @author AsiQue
 * @since :2018.01.15 15:55
 */
public class FileUtils {

    /**
     * 创建文件，如果该文件父目录不存在，则会一并创建
     * @param fileName
     */
    public static final void createFile(String fileName) {
        try {
            File file = new File(fileName);

            File fileParent = file.getParentFile();

            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 写入内容到文件
     * @param fileName
     * @param content
     * @param append 是否追加 true:在文件末尾追加内容 false:覆盖原文件内容
     */
    public static final void writeFile(String fileName, String content, Boolean append) {

        //在内容前面添加时间
        content = DateUtils.format(new Date(), "[yyyy-MM-dd HH:mm:ss] ") + content;

        File file = new File(fileName);
        //文件不存在时，先创建文件再写入内容
        if (!file.exists()) {
            createFile(fileName);

            writeFile(fileName, content);
        } else {//文件存在
            if (append) {//在文件末尾追加内容
                appendFile(fileName, content);
            } else {//替换原文件内容
                writeFile(fileName, content);
            }
        }
    }

    /**
     * 写入内容到文件
     * @param fileName
     * @param content
     */
    private static final void writeFile(String fileName, String content) {

        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(fileName);
            fos.write(content.getBytes("utf-8"));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * 追加内容到文件
     * @param fileName
     * @param content
     */
    private static void appendFile(String fileName, String content) {

        RandomAccessFile raf = null;

        try {

            // 打开一个随机访问文件流，按读写方式
            raf = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = raf.length();
            // 将写文件指针移到文件尾。
            raf.seek(fileLength);
            //换行
            raf.writeBytes("\r\n");
            raf.write(content.getBytes("utf-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
