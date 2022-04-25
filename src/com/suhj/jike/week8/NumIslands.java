/**
 * 
 */
package com.suhj.jike.week8;

/**
 * @author Haojie
 * 200. ��������
 */
public class NumIslands {
	/**
	����˼·��
	1. ��ͼ�е�ÿ����ӳ�䵽һά����
	2. ��ͼ�е�ÿ���㽨�����鼯����ʼ״̬Ϊ n*m �������ĵ�
	3. ����ͼ�е�ÿ���㣬�����'1'���Ӹõ������������ĸ�������չ��֮����'1'�ĵ㣬���кϲ�
	4. ����ͼ�е�ÿ���㣬������'1'��Ϊ��������������
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
        
        //3. ���㵺������
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
