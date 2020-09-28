package com.algorithm;

/**
 * @author jianzhen.yin
 * @date 2020/9/25
 */
public class Solution_27 {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                len--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        int i1 = removeElement(a, 2);
        for (int i = 0; i < i1; i++) {
            System.out.println(a[i]);
        }
    }
}
