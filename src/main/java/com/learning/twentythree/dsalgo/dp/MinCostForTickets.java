package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class MinCostForTickets {

    int[] PASS = new int[]{1, 7, 30};

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};

        int[] costs = new int[]{2, 7, 15};

        MinCostForTickets main = new MinCostForTickets();

        int[] memo = new int[days.length];

        Arrays.fill(memo, -1);

        System.out.println(main.minCost(days, costs, 0, memo));



        days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};

        costs = new int[]{2,7,15};

        memo = new int[days.length];

        Arrays.fill(memo, -1);

        System.out.println(main.minCost(days, costs, 0, memo));
    }

    public int minCost(int[] days, int[] costs, int startingDayIndex, int[] memo) {
        if(startingDayIndex >= days.length){
            return 0;
        }
        if(memo[startingDayIndex] != -1){
            System.out.println("Returning memoized value!!!");
            return memo[startingDayIndex];
        } else {
            System.out.println("Calculating...");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < costs.length; i++) {
                int cost = costs[i];
                int currentDayIndex = startingDayIndex;
                int coveredTillDay = days[startingDayIndex] + PASS[i] - 1;
                while (currentDayIndex < days.length && days[currentDayIndex] <= coveredTillDay) {
                    currentDayIndex++;
                }
                min = Math.min(min, cost + minCost(days, costs, currentDayIndex, memo));
            }

            memo[startingDayIndex] = min;
            return min;
        }
    }
}
