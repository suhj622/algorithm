/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;

/**
 * @author Haojie
 * 560. 和为 K 的子数组
 */
//1,1,1
//迭代次数	       前缀和      出现次数	   target=2（表示需要找到target-前缀和出现的次数）
//  0			0		   1		  0
//  1			1		   1		  0
//  2			2		   1          1
//  3           3		   1          1
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //1. 遍历数组，计算前缀和，用HashMap[preSum, cnt]保存
        HashMap<Integer, Integer> preSumMap = new HashMap();
        int preSum = 0;
        int ans = 0;
        //插入默认值<key, value>=<0, 1>
        preSumMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            //2. 对于当前前缀和pre[i]，先在HashMap查找key=k-preSum的value，进行次数的累加
            if(preSumMap.containsKey(preSum - k)){
                ans += preSumMap.get(preSum - k);
            }
            //3. 将当前[preSum, cnt]更新进HashMap
            if(preSumMap.containsKey(preSum)){
                preSumMap.put(preSum, preSumMap.get(preSum) + 1);
            }else{
                preSumMap.put(preSum, 1);
            }
        }
        
        return ans;
    }
}
