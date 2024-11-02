package com.learning.twentyfour.phase2.dsalgo;

public class GasStation {

	public static void main(String[] args) {
//		int[]  gas = {1,2,3,4,5};
//		int[] cost = {3,4,5,1,2};

		int[] gas = {2,3,4}, cost = {3,4,3};

		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGasLeft = 0;
		int currGasLeft = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {
			int net = gas[i] - cost[i];
			currGasLeft += net;
			totalGasLeft += net;

			if(currGasLeft < 0 ) {
				start = i+1;
				currGasLeft = 0;
			}
		}
		return totalGasLeft >=0 ? start : -1;
	}

}
