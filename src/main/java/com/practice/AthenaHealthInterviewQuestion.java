package com.practice;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AthenaHealthInterviewQuestion {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){

            int arrSize= scanner.nextInt();
            int arr[]= new int[arrSize];
            for(int i=0;i<arrSize;i++){
                arr[i]=scanner.nextInt();
            }

            Map<Integer, Integer> map= new TreeMap<>(Collections.reverseOrder());
            for(int intValue:arr){
                if(map.containsKey(intValue)){
                    map.put(intValue,(map.get(intValue)+1));
                }
                else{
                    map.put(intValue,1);
                }
            }
            int result=0;
            map.remove(((TreeMap<Integer, Integer>) map).lastKey());
            for(Map.Entry<Integer,Integer> mapEntry:map.entrySet()){
                    System.out.println("result "+result);
                    result=result*2+ mapEntry.getValue();

            }
            System.out.print(result);
            // 7 7 6 5 5 4 3 3 2 1 1
        //     2  1 1 1 2 1 2
        //    2 2+2+1 2+2+1 + 2+2+1+1  (2+2+1 + 2+2+1+1)*2 + 2

        // prev*2+current
        // 2 5 12 25 53 108
    }


}
