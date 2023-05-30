/**
 * 
 */
package com.suhj.jike.week8;

/**
 * @author Haojie
 * 冗余连接
 */
public class FindRedundantConnection {
	/**
	解题思路（并查集）：
	1. 建立并查集，初始状态是 n 个孤立的点；
	2. 遍历所有边
	   1）检查边的两个端点，如果不连通（根不相同），合并
	   2）如果连通，则改变时造成环的因素，返回
	 */
    private int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 对应fa 浪费 fa[0] 的空间
        fa = new int[n+1];
        //1.0 make set
        for(int i = 1; i < n; i++) fa[i] = i;
        //2.0 find target edgs
        int[] ans = new int[2];
        for(int i = 0; i < n; i++){
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            if( x != y) unionSet(x, y);
            else ans = edges[i];
        }
        return ans;
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
