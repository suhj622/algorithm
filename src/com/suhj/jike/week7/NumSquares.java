/**
 * 
 */
package com.suhj.jike.week7;

import java.util.Arrays;

/**
����˼·��
f[n] ��ʾ����ɺ�Ϊn����ȫƽ��������������
ö�� i [1...... sqrt(n) ] 
���� j (j>=i^2, j<=n)��f[j] = min(f[j], f[j-i^2] + 1)
���� f[n]
(����Ŀһ���д𰸣�������n��1��Ϊ���״�)
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        Arrays.fill(f, 10_000_000);
        //f[0] Ϊ�߽�
        f[0] = 0;
        int up = (int)Math.sqrt(n);
        for(int i = 1; i <= up; i++)
            for(int j = i * i ; j <= n; j++){
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        return f[n];
    }
}
