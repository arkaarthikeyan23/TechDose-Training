package Leetcode;
import java.util.*;
public class BinaryTreeZigZagLevelOrderTraversal103 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) 
    //SC:O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> ll = new LinkedList<>();
            while(size-->0){
                TreeNode curr = q.poll();
                if(leftToRight){
                    ll.add(curr.val);
                }else{
                    ll.addFirst(curr.val);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            leftToRight = !leftToRight;
            ans.add(ll);
        }
        return ans;
    }
}
