package Leetcode;
import java.util.*;

public class BalanceABinarySearchTree1382{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedArrToBST(0, sortedArr.size()-1);
    }
    public void inorder(TreeNode root){
        if(root==null)  return;
        inorder(root.left);
        sortedArr.add(root);
        inorder(root.right);
    }
    public TreeNode sortedArrToBST(int start, int end){
        if(start>end)   return null;
        int mid = start + (end-start)/2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrToBST(start, mid-1);
        root.right = sortedArrToBST(mid+1, end);
        return root;
    }
}