package com.lyr.test.top200;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lyr
 * @Date 9/5/21 11:19 AM
 * @Version 1.0
 * @Description NC88 寻找第K大
 */
public class NC88 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        if (a == null || K > n || K == 0) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });

        for (int i = 0; i < n; ++i) {
            if (queue.size() < K) {
                queue.offer(a[i]);
            } else if (queue.peek() < a[i]) {
                queue.poll();
                queue.offer(a[i]);
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new NC88().findKth(new int[] {10,10,9,9,8,7,5,6,4,3,4,2}, 12, 3));
    }
}
