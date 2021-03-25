package com.lyr.test.top200;

import java.util.*;

/**
 * @Author lyr
 * @Date 3/25/21 8:43 PM
 * @Version 1.0
 * @Description NC119. 最小的K个数
 */
public class NC119 {
    public ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) { res.add(input[k]); }
        return res;
    }

    /**
     * 大顶堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbersSolution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) { return res; }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.add(input[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 快排思想
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbersSolution3(int[] input, int k) {
        if (k == 0 || input.length == 0) { return new ArrayList<>(); }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(input, 0, input.length - 1, k - 1);
    }
    private ArrayList<Integer> quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < j; i++) {
                res.add(nums[i]);
            }
            return res;
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }
    /**
     * 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (i <= hi && nums[i] < v) { i++; }
            while (j >= lo && nums[j] > v) { j--; }
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
