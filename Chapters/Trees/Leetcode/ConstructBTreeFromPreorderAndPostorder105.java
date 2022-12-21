package Leetcode;
import java.util.*;
public class ConstructBTreeFromPreorderAndPostorder105 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);//(val,index)
        }
        
        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }
    
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        
        if(preStart>preEnd || inStart>inEnd)    return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot-inStart;
        
        root.left = helper(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        root.right = helper(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);
        
        return root;
    }
}
