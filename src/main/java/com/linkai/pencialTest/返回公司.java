package com.linkai.pencialTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: 返回公司
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-17 下午8:14
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 返回公司 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nData = scanner.nextInt();
        for (int i=0;i<nData;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            HashMap<Integer,ArrayList<Integer>> routeMap = new HashMap<>();
            int left=0,right=0;
            for (int j =0;j<m;j++){
                left=scanner.nextInt();
                right=scanner.nextInt();
                if (left>right){
                    int temp=left;
                    left=right;
                    right=temp;
                }
                if (routeMap.get(left)!=null){
                    ArrayList<Integer> list = routeMap.get(left);
                    list.add(right);
                    routeMap.put(left,list);
                }else{
                    ArrayList<Integer> integerSet = new ArrayList<>();
                    integerSet.add(right);
                    routeMap.put(left,integerSet);
                }
            }
            int count = 0;
            while (true){
                int leftMap = 1;
                for (int i1=0;i1<2;i1++){
                    ArrayList<Integer> routeArray = routeMap.get(leftMap);
                    count++;
                    if (routeArray.size()==0){
                        System.out.println("IMPOSSIBLE");
                        count=m;
                        break;
                    }else if (routeArray.size()>1){
                        leftMap = routeArray.get(0);
                        routeArray.remove(0);
                    }else{
                        leftMap = routeArray.get(0);
                    }
                }
                if (leftMap==n) {
                    System.out.println("POSSIBLE");
                    break;
                }else if (count>=m){
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
        }
    }
}
