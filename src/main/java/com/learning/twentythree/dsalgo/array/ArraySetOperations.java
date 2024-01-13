package com.learning.twentythree.dsalgo.array;

public class ArraySetOperations {
    public static void main(String[] args) {
        System.out.println(doUnion(new int[]{1, 2, 3, 4, 5, 6, 8 , 6, 9, 4}, 10, new int[]{1, 2, 3, 10, 2, 4, 4}, 7));
    }

    public static int doUnion(int a[], int n, int b[], int m)
    {
        mergeSortArr(a, 0 , n-1);
        mergeSortArr(b, 0, m-1);
        return unionTwoSortedArr(a, n , b, m);
    }

    static void mergeSortArr(int arr[], int l, int r){
        if(r>l){
            int m = l + (r-l)/2;
            mergeSortArr(arr, l, m);
            mergeSortArr(arr, m+1, r);
            merge(arr, l, m, m+1, r);
        }
    }

    static void merge(int arr[], int a, int b, int c, int d){
        int[] outArr = new int[(b-a)+1+(d-c)+1];
        int i = 0, l = a;
        while(a<=b && c<=d){
            if(arr[a] <= arr[c]){
                outArr[i] = arr[a];
                a++;
            } else {
                outArr[i] = arr[c];
                c++;
            }
            i++;
        }
        if(a>b){
            while(c<=d){
                outArr[i] = arr[c];
                c++;
                i++;
            }
        } else {
            while(a<=b){
                outArr[i] = arr[a];
                a++;
                i++;
            }
        }
        i=0;
        for (int j=l; j<=d; j++){
            arr[j] = outArr[i];
            i++;
        }
    }

    static int unionTwoSortedArr(int[] arra, int n, int[] arrb, int m){
        int[] outArr = new int[n+m];
        int al = 0, bl = 0, i=0;
        while(al < n && bl < m){
            if(arra[al] < arrb[bl]){
                outArr[i] = arra[al];
                al++;
            } else if(arrb[bl] < arra[al]) {
                outArr[i] = arrb[bl];
                bl++;
            } else {
                outArr[i] = arra[al];
                al++;
                bl++;
            }
            i++;
        }
        if(al==n){
            while(bl<m){
                outArr[i] = arrb[bl];
                bl++;
                i++;
            }
        } else {
            while(al<n){
                outArr[i] = arra[al];
                al++;
                i++;
            }
        }
        int lastele = outArr[0];
        int k = 1;
        for(int j = 0; j<i; j++){
            if(lastele != outArr[j]){
                k++;
                lastele = outArr[j];
            }
        }
        return k;

    }
}
