package com.learning.twentythree.dsalgo.string;

import java.util.HashMap;
import java.util.Map;

public class StudentsUnableToEatLunch {
    public static void main(String[] args) {
        StudentsUnableToEatLunch studentsUnableToEatLunch = new StudentsUnableToEatLunch();
        int count = studentsUnableToEatLunch.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
        System.out.println(count);
    }

    public int countStudents(int[] students, int[] sandwiches) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 0);
        map.put(0, 0);

        for (int i = 0; i < students.length; i++) {
            map.put(students[i], map.get(students[i]) + 1);
        }

        for (int i = 0; i < sandwiches.length; i++) {
            int currentCount = map.get(sandwiches[i]);
            if (currentCount > 0) {
                map.put(sandwiches[i], currentCount - 1);
            } else {
                return map.get(0) + map.get(1);
            }
        }
        return 0;
    }
}
