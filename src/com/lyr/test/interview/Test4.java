package com.lyr.test.interview;

import java.util.*;

/**
 * @Author lyr
 * @Date 3/19/21 7:12 PM
 * @Version 1.0
 * @Description leecode 347.前K个高频元素https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class Test4 {
    /**
     * 堆
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) { occurrences.put(num, occurrences.getOrDefault(num, 0) + 1); }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < k) {
                    queue.poll();
                    queue.offer(new int[] {num, count});
                }
            } else {
                queue.offer(new int[] {num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) { occurrences.put(num, occurrences.getOrDefault(num, 0) + 1); }

        List<Integer>[] list = new List[nums.length + 1];
        for (int key : occurrences.keySet()) {
            int i = occurrences.get(key);
            if (list[i] == null) { list[i] = new ArrayList<>(); }
            list[i].add(key);
        }
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1; i >= 0 && res.size() < k; i--){
            if(list[i] == null) { continue; }
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 基于快速排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) { occurrences.put(num, occurrences.getOrDefault(num, 0) + 1); }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[] {num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }
    private void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
