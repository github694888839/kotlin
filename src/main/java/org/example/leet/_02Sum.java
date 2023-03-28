package org.example.leet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _02Sum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode tempNext = null;
        int a10 = 0;
        do {
            int value = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + a10;
            int a0 = value % 10;
            a10 = value / 10;
            if (first == null) {
                first = new ListNode(a0);
                tempNext = first;
            } else {
                tempNext.next = new ListNode(a0);
                tempNext = tempNext.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        } while (l1 != null || l2 != null || a10 != 0);
        return first;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode listNode2 = new ListNode(3, new ListNode(4, new ListNode(5)));
        System.out.println(addTwoNumbers(listNode1, listNode2));
    }
}