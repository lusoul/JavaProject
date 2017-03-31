package com.caden.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

public class TaskCoolDown {
    public static void main(String[] args) {
        /*
        *   Test case:
        *   1,2,1,2,3,3,5 -> cooldown : 4 = result: 14
        *   3,2,2,2,3 -> cooldown: 4 = result: 13
        *   1,1,2,3,2 -> cooldown: 2 = result: 8
        *   3,2,2,1,3 -> cooldown: 4 = result: 9
        *   1 -> cooldown: 4 = result: 1
        *   8,8,8,1,3,1,6,9,5 -> cooldown: 4 = result: 20
        * */
        int[] tasks = {8,8,8,1,3,1,6,9,5};
        int cooldown = 4;
        System.out.println(cal(tasks, cooldown));
    }

    public static int cal(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                int offset = idx - map.get(tasks[i]);
                if (offset <= cooldown) {
                    idx = idx + cooldown - offset + 1;
                }
                map.put(tasks[i], idx);
                idx++;
            } else {
                map.put(tasks[i], idx);
                idx++;
            }
        }
        return idx;
    }
}
