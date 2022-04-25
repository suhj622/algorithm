/**
 * 
 */
package com.suhj.jike.week8;

/**
 * @author Haojie
 * ��������
 */
public class FindRedundantConnection {
	/**
	����˼·�����鼯����
	1. �������鼯����ʼ״̬�� n �������ĵ㣻
	2. �������б�
	   1�����ߵ������˵㣬�������ͨ��������ͬ�����ϲ�
	   2�������ͨ����ı�ʱ��ɻ������أ�����
	 */
    private int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // ��Ӧfa �˷� fa[0] �Ŀռ�
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
