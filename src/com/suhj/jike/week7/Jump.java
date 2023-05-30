/**
 * 
 */
package com.suhj.jike.week7;

import java.util.Arrays;

/**
解题思路（动态规划）：
对于i位置的元素num[i]，能到达它所花费的步数为f[i]
f[i] = min(f[0.....j]) + 1,
对于j 需满足 j>=0,j<i；且 j + nums[j] >= i
相对于贪心，时间复杂度为O(n^2)，执行用时处于边缘位置
 */
public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 10_1000_1000);
        f[0] = 0;
        for(int i = 1; i < n; i++)
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i) f[i] = Math.min(f[i], f[j] + 1);
            }
        return f[n-1];
    }
}
