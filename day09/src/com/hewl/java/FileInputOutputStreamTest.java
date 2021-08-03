package com.hewl.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wen
 * @date 2021-07-07
 *
 * 对于文本文件（.txt,.java,.c,.cpp），使用字符流处理
 * 对于非文本文件（.jpg,.mp3.mp4.avi,.doc,.ppt），使用字节流处理
 *
 */
public class FileInputOutputStreamTest {
    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\";
        String destPath = "C:\\Users\\...";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));
    }
    //实现指定路径下文件的复制
    public void copyFile(String srcpath, String destpath){
        FileInputStream  fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcpath);
            File destFile = new File(destpath);
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1) {
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //实现对图片的复制
    @Test
    public void testFileInputOutputStream() {
        FileInputStream  fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("超越.jpg");
            File destFile = new File("超越1.jpg");
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer))!=-1) {
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileInputStream() {
        //使用字节流FileInputStream处理文本文件，可能出现乱码
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取字节的个数
            while((len = fis.read(buffer))!=-1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
