/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;

/**
 * @author Haojie
 * 1074. 元素和为目标值的子矩阵数量
 */
public class Submatrix {
    /**the num submatrix of the sumtarget */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //1. 枚举所有的上下边界
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for(int top = 0; top < row; top++){
            int[] sum = new int[col];
            for(int bottom = top; bottom < row; bottom++){
                //  1.1 将上下边界转成一维数组
                for(int i = 0; i < col; i++){
                    sum[i] += matrix[bottom][i];
                    // System.out.print(sum[i] + " ");
                }
                //  1.2 计算目标子矩阵个数
                ans += numSubsectionSumTarget(sum, target);
            }
        }
        return ans;
        
    }
    
    /** the num of the Subsection which is equal to target*/
    public int numSubsectionSumTarget(int[] sum, int target){
        //  1. 对一维数组进行前缀和计算，用Map[preSum,count]存储所有的前缀和
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        //      加入一个前缀和为0的<key,value>, value=1
        map.put(0,1);
        int ans = 0;
        //  2. 每新生成一个前缀和newPreSum，查找是否有一个OldSum，满足：OldSum = k - newPreSum，满足则进行统计个数的累加
        for(int item:sum){
            preSum += item;
            int oldPreSum = preSum - target;
            if(map.containsKey(preSum - target)){
                ans += map.get(oldPreSum);
            }
            if(map.containsKey(preSum)){
                map.put(preSum, map.get(preSum) + 1);
            }else{
                map.put(preSum, 1);
            }
        }
        return ans;
    }
}
