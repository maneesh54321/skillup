package com.learning.twentythree.dsalgo.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {900, 940, 950, 955, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1100, 1130, 1900, 2000};
        System.out.println(new MinimumPlatforms().findPlatform(arr, dep, n));
    }

    private int findPlatform(int[] arr, int[] dep, int n) {
        int maxPlatformNeeded = 1;

        TrainSchedule[] schedules = new TrainSchedule[n];
        for (int i = 0; i < n; i++) {
            schedules[i] = new TrainSchedule(arr[i], dep[i]);
        }

        Arrays.sort(schedules);
        Comparator<TrainSchedule> comparator = Comparator.comparingInt(TrainSchedule::getDepTime);

        PriorityQueue<TrainSchedule> priorityQueue = new PriorityQueue<>(comparator);

        priorityQueue.add(schedules[0]);

        for (int i = 1; i < n; i++) {
            if (priorityQueue.peek().getDepTime() > schedules[i].getArrTime()) { // if min dep time is greater than arrival time of current train
                maxPlatformNeeded++;
            } else if(priorityQueue.peek().getDepTime() <= schedules[i].getArrTime()){ // if min dep time is <= arrival time of current train
                priorityQueue.remove();
            }
            priorityQueue.add(schedules[i]);
        }

        return maxPlatformNeeded;
    }

    class TrainSchedule implements Comparable {
        private int arrTime;
        private int depTime;

        public TrainSchedule(int arrTime, int depTime) {
            this.arrTime = arrTime;
            this.depTime = depTime;
        }

        public int getArrTime() {
            return arrTime;
        }

        public int getDepTime() {
            return depTime;
        }

        @Override
        public int compareTo(Object o) {
            TrainSchedule t2 = (TrainSchedule) o;
            if (this.arrTime == t2.arrTime) {
                return 0;
            }
            return this.arrTime < t2.arrTime ? -1 : 1;
        }
    }


}
