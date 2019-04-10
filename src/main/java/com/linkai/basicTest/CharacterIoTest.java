package com.linkai.basicTest;

import java.io.*;

/**
 * @ClassName: CharacterIoTest
 * @Description: 字符流
 * @Author: K LIn
 * @Date: 18-12-7 下午2:26
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class CharacterIoTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(new File(".","ByteIoTest.java"));
            fileWriter = new FileWriter(new File("ByteIoTestCopy.java"));

            //1.原始操作
            int num = 0;
            while ((num = fileReader.read())!=-1){
                System.out.println((char)num);
            }

            //2.一次读取指定大小的操作
            int len = 0;
            char[] buffer = new char[2048];//用的是字符数组
            while ((len = fileReader.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len));
            }

            //3.带缓存区的字符操作
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String lineContent = null;
            while ((lineContent = bufferedReader.readLine())!=null){
                System.out.println(lineContent);
                System.out.println(lineContent.length());

                fileWriter.write(lineContent);
                fileWriter.write("\n");

                bufferedWriter.write(lineContent);
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();//flush 到文件中
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
