package com.linkai.basicTest;

import java.io.*;

/**
 * @ClassName: ByteIoTest
 * @Description: 字节流
 * @Author: K LIn
 * @Date: 18-12-7 下午2:25
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ByteIoTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(new File("123.jpg"));
            fileOutputStream = new FileOutputStream(new File("321.jpg"));

            int bytes = 0;
            while ((bytes=fileInputStream.read())!=-1){
                fileOutputStream.write(bytes);
            }
            fileOutputStream.flush();

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len=bufferedInputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,len);
            }
            bufferedOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
