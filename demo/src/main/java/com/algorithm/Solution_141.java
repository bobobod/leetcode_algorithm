package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianzhen.yin
 * @date 2020/9/27
 */
public class Solution_141 {
    // 快指针追慢指针
    public static boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null){

            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return false;
            }
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode listNode = new ListNode(5);
        cur.next = listNode;

        boolean b = hasCycle(head);
        System.out.println(b);
    }
}
