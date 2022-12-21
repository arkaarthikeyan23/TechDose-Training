package Leetcode;
public class CountGoodNodesInBinaryTree1448{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int goodNodeCount=0;
    public int goodNodes(TreeNode root) {
        preorder(root, root.val);
        return goodNodeCount;
    }
    private void preorder(TreeNode curr, int max){
        if(curr==null){
            return;
        }
        if(curr.val >= max){
            max = curr.val;
            goodNodeCount++;
        }
        preorder(curr.left, max);
        preorder(curr.right, max);
    }
}