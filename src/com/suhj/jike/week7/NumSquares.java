/**
 * 
 */
package com.suhj.jike.week7;

import java.util.Arrays;

/**
解题思路：
f[n] 表示能组成和为n的完全平方数的最少数量
枚举 i [1...... sqrt(n) ] 
对于 j (j>=i^2, j<=n)，f[j] = min(f[j], f[j-i^2] + 1)
返回 f[n]
(该题目一定有答案，起码有n个1作为保底答案)
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        Arrays.fill(f, 10_000_000);
        //f[0] 为边界
        f[0] = 0;
        int up = (int)Math.sqrt(n);
        for(int i = 1; i <= up; i++)
            for(int j = i * i ; j <= n; j++){
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        return f[n];
    }
}
