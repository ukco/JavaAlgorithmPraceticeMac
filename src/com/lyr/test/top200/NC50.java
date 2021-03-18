package com.lyr.test.top200;

import com.lyr.test.DataStructure.ListNode;

import java.util.Stack;

/**
 * @Author lyr
 * @Date 3/16/21 11:01 PM
 * @Version 1.0
 * @Description NC50. 链表中的节点每k个一组翻转
 */
public class NC50 {
    /**
     * 头插法思想
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) { return head; }
        ListNode res = new ListNode(0);
        res.next = head;
        int length = 0;
        ListNode pre = res, cur = head, temp = null;
        while (head != null) {
            ++length;
            head = head.next;
        }
        // 分段使用头插法将链表反序
        for (int i = 0; i < length / k; i++) {
            // pre作为每一小段链表的头节点，负责衔接
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                // 相当于头插法，注意：
                // temp.next = cur 是错误的，temp需要连接的不是前一节点，而是子序列的头节点
                temp.next = pre.next;
                pre.next = temp;
            }
            // 每个子序列反序完成后，pre，cur需要更新至下一子序列的头部
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }

    /**
     * 栈
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode ret = new ListNode(0);
        ListNode p = ret;

        while (true) {
            // 为每次反转计数
            int count = 0;
            ListNode tmp = head;
            // 循环入栈
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            // 判断该次反转是否达到要求，此处防止因 tmp==null 跳出循环的条件
            if (count != k) {
                // 表示剩下的节点不够k个，直接将剩余节点插入末尾结束
                p.next = head;
                break;
            }
            // 出栈操作
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            // 重制下一次操作的初始节点
            p.next = tmp;
            head = tmp;
        }
        return ret.next;
    }

    /**
     * 模拟
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始化pre和end都指向dummy。pre指向每次要翻转的链表的头结点的上一个节点。
        // end指向每次要翻转的链表的尾节点
        ListNode pre = dummy, end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) { end = end.next; }
            if (end == null) { break; }
            // 先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            // 然后断开链表
            end.next = null;
            // 记录下要翻转链表的头节点
            ListNode start = pre.next;
            // 翻转链表, pre.next指向翻转后的链表。1->2 变成2->1。
            // dummy->2->1
            pre.next = reverse(start);
            // 翻转后头节点变到最后。通过 next 把断开的链表重新链接。
            start.next = next;
            // 将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            // 翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。
            // 即start
            end = start;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        // 单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) { return head; }

        // 前一个节点指针
        ListNode preNode = null;
        // 当前节点指针
        ListNode curNode = head;
        // 下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     * 递归
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup4(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse2(head, tail);
        head.next = reverseKGroup4(tail, k);
        return newHead;
    }
    private ListNode reverse2(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
