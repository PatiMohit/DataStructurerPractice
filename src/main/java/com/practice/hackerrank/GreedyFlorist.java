package com.practice.hackerrank;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
The problem can be found in below link
https://www.hackerrank.com/challenges/greedy-florist/problem

 */
public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {

        int minCost=0;
        Arrays.sort(c);
        int group=1;

        for(int i=c.length-1;i>=0;){

            for(int j=1;j<=k && i>=0;j++,i--){
                minCost+=group*c[i];
            }
            group++;
        }


        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println("actual "+ minimumCost);
        System.out.println("Expected"+163578911);
        scanner.close();
    }

}
