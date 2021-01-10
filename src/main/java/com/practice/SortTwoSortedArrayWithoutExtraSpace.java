package com.practice;

public class SortTwoSortedArrayWithoutExtraSpace {
    public static void merge(int arr1[], int arr2[], int n, int m)
    {
        int pointerOne =0;
        int pointerTwo = 0;
        int minLength = arr1.length > arr2.length ? arr2.length: arr1.length;
        int maxLength = arr1.length > arr2.length ? arr1.length: arr2.length;

        while(pointerOne < minLength && pointerTwo < minLength){
            if(arr1[pointerOne] <arr2[pointerTwo]){
                System.out.print(arr1[pointerOne] + " ");
                pointerOne++;
            } else{
                System.out.print(arr2[pointerTwo]+ " ");
                pointerTwo++;
            }
        }

        if(pointerOne == minLength){
            while(pointerTwo < maxLength){
                System.out.print(arr2[pointerTwo] + " ");
                pointerTwo++;
            }
        }else{
            while(pointerOne < maxLength){
                System.out.print(arr1[pointerOne] + " ");
                pointerOne++;
            }
        }
    }
    public static void main(String args[]){
        int n=4;
        int m=5;

        int ar1[] = {1, 3, 5, 7};
        int ar2[]={0, 2, 6, 8, 9};
        merge(ar1,ar2,n,m);
    }
}
