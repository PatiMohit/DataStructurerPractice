package com.practice.codechef;

import java.util.Scanner;

public class EncodedString {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc= new Scanner(System.in);
        int testCase= sc.nextInt();
        while(testCase-->0){
            System.out.println(getDecodedString(sc.nextLine()));
        }
    }

    private static String getDecodedString(String line) {

        return decodeString(line);
    }

    private static String decodeString(String encodedString){
        return null;
    }
}
