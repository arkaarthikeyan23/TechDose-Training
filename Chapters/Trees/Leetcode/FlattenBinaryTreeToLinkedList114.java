package Leetcode;
public class FlattenBinaryTreeToLinkedList114 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        preorder(root);
    }
    public TreeNode preorder(TreeNode root){
        if(root==null)  return null;
        
        TreeNode leftChild = preorder(root.left);
        TreeNode rightChild = preorder(root.right);
        
        TreeNode extremeRightOfLC = leftChild;
        while(extremeRightOfLC!=null && extremeRightOfLC.right!=null){
            extremeRightOfLC = extremeRightOfLC.right;
        }
        
        if(extremeRightOfLC!=null){
            extremeRightOfLC.right = rightChild;
            root.right = leftChild;
        }
        root.left = null;
        return root;
    }
}
