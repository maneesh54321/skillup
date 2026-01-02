package com.learning.twentysix.slidingwindow;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            for(int i=0; i< code.length; i++) {
                code[i] = 0;
            }
            return code;
        }
        if(code.length == 1) return code;

        int[] res = new int[code.length];

        int right = k;
        int left = 1;
        if(k < 0) {
            right = code.length - 1;
            left = code.length + k;
        }
        int currSum = 0;
        for(int i = left; i <= right; i++) {
            currSum += code[i];
        }
        for(int i = 0; i < code.length; i++) {
            res[i] = currSum;
            currSum -= code[left];
            left = incrementIndex(left, code.length);
            
            right = incrementIndex(right, code.length);
            currSum += code[right];
        }
        return res;
    }

    public int incrementIndex(int idx, int circularArrLen) {
        if (idx + 1 >= circularArrLen) {
            return idx + 1 - circularArrLen;
        }
        return idx+1;
    }
}
