/**
 * 
 */
package com.suhj.jike.week7;

import java.util.Arrays;

/**
����˼·����̬�滮����
����iλ�õ�Ԫ��num[i]���ܵ����������ѵĲ���Ϊf[i]
f[i] = min(f[0.....j]) + 1,
����j ������ j>=0,j<i���� j + nums[j] >= i
�����̰�ģ�ʱ�临�Ӷ�ΪO(n^2)��ִ����ʱ���ڱ�Եλ��
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
