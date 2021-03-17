package com.lyr.test.top200;

import com.lyr.test.DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 3/18/21 2:41 AM
 * @Version 1.0
 * @Description NC4. 判断链表中是否有环
 */
public class NC4 {
    /**
     * 快慢指针
     * 一个指针走两步 一个指针走一步，如果快指针直接到了null 说明没有环。
     * 如果有环的话 总有一次结果会让快指针和慢指针相等。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) { return true; }
        }
        return false;
    }

    /**
     * 借助集合Set
     * 每次存放的时候判断当前节点是否存在，如果存在，说明有环，直接返回true
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) { return true; }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 逐个删除
     * 一个链表从头节点开始一个个删除，所谓删除就是让他的next指针指向他自己。
     * 如果没有环，从头结点一个个删除，最后肯定会删完。
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) { return false; }
        if (head.next == head) { return true; }
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle3(nextNode);
    }
}
