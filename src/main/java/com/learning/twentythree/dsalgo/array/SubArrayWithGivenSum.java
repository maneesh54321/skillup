package com.learning.twentythree.dsalgo.array;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        List.of(subarraySum(new int[]{1,2,3,4}, 4, 0)).forEach(System.out::println);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        if(s==0){
            return result;
        }
        int curSum = 0;
        int a = 0, b = -1;

        for (int i = 0; i < n; i++) {
            curSum +=arr[i];
            b++;
            while(curSum > s){
                curSum -= arr[a];
                a++;
            }
            if(curSum == s){
                result.clear();
                result.add(a+1);
                result.add(b+1);
                break;
            }
        }

        return result;
    }

    public void segregateElements(int arr[], int n)
    {
        int[] result = new int[n];
        int a=0, b=n-1;
        int i=0, j=n-1;
        while(i<n && j>-1){
            if(arr[j]<0){
                result[b] = arr[j];
                b--;
            }
            if(arr[i] >= 0){
                result[a] = arr[i];
                a++;
            }
            i++;
            j--;
        }
        System.arraycopy(result, 0, arr, 0, n);
    }
}
