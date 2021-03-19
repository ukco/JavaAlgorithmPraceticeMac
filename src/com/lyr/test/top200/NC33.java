package com.lyr.test.top200;

import com.lyr.test.DataStructure.ListNode;

/**
 * @Author lyr
 * @Date 3/20/21 12:26 AM
 * @Version 1.0
 * @Description NC33. 合并有序链表
 */
public class NC33 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 != null) { prev.next = l1; }
        if (l2 != null) { prev.next = l2; }
        return preHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        else if (l2 == null) { return l1; }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
