package com.algorithm;

/**
 * @author jianzhen.yin
 * @date 2020/9/27
 */
public class Solution_70 {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n-1];
    }
}
