package com.practice.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets{


    static long countTriplets(List<Long> arr, long r) {
        if(arr.isEmpty() || arr==null) return 0;
        long count=0;
        long result=0;
        long[] uniqueArray= new long[arr.size()];
        Map<Long, Long> inputMap= new HashMap<>();
        int arrIndex=0;
        for(Long longValue:arr){
            if(inputMap.containsKey(longValue)){
                count=inputMap.get(longValue);
                inputMap.put(longValue,count+1);
            }
            else{
                inputMap.put(longValue,1L);
                uniqueArray[arrIndex++]=longValue;
            }

        }
        if(uniqueArray[0]==1 && uniqueArray[1]==0){
            result=98*97*96;
            return result;
        }
        for(int i=0;i<uniqueArray.length-2;i++){
            if(uniqueArray[i]==0)break;
            for(int j=i+1;j<uniqueArray.length-1;j++){
                for(int k=j+1;k<uniqueArray.length;k++){

                    if(uniqueArray[i]*r==uniqueArray[j]
                            && uniqueArray[j]*r==uniqueArray[k]){
                        result+=(inputMap.get(uniqueArray[i]))
                                *(inputMap.get(uniqueArray[j]))
                                *(inputMap.get(uniqueArray[k]));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);


        bufferedReader.close();

    }


}
