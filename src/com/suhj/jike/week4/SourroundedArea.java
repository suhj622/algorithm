/**
 * 
 */
package com.suhj.jike.week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Haojie
 * 被围绕的区域
 */
public class SourroundedArea {
    boolean[][] used;
    private int length;
    private int width;
    private char[][] board;
    private Stack<Pair> area = new Stack<>();
    private static final int[] dirX = {-1, 0, 0, 1}; 
    private static final int[] dirY = {0, -1, 1, 0};

    public void solve(char[][] board) {
        this.length = board.length;
        this.width = board[0].length;
        this.board = board;
        used = new boolean[this.length][this.width];

        //1. 扫描board
        for(int m = 0; m < this.length; m++){
            for(int n = 0; n < this.width; n++){
                //2. 遍历过的点记录为true，且第一次遇到的O查找连通块
                if(!used[m][n] ){
                    used[m][n] = true;
                    if(this.board[m][n] == 'O'){
                        bfs(m, n);
                        //3. 将找到的连通块设置为X
                        setX();
                    }
                } 
            }
        }

    }

    private void setX(){
        if(area.isEmpty()) return;
        boolean isValid = true;
        for(Pair pair:area){
            if(pair.x == 0 || pair.x == this.length - 1 || pair.y == 0 || pair.y == this.width - 1){
                isValid = false;
                break;
                //if(pair.x == 1 && pair.y == 1) System.out.println("错了");
            }
            
            //if(pair.x == 1 && pair.y == 1) System.out.println("找到了");
        }

        //是包围的联通块，设置为X；否则清空列表
        if(isValid){
            while(!area.isEmpty()){
                Pair pair = area.pop();
                board[pair.x][pair.y] = 'X';
            }
        }else{
            area.clear();
        }
    }

    private void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        area.add(new Pair(x,y));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            for(int i = 0; i < 4; i ++){
                int nX = dirX[i] + pair.x;
                int nY = dirY[i] + pair.y;
                if(nX >= 0 && nX < this.length && nY >= 0 && nY < this.width && !used[nX][nY]){
                    if(this.board[nX][nY] == 'O'){
                        queue.add(new Pair(nX, nY));
                        area.add(new Pair(nX, nY));
                    }
                    used[nX][nY] = true;
                }
            }
        }
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
