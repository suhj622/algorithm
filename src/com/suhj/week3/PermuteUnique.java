/**
 * 
 */
package com.suhj.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Haojie
 *  ȫ���� II
 */
public class PermuteUnique {
	// 1    1   2
	//��һ��ѡ1  1, 2     2,1
	//�ڶ���ѡ1  ����
	//������ѡ2  1,1      ����
	//�������Ϊ��i��ѡ��j��������


	    private boolean[] used;
	    private List<List<Integer>> ans = new ArrayList<>();
	    private Stack<Integer> stack = new Stack<>();
	    private int[] nums;
	    private int length;
	    
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        this.nums = nums;
	        this.length = nums.length;
	        used = new boolean[this.length];
	        //������������
	        Arrays.sort(nums);
	        choseAndCombine();
	        return ans;
	    }

	    private void choseAndCombine(){
	        if(stack.size() == this.length){
	            List<Integer> list = new ArrayList<>(stack);
	            ans.add(list);
	        }

	        int lastChose = -11;
	        for(int i = 0; i < this.length; i++){
	            //���ѡ�������ϴ�ѡ��һ��������
	            if(!used[i]){
	                if(nums[i] == lastChose){
	                    continue;
	                }
	                used[i] = true;
	                stack.push(this.nums[i]);
	                choseAndCombine();
	                stack.pop();
	                used[i] = false;
	                lastChose = this.nums[i];
	            }
	            
	        }
	    }
}
