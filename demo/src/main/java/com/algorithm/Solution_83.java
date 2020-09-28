package com.algorithm;

/**
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
