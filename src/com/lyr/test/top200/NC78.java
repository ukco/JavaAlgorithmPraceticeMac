package com.lyr.test.top200;

import com.lyr.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 3/15/21 11:25 PM
 * @Version 1.0
 * @Description NC78. 翻转链表
 */
public class NC78 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }

        ListNode pre = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
