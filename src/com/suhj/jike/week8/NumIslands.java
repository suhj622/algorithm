/**
 * 
 */
package com.suhj.jike.week8;

/**
 * @author Haojie
 * 200. ????????
 */
public class NumIslands {
	/**
	?????﹞??
	1. ????快???????????????
	2. ????快???????????蠮???????? n*m ?????????
	3. ??????快???????????'1'?????????????????????????????????'1'??????抗??
	4. ??????快????????????'1'?????????????????
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
        
        //3. ??????????
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
