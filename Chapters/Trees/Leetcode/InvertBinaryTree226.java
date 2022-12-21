package Leetcode;
public class InvertBinaryTree226 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    public void swap(TreeNode curr){
        if(curr==null){
            return;
        }
        swap(curr.left);
        swap(curr.right);
        //swap child pointers
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }
    
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
}
