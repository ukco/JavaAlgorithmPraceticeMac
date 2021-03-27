package com.lyr.test.leetcode;

import com.lyr.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 3/27/21 1:35 PM
 * @Version 1.0
 * @Description 61. 旋转链表
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) { return head; }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) { return head; }
        iter.next = head;
        while (add-- > 0) { iter = iter.next; }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
