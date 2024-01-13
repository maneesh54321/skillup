package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange main = new CoinChange();
        System.out.println(main.minNumOfCoinsTopDown(new int[]{1, 2, 5}, 11));

        int amount = 3;
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        System.out.println(main.minNumOfCoins(new int[]{2}, amount, memo));
    }

    public int minNumOfCoins(int[] coins, int amount, int[] memo) {
        if (memo[amount] != -1) {
            return memo[amount];
        } else {
            int result;
            if (amount == 0) {
                result = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (amount >= coin) {
                        int minCoinsForLeftAmount = minNumOfCoins(coins, amount - coin, memo);
                        if (minCoinsForLeftAmount != -1) {

                            min = Math.min(minCoinsForLeftAmount, min);
                        }
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    result = -1;
                } else {
                    result = 1 + min;
                }
            }
            memo[amount] = result;
            return result;
        }
    }

    public int minNumOfCoinsTopDown(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount+1);
        memo[0] = 0;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    memo[i] = Math.min(1 + memo[i - coins[j]], memo[i]);
                }
            }
        }

        if(memo[amount] == amount + 1){
            return -1;
        }

        return memo[amount];
    }
}
