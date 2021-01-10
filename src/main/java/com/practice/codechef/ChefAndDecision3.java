package com.practice.codechef;

import java.util.Scanner;

/**
 *
 * https://www.codechef.com/JAN21C/problems/DIVTHREE
 *
 */
public class ChefAndDecision3 {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc= new Scanner(System.in);
        int testCase= sc.nextInt();
        while(testCase-->0){

            int N=sc.nextInt();
            int K=sc.nextInt();
            int D=sc.nextInt();
            int[] problemsSetters= new int[N];
            int totalProblems=0;
            for(int i=0;i< N;i++) {
                problemsSetters[i]=sc.nextInt();
                totalProblems += problemsSetters[i];
            }
            System.out.println(getMaxDivision3Contest(N,K,D,totalProblems));
        }
    }

    private static int getMaxDivision3Contest(int N, int K, int D, int totalProblems) {
        int maxDivision=0;
        if(totalProblems<K) return maxDivision;

        return totalProblems/K>D?D:totalProblems/K;
    }
}
