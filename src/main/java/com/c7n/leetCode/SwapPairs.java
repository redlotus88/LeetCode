package com.c7n.leetCode;

import com.c7n.leetCode.bean.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(4);
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        swapPairs(test1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        head.next = cur.next;
        cur.next = head;
        swapPairs(head, head.next);
        return cur;
    }

    public static ListNode swapPairs(ListNode prev, ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode tmp = next.next;
        prev.next = next;
        next.next = head;
        head.next = tmp;
        return swapPairs(head, head.next);
    }
}
