package com.practice.hackerrank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
The problem can be found here
https://www.hackerrank.com/challenges/luck-balance/problem

 */



public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luckBalance=0;
        Arrays.sort(contests, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });

        int totalImportantContest=0;
        for(int i=0;i<contests.length;i++){
            if(contests[i][1]==1)totalImportantContest++;
        }
        int totalLosePossiblity= totalImportantContest-k>0?totalImportantContest-k:0;
        for(int i=0;i<contests.length;i++){
            if(contests[i][1]==1 && totalLosePossiblity>0){
                totalLosePossiblity--;
                luckBalance-=contests[i][0];
            }
            else{
                luckBalance+=contests[i][0];
            }
        }
        return luckBalance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);


        scanner.close();
    }
}

