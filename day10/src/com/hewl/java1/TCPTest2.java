package com.hewl.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wen
 * @date 2021-07-15
 */
public class TCPTest2 {
    @Test
    public void cilent() {

        Socket sc = null;
        OutputStream os = null;
        FileInputStream fis = null;

        try {
            sc = new Socket(InetAddress.getByName("127.0.0.1"), 8989);

            os = sc.getOutputStream();

            fis = new FileInputStream(new File("超越.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void server() {

        ServerSocket ss = null;
        Socket ac = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(8989);

            ac = ss.accept();

            is = ac.getInputStream();

            fos = new FileOutputStream(new File("超越1.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            //System.out.println("接收来自：" + ss.getInetAddress().getHostAddress()+ "的图片");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ac != null) {

                try {
                    ac.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
