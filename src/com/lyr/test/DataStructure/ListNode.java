package com.lyr.test.DataStructure;

/**
 * @Author lyr
 * @Date 2020-11-21 23:32
 * @Version 1.0
 * @Description
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
