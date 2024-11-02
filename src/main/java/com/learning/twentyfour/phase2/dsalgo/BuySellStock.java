package com.learning.twentyfour.phase2.dsalgo;

public class BuySellStock {
    public static void main(String[] args) {

//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int currMax = prices[prices.length-1];

        int maxProfit = 0;

        for (int i = prices.length-2; i >= 0; i--) {
            if(prices[i] > currMax) {
                currMax = prices[i];
            }

            maxProfit = Math.max(maxProfit, currMax - prices[i]);
        }

        return maxProfit;
    }
}
