import java.util.*;
public class PathSumII113 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(root, 0, ans, new ArrayList<>(), targetSum);
        
        return ans;
    }
    
    public void dfs(TreeNode root, int runningSum, List<List<Integer>> ans, List<Integer> runningList, int target){
        if(root==null){
            return;
        }
        int totalSum = root.val+runningSum;
        runningList.add(root.val);
        //Terminal Node
        if(root.left==null && root.right==null && totalSum == target){
            ans.add(new ArrayList<>(runningList));
            return;
        }
        //Preorder Traversal
        dfs(root.left, totalSum, ans, new ArrayList<>(runningList), target);
        dfs(root.right, totalSum, ans, new ArrayList<>(runningList), target);
    }
}
