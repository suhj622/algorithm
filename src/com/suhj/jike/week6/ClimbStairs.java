/**
 * 
 */
package com.suhj.jike.week6;

/**
 * @author Haojie
 * 解题思路：
 * 可以分解为到达第n阶，能有多少种走法，最后一步可能走一步或两步
 * f(n) = + f(n - 1) + f(n - 2)
 */

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(i == 0 || i == 1) ways[i] = 1;
            else ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}
