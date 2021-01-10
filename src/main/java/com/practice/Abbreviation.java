package com.practice;
import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        boolean abbreviationDP[][] = new boolean[a.length()+1][b.length()+1];
        abbreviationDP[0][0]=true;
        /*
        for(int i=1;i<=b.length();i++){
            abbreviationDP[0][i]=false;
        }
        */
        for(int i=0;i<a.length();i++){
            if(Character.isLowerCase(a.charAt(i))) {
                abbreviationDP[i+1][0] = true;
            }
            else{
                break;
            }
        }

        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)) {
                    abbreviationDP[i+1][j+1] = abbreviationDP[i][j];
                }
                else if(  Character.toUpperCase(a.charAt(i))==b.charAt(j)){
                    abbreviationDP[i+1][j+1]=abbreviationDP[i+1][j] || abbreviationDP[i][j];
                }
                else if(Character.isUpperCase(a.charAt(i))){
                    return "NO";
                }
                else{
                    abbreviationDP[i+1][j+1]=abbreviationDP[i+1][j];
                }
            }
        }
        /*for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                System.out.print(abbreviationDP[i][j] + " ");
            }
            System.out.println();
        }*/
        return abbreviationDP[a.length()][b.length()]==true?  "YES":"NO";
        // recursive approach to think before making dynamic programming solution
        /*
        if(a==null || b==null) return "YES";
        if(a.charAt(0)==b.charAt(0)){
            return abbreviation( a.substring(1),  b.substring(1));
        }
        else if(Character.isLower(a.charAt(0))){
            return abbreviation( Character.toUpper(a.charAt(0))+a.substring(1),  b) || abbreviation( a.substring(1),  b);
        }
        return "NO"
        */

    }


    static String abbreviation2(String a, String b) {
        boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (Character.isLowerCase(a.charAt(j - 1))) dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
                if (ca >= 'A' && ca <= 'Z') {
                    if (ca == cb) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }else {
                    ca = Character.toUpperCase(ca);
                    if (ca == cb) dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                    else dp[i][j] = dp[i][j - 1];
                }
            }
        }
        for(int i=0;i<=b.length();i++){
            for(int j=0;j<=a.length();j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[b.length()][a.length()] ? "YES" : "NO";
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner= new Scanner(System.in);
        /*
        int testcase= scanner.nextInt();

        while(testcase-->0){
                String a = scanner.next();

                String b = scanner.next();

            String result = abbreviation("daBcd", "ABC");
            System.out.println(result);
        }
        */
        String result = abbreviation("daBcd", "ABC");
        System.out.println(result);
         result = abbreviation2("daBcd", "ABC");
        System.out.println(result);



        scanner.close();
    }
}
