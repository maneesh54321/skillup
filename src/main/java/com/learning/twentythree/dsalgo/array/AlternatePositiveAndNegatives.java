package com.learning.twentythree.dsalgo.array;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class AlternatePositiveAndNegatives {
    public static void main(String[] args) {
        int[] inputArr1 = new int[]{9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange(inputArr1, 9);
        IOUtils.printIntArray(inputArr1);
        System.out.println();
        int[] inputArr2 = new int[]{9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange_1(inputArr2, 9);
        IOUtils.printIntArray(inputArr2);
    }

    static void rearrange(int arr[], int n) {
        int negCount = 0;
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                negCount++;
            }
        }
        int[] parr = new int[n-negCount];
        int[] narr = new int[negCount];
        int p=0, k=0;
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                narr[k] = arr[i];
                k++;
            } else {
                parr[p] = arr[i];
                p++;
            }
        }
        p=0; k=0;
        int i=0;
        while (p < parr.length && k < narr.length){
            if(i%2==0){
                arr[i] = parr[p];
                p++;
            } else {
                arr[i] = narr[k];
                k++;
            }
            i++;
        }
        if(p < parr.length){
            while(p < parr.length){
                arr[i] = parr[p];
                p++;
                i++;
            }
        } else {
            while(k < narr.length){
                arr[i] = narr[k];
                k++;
                i++;
            }
        }
    }

    static void rearrange_1(int arr[], int n) {
        int i=0, k=0;
        while(i<n){
            k=i+1;
            if(i%2==0 && arr[i]<0){
                while(k<n){
                    if(arr[k]>0){
                        rightRotateByOne(arr, i, k);
                    }
                    k++;
                }
                if(arr[i]<0){
                    break;
                }
            } else if(i%2==1 && arr[i]>=0){
                while(k<n){
                    if(arr[k]<0){
                        rightRotateByOne(arr, i, k);
                        break;
                    }
                    k++;
                }
                if(arr[i]>=0){
                    break;
                }
            }
            i++;
        }
    }

    static void rightRotateByOne(int[] arr, int l, int r){
        int tmp = arr[r];
        for (int i = l+1; i <= r; i++) {
            arr[i] = arr[i-1];
        }
        arr[l] = tmp;
    }
}
