package Leetcode;
public class LowestCommonAncestor236 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Success Case
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        //Base Case
        if(root.left==null && root.right==null){
            return null;
        }
        TreeNode left=null, right=null;
        if(root.left!=null){
            left = lowestCommonAncestor(root.left, p, q);
        }
        if(root.right!=null){
            right = lowestCommonAncestor(root.right, p, q);
        }
        if(left!=null && right!=null){
            return root;
        }
        return left==null?right:left;
    }
}
