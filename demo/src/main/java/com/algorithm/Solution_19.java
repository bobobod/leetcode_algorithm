package com.algorithm;

/**
 * @author jianzhen.yin
 * @date 2020/9/27
 */
public class Solution_19 {
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0,head);
        ListNode cur = result;
        for (int i = 0; i < n - 1; i++) {
            head = head.next;
        }
        while(head.next != null){
            head = head.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return result.next;
    }
}
