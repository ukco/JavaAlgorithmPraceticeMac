package com.lyr.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020-11-20 23:13
 * @Version 1.0
 * @Description 1. 两数之和
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[] {map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        try {
            int[] res = new Solution1().twoSum(new int[] {3, 2, 4}, 6);
            for (int i : res) {
                System.out.println(i);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
