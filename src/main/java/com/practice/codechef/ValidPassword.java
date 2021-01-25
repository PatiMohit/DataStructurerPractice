package com.practice.codechef;

import java.util.Scanner;

public class ValidPassword {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc= new Scanner(System.in);
        int testCase= sc.nextInt();
        while(testCase-->0){
            String password=sc.nextLine();
            System.out.println(isValidPassword(password));
        }
    }

    private static String isValidPassword(String password) {
        if(password.length()<10) return "NO";
        if(password.matches(".*[a-z].*")
                && !String.valueOf(password.charAt(password.length()-1)).matches("[A-Z0-9]")
                && !String.valueOf(password.charAt(0)).matches("[A-Z0-9]")
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[@#%&?].*")){
            return "YES";
        }
        return "NO";
    }
}
