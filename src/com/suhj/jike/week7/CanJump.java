/**
 * 
 */
package com.suhj.jike.week7;

/**
解题思路：
f[i](i>=0,i<n) 表示是否能到达位置i
对于i，只要存在f[j](0.....i-1)，使得 j + num[j]>= i 说明，位置i能达到；
一旦i点不能到达，则后续的位置也不能到达
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
