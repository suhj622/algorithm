/**
 * 
 */
package com.suhj.jike.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Haojie
 * 课程表 II
 */
public class ClassSchedule {
    List<Stack<Integer>> toCourse = new ArrayList<>();
    int[] canFinishList ;
    int finishNum;
    int[] inDepth;
    Queue<Integer> learningQue;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1. 出边数组
        for(int i = 0; i < numCourses ; i++){
            toCourse.add(new Stack<>());
        }
        //求对应的入度数
        inDepth = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            toCourse.get(y).add(x);
            inDepth[x] ++;
        }
        
        //3. 从入度为0的课程开始遍历
        learningQue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDepth[i] == 0){
                learningQue.add(i);
            }
        }

        canFinishList = new int[numCourses];
        finishNum = -1;        
        bfs();

        //4. 能否完成所有课程
        //System.out.println(canFinishList);

        if((finishNum + 1) == numCourses){
            return canFinishList;
        }else{
            return new int[]{};
        }
    }
    private void bfs(){
        //学习当前课程
        while(!learningQue.isEmpty()){
            int course = learningQue.remove();
            finishNum ++;
            canFinishList[finishNum] = course;
            for(int nextCourse:toCourse.get(course)){
                inDepth[nextCourse]--;                
                if(inDepth[nextCourse] == 0){
                    learningQue.add(nextCourse);
                }                 
            }
        }
        
    } 
}
