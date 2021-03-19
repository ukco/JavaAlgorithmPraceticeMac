package com.lyr.test.interview;

import com.lyr.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 3/19/21 8:14 PM
 * @Version 1.0
 * @Description 单链表翻转
 */
public class Test5 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { return head; }

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
