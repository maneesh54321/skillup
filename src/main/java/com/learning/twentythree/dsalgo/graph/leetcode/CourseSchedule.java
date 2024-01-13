package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule main = new CourseSchedule();

        System.out.println(main.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(main.canFinish(2, new int[][]{{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Course> nodes = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            nodes.add(new Course(i, 0));
        }

        for (int[] prerequisite : prerequisites) {
            nodes.get(prerequisite[0]).addDependentCourse(nodes.get(prerequisite[1]));
        }

        for (Course node : nodes) {
            if (isCyclic(node)) {
                return false;
            }
        }
        return true;
    }


    public boolean isCyclic(Course src) {
        Deque<Course> stack = new ArrayDeque<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            Course top = stack.peek();
            boolean coursesLeft = false;
            for (Course dependentCourse : top.dependentCourses) {
                if (dependentCourse.color == 0) {
                    stack.push(dependentCourse);
                    coursesLeft = true;
                } else if (dependentCourse.color == 1) {
                    return true;
                }
            }
            if(!coursesLeft) {
                top.color = 2;
                stack.pop();
            } else {
                top.color = 1;
            }
        }

        return false;
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
