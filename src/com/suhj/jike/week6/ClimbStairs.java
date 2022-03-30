/**
 * 
 */
package com.suhj.jike.week6;

/**
 * @author Haojie
 * ����˼·��
 * ���Էֽ�Ϊ�����n�ף����ж������߷������һ��������һ��������
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
