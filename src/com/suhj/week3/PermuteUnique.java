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
 *  全排列 II
 */
public class PermuteUnique {
	// 1    1   2
	//第一个选1  1, 2     2,1
	//第二个选1  跳过
	//第三个选2  1,1      跳过
	//把问题简化为第i个选第j个的问题


	    private boolean[] used;
	    private List<List<Integer>> ans = new ArrayList<>();
	    private Stack<Integer> stack = new Stack<>();
	    private int[] nums;
	    private int length;
	    
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        this.nums = nums;
	        this.length = nums.length;
	        used = new boolean[this.length];
	        //对数组做排序
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
	            //这次选的数跟上次选的一样大，跳过
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
