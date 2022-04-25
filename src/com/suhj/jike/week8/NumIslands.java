/**
 * 
 */
package com.suhj.jike.week8;

/**
 * @author Haojie
 * 200. 岛屿数量
 */
public class NumIslands {
	/**
	解题思路：
	1. 将图中的每个点映射到一维数组
	2. 对图中的每个点建立并查集，初始状态为 n*m 个孤立的点
	3. 遍历图中的每个点，如果是'1'，从该点往上下左右四个方向扩展，之后是'1'的点，进行合并
	4. 遍历图中的每个点，计算是'1'且为根的数量，返回
	 */
    private int[] fa;
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        //1.0 make set
        m = grid.length;
        n = grid[0].length;
        fa = new int[m*n];
        for(int i = 0; i < m*n; i++) fa[i] = i;

        //2. unionSet
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0') continue;
                for(int k = 0; k < 4; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if(ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                    else{
                        if(grid[ni][nj] == '1') unionSet(num(i, j), num(ni, nj));
                    }
                }
            }
        
        //3. 计算岛屿数量
        int ans = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && find(num(i,j)) == num(i, j)){
                    ans++;
                } 
            }
        return ans;

    }

    private int num(int i, int j){
        return i * n + j;
    }

    private int find(int x){
        if(x == fa[x]) return x;
        else return fa[x] = find(fa[x]);
    }

    private void unionSet(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) fa[x] = y;
    }
}
