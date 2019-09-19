package com.linkai.pencialTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: 永远不可能到达的地方
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-19 下午5:20
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 永远不可能到达的地方 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nPoint = scanner.nextInt();
        int mWay = scanner.nextInt();
        HashMap<Integer,List> wayMap = new HashMap<>(8);
        for (int i=0;i<mWay;i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            if (wayMap.containsKey(left)){
                ArrayList arrayList = (ArrayList) wayMap.get(left);
                arrayList.add(right);
                wayMap.put(left,arrayList);
            }else{
                if (!wayMap.containsKey(right)){
                    ArrayList list = new ArrayList(8);
                    list.add(right);
                    wayMap.put(left,list);
                }else{
                    ArrayList arrayList = (ArrayList) wayMap.get(right);
                    arrayList.add(left);
                    wayMap.put(right,arrayList);
                }
            }
        }
        int inter = scanner.nextInt();
        int outer = scanner.nextInt();
        int cur=inter;
        ArrayList cannotArrive = new ArrayList(8);
        while (true){
            if (wayMap.containsKey(cur)){
                ArrayList list = (ArrayList) wayMap.get(cur);
                if (list.size()==0){
                    break;
                }else {
                    int next = (int) list.get(0);
                    if (next==outer||!wayMap.containsKey(next)) {
                        list.remove(0);
                    }
                    wayMap.put(cur, list);
                    cur = next;
                    if (cur==outer)
                        cur=inter;
                }
            }else {
                cannotArrive.add(cur);
                cur=inter;
            }
        }
        for (int i=0;i<cannotArrive.size();i++){
            System.out.print(cannotArrive.get(i));
            System.out.print(" ");
        }
    }
}
