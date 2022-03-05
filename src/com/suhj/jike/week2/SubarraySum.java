/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;

/**
 * @author Haojie
 * 560. ��Ϊ K ��������
 */
//1,1,1
//��������	       ǰ׺��      ���ִ���	   target=2����ʾ��Ҫ�ҵ�target-ǰ׺�ͳ��ֵĴ�����
//  0			0		   1		  0
//  1			1		   1		  0
//  2			2		   1          1
//  3           3		   1          1
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //1. �������飬����ǰ׺�ͣ���HashMap[preSum, cnt]����
        HashMap<Integer, Integer> preSumMap = new HashMap();
        int preSum = 0;
        int ans = 0;
        //����Ĭ��ֵ<key, value>=<0, 1>
        preSumMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            //2. ���ڵ�ǰǰ׺��pre[i]������HashMap����key=k-preSum��value�����д������ۼ�
            if(preSumMap.containsKey(preSum - k)){
                ans += preSumMap.get(preSum - k);
            }
            //3. ����ǰ[preSum, cnt]���½�HashMap
            if(preSumMap.containsKey(preSum)){
                preSumMap.put(preSum, preSumMap.get(preSum) + 1);
            }else{
                preSumMap.put(preSum, 1);
            }
        }
        
        return ans;
    }
}
