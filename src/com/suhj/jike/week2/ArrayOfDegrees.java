/**
 * 
 */
package com.suhj.jike.week2;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Haojie
 * 697. ����Ķ�
 */
public class ArrayOfDegrees {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Stack<Integer>> elementDegreeMap = new HashMap<>();
        Stack<Integer> stack = new Stack();
        int currentDegree;
        //1. ���������е�Ԫ�أ������ȵ�Ԫ��ջ
        for(int i = 0; i < nums.length; i++){
            //  1.1 ����Ԫ�صĶȣ�����������ֵ
            if(!elementDegreeMap.containsKey(nums[i])){
                Stack<Integer> indexVector = new Stack();
                elementDegreeMap.put(nums[i], indexVector);
            }
            elementDegreeMap.get(nums[i]).push(i);
            currentDegree = elementDegreeMap.get(nums[i]).size();

            //  1.2 ��ջ��С�Ķȵ����� ������ ������ͬԪ�صģ���ջ���ĳ�ջ
            while( !stack.empty() && (elementDegreeMap.get(stack.peek()).size() < currentDegree || stack.peek() == nums[i])){
                stack.pop();
            }

            //  1.3 ��ջ����һ���������ʱջΪ�գ���ǰ����󣻵ڶ����������ǰ����ջ�����൱
            //      С�ڵ�ǰջ����������
            if(stack.empty() || elementDegreeMap.get(stack.peek()).size() == currentDegree){
                stack.push(nums[i]);
            }
        }

        //2. ����ջ�������������������
        int minDegree = 50_001;
        for(Integer item:stack){
            minDegree = Math.min(minDegree, elementDegreeMap.get(item).peek() - elementDegreeMap.get(item).get(0) + 1);
            // System.out.println(item+":"+elementDegreeMap.get(item));
        }
        
        return minDegree; 

    }	
}
