//package com.linkai.bigdataSolution;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @ClassName: TopK
// * @Description: TODO
// * @Author: K LIn
// * @Date: 19-5-16 下午5:17
// * @Version: 1.0
// * Remember to sow in the spring.
// **/
//public class TopK {
//    public static Set<String> fileList = new HashSet();
//    public static void partFile(String filePath){
//        File file = new File(filePath);
//        //判断文件是否存在
//        if (file.isFile()&&file.exists()){
//            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"GBK");
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            String lineTxt = null;
//            while ((lineTxt=bufferedReader.readLine())!=null){
//                String fileName = hash(lineTxt)+"file";
//                File writeFile = new File(fileName);
//                if (!writeFile.exists()) {
//                    writeFile.createNewFile();
//                }
//                BufferedWriter out = new BufferedWriter(new FileWriter(writeFile));
//                out.write(lineTxt);
//                out.flush();
//                out.close();
//                fileList.add(fileName);
//            }
//        }
//    }
//    public static int hash(Object key){
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//}
