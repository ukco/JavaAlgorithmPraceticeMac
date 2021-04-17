package com.lyr.test.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author lyr
 * @Date 4/17/21 10:07 PM
 * @Version 1.0
 * @Description 220. 存在重复元素III
 */
public class Solution220 {
    /**
     * 滑动窗口 + 有序集合
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 桶
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) { return true; }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) { return true; }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) { return true; }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }
    private long getId(long x, long w) {
        if (x >= 0) { return x / w; }
        return (x + 1) / w - 1;
    }
}
