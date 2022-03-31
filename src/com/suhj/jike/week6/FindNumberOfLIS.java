/**
 * 
 */
package com.suhj.jike.week6;
/**
����˼·��
10 9 2 5 3 7 101 18
1. ���ڵ�iλ��Ԫ�أ�ͳ�������β�����е������
i = 0  [10]
i = 1  [9]
i = 2  [2]
i = 3  [2, 5]
i = 4  [2, 3]
i = 5  [2, 5, 7] [2, 3, 7]
i = 6  [2, 5, 7, 101] [2, 3, 7, 101]
i = 7  [2, 5, 7, 18] [2, 3, 7, 18]
 �� i λ�����Ž�Ϊ�����ŵ�ǰi-1���������е�����г��� + 1
 ���һ��������cnt[i]����¼���������еĸ���
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
