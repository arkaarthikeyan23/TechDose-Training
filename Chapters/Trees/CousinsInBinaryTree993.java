
import java.util.*;
public class CousinsInBinaryTree993{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode xParent=null, yParent=null;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.offer(curr.left);
                    if(curr.left.val==x){
                        xParent = curr;
                    }
                    if(curr.left.val==y){
                        yParent = curr;
                    }
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                    if(curr.right.val==x){
                        xParent = curr;
                    }
                    if(curr.right.val==y){
                        yParent = curr;
                    }
                }
                //Same depth(level) and different parent
                if(xParent!=null && yParent!=null){
                    return xParent!=yParent;
                }
            }
            if((xParent==null && yParent!=null) || (xParent!=null && yParent==null)){
                return false;
            }
        }
        return true;
    }
}