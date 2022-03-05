/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;

/**
 * @author Haojie
 * 1074. Ԫ�غ�ΪĿ��ֵ���Ӿ�������
 */
public class Submatrix {
    /**the num submatrix of the sumtarget */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //1. ö�����е����±߽�
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for(int top = 0; top < row; top++){
            int[] sum = new int[col];
            for(int bottom = top; bottom < row; bottom++){
                //  1.1 �����±߽�ת��һά����
                for(int i = 0; i < col; i++){
                    sum[i] += matrix[bottom][i];
                    // System.out.print(sum[i] + " ");
                }
                //  1.2 ����Ŀ���Ӿ������
                ans += numSubsectionSumTarget(sum, target);
            }
        }
        return ans;
        
    }
    
    /** the num of the Subsection which is equal to target*/
    public int numSubsectionSumTarget(int[] sum, int target){
        //  1. ��һά�������ǰ׺�ͼ��㣬��Map[preSum,count]�洢���е�ǰ׺��
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        //      ����һ��ǰ׺��Ϊ0��<key,value>, value=1
        map.put(0,1);
        int ans = 0;
        //  2. ÿ������һ��ǰ׺��newPreSum�������Ƿ���һ��OldSum�����㣺OldSum = k - newPreSum�����������ͳ�Ƹ������ۼ�
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
