/**
 * 
 */
package com.suhj.jike.week6;
/**
解题思路：
10 9 2 5 3 7 101 18
1. 对于第i位的元素，统计以其结尾的序列的最长长度
i = 0  [10]
i = 1  [9]
i = 2  [2]
i = 3  [2, 5]
i = 4  [2, 3]
i = 5  [2, 5, 7] [2, 3, 7]
i = 6  [2, 5, 7, 101] [2, 3, 7, 101]
i = 7  [2, 5, 7, 18] [2, 3, 7, 18]
 第 i 位的最优解为可以排的前i-1个子序列中的最长序列长度 + 1
 添加一个计数，cnt[i]来记录递增子序列的个数
 */
public class FindNumberOfLIS {
	   public int findNumberOfLIS(int[] nums) {

	        int length = nums.length;
	        int[] f = new int[length];
	        int[] cnt = new int[length];
	        for(int i = 0; i < length; i++){
	            f[i] = 1;
	            cnt[i] = 1;
	        }

	        
	        
	        for(int i = 1; i < length; i++){
	            int max = f[i];
	            for(int j = 0; j < i; j++){
	                if(nums[i] > nums[j]){
	                    if(f[i] < f[j] + 1){
	                        f[i] = f[j] + 1;
	                        cnt[i] = cnt[j];
	                    }else if(f[i] == f[j] + 1){
	                        cnt[i] += cnt[j];
	                    }
	                }
	            }
	        }

	        int maxAns = f[0];
	        int maxCnt = cnt[0];
	        for(int i = 1; i < length; i++){
	            if(f[i] > maxAns){
	                maxAns = f[i];
	                maxCnt = cnt[i];
	            }else if(f[i] == maxAns){
	                maxCnt += cnt[i];
	            }
	        }        
	        return maxCnt;
	    }
}
