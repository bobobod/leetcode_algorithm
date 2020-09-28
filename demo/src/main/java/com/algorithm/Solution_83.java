package com.algorithm;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author jianzhen.yin
 * @date 2020/9/27
 */
public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        ListNode cur = result;
        head = head.next;
        while (head != null){
            if (cur.val == head.val){
                cur.next = head.next;
            }else {
                cur = cur.next;
            }
            head = head.next;
        }
        return result;
    }
}
