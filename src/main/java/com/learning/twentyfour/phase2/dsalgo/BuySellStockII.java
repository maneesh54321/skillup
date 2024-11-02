package com.learning.twentyfour.phase2.dsalgo;

public class BuySellStockII {

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int prev = prices[0];

        int profit = 0;

        for (int i = 1; i < prices.length - 1; i++) {
            int curr = prices[i];

            if(curr > prev) profit += curr - prev;
            prev = curr;

        }

        return profit;
    }
}
