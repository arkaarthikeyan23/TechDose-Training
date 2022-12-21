package Leetcode;
public class ValidateBinarySearchTree98 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(1)
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode curr, long minVal, long maxVal){
        if(curr == null)    return true;
        if(curr.val<=minVal || curr.val>=maxVal)    return false;
        
        return helper(curr.left, minVal, curr.val) && helper(curr.right, curr.val, maxVal);
    }
}
