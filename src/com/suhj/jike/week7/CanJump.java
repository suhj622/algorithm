/**
 * 
 */
package com.suhj.jike.week7;

/**
����˼·��
f[i](i>=0,i<n) ��ʾ�Ƿ��ܵ���λ��i
����i��ֻҪ����f[j](0.....i-1)��ʹ�� j + num[j]>= i ˵����λ��i�ܴﵽ��
һ��i�㲻�ܵ���������λ��Ҳ���ܵ���
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >=0; j--){
                if(j + nums[j] >= i){
                    f[i] = true;
                    break;
                }
            }
            if(f[i] == false) break;

        }

        return f[n-1];
    }
}
