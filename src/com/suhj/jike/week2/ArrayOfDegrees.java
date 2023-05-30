/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Haojie
 * 697. 数组的度
 */
public class ArrayOfDegrees {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Stack<Integer>> elementDegreeMap = new HashMap<>();
        Stack<Integer> stack = new Stack();
        int currentDegree;
        //1. 遍历数组中的元素，将最大度的元素栈
        for(int i = 0; i < nums.length; i++){
            //  1.1 计算元素的度，保存其索引值
            if(!elementDegreeMap.containsKey(nums[i])){
                Stack<Integer> indexVector = new Stack();
                elementDegreeMap.put(nums[i], indexVector);
            }
            elementDegreeMap.get(nums[i]).push(i);
            currentDegree = elementDegreeMap.get(nums[i]).size();

            //  1.2 出栈：小的度的索引 或者是 遇到相同元素的，将栈顶的出栈
            while( !stack.empty() && (elementDegreeMap.get(stack.peek()).size() < currentDegree || stack.peek() == nums[i])){
                stack.pop();
            }

            //  1.3 入栈：第一种情况，此时栈为空，当前度最大；第二种情况，当前度与栈顶度相当
            //      小于当前栈顶的则跳过
            if(stack.empty() || elementDegreeMap.get(stack.peek()).size() == currentDegree){
                stack.push(nums[i]);
            }
        }

        //2. 遍历栈，计算最大度最短子数组
        int minDegree = 50_001;
        for(Integer item:stack){
            minDegree = Math.min(minDegree, elementDegreeMap.get(item).peek() - elementDegreeMap.get(item).get(0) + 1);
            // System.out.println(item+":"+elementDegreeMap.get(item));
        }
        
        return minDegree; 

    }	
}
