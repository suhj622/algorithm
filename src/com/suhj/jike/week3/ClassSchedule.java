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
 * �γ̱� II
 */
public class ClassSchedule {
    List<Stack<Integer>> toCourse = new ArrayList<>();
    int[] canFinishList ;
    int finishNum;
    int[] inDepth;
    Queue<Integer> learningQue;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1. ��������
        for(int i = 0; i < numCourses ; i++){
            toCourse.add(new Stack<>());
        }
        //���Ӧ�������
        inDepth = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            toCourse.get(y).add(x);
            inDepth[x] ++;
        }
        
        //3. �����Ϊ0�Ŀγ̿�ʼ����
        learningQue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDepth[i] == 0){
                learningQue.add(i);
            }
        }

        canFinishList = new int[numCourses];
        finishNum = -1;        
        bfs();

        //4. �ܷ�������пγ�
        //System.out.println(canFinishList);

        if((finishNum + 1) == numCourses){
            return canFinishList;
        }else{
            return new int[]{};
        }
    }
    private void bfs(){
        //ѧϰ��ǰ�γ�
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
