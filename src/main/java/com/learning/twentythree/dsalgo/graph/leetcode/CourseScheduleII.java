package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseScheduleII {

    public static void main(String[] args) {

    }

    public int[] findOrder_1(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int r = 0;

        int[] inDegrees = new int[numCourses];
        boolean[][] edges = new boolean[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            edges[prerequisite[1]][prerequisite[0]] = true;
            inDegrees[prerequisite[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()){
            int front = q.poll();
            result[r++] = front;

            for (int i = 0; i < numCourses; i++) {
                if(edges[front][i]){
                    inDegrees[i]--;
                    if(inDegrees[i] == 0){
                        q.offer(i);
                    }
                }
            }

        }

        if(r == numCourses-1){
            return result;
        } else {
            return new int[0];
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int r = 0;

        Course[] vertices = new Course[numCourses];

        for (int i = 0; i < numCourses; i++) {
            vertices[i] = new Course(i, 0);
        }

        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite: prerequisites) {
            vertices[prerequisite[1]].addDependentCourse(vertices[prerequisite[0]]);
            inDegrees[prerequisite[0]]++;
        }

        Deque<Course> q = new ArrayDeque<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                q.offer(vertices[i]);
            }
        }

        while (!q.isEmpty()){
            Course front = q.poll();
            result[r++] = front.label;
            for (Course dependentCourse: front.dependentCourses){
                inDegrees[dependentCourse.label]--;
                if(inDegrees[dependentCourse.label] == 0)
                    q.offer(dependentCourse);
            }
        }

        if( r == numCourses){
            return result;
        } else {
            return new int[0];
        }

    }


    private static class Course {
        int label;
        int color;
        List<Course> dependentCourses = new ArrayList<>();

        public Course(int label, int color) {
            this.label = label;
            this.color = color;
        }

        public void addDependentCourse(Course dependentCourse) {
            this.dependentCourses.add(dependentCourse);
        }
    }
}
