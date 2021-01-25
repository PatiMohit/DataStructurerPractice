package com.practice.geeksforgeeks;

/*
We are given an array consisting of n elements. At each operation you can select any one element and increase rest of n-1 elements by 1. You have to make all elements equal performing such operation as many times you wish. Find the minimum number of operations needed for this.

Examples:

Input : arr[] = {1, 2, 3}
Output : Minimum Operation = 3
Explanation :
operation | increased elements | after increment
    1     |    1, 2            | 2, 3, 3
    2     |    1, 2            | 3, 4, 3
    3     |    1, 3            | 4, 4, 4

Input : arr[] = {4, 3, 4}
Output : Minimum Operation = 2
Explanation :
operation | increased elements | after increment
     1    |    1, 2           | 5, 4, 4
     2    |    2, 3           | 5, 5, 5

Link to the problem
https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/

 */

import java.util.Scanner;

public class MinOperationToMakeAllElementEqual {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){
        int testcase=scanner.nextInt();
        while(testcase-->0) {
            int size=scanner.nextInt();
            int inputArray[]= new int[size];
            for (int i = 0; i <size;i++){
                inputArray[i]=scanner.nextInt();
            }
            System.out.println(minOperation(inputArray,size));
        }
    }

    private static int minOperation(int[] inputArray, int size) {
        int minOperationForResult=0;
        if(size==0) return minOperationForResult;


        return minOperationForResult;
    }
}
