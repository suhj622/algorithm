/**
 * 
 */
package com.suhj.jike.week3;

/**
 * @author Haojie
 * 从中序与后序遍历序列构造二叉树
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
中序：9,3,15,20,7
           1  2 3
后序：9,15,7,20,3

第一次解析：
根3
左子树：
    中序：9
    后序：9,
右子树：
    中序：15,20,7
    后序：15,7,20

递归

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
