/**
 * 
 */
package com.suhj.week3;

/**
 * @author Haojie
 * �����������������й��������
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
����9,3,15,20,7
           1  2 3
����9,15,7,20,3

��һ�ν�����
��3
��������
    ����9
    ����9,
��������
    ����15,20,7
    ����15,7,20

�ݹ�

 */
public class BuildTree {
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return getRootNode(0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode getRootNode(int inL, int inR, int postL, int postR){

        if(inL > inR){
            return null;
        }
        TreeNode root = new TreeNode(this.postorder[postR]);
        int rootLoc = inL;
        while(this.inorder[rootLoc] != root.val){
            rootLoc ++;
        }

        root.left = getRootNode(inL, rootLoc-1, postL, postL + rootLoc -1 - inL);
        root.right = getRootNode(rootLoc + 1, inR, postL + rootLoc - inL, postR - 1);

        return root;
    }
}
