import java.util.*;
public class BinaryTreeRightSideView199 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(H)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans);
        return ans;        
    }
    public void rightView(TreeNode curr, int level, List<Integer> ans){
        if(curr==null){
            return;
        }
        if(ans.size() == level){
            ans.add(curr.val);
        }
        //Right
        rightView(curr.right, level+1, ans);
        //Left
        rightView(curr.left, level+1, ans);
    }
    
    //TC:O(N) SC:O(level with most elements)
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean isFirst = true;
            while(size-->0){
                TreeNode curr = q.poll();
                if(isFirst){
                    ans.add(curr.val);
                    isFirst = false;
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
            }
        }
        return ans;
    }
}
