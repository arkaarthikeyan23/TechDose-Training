public class BinaryTreeMaximumPathSum124 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int result;
    
    public int postorder(TreeNode curr){
        if(curr==null){
            return 0;
        }
        
        int left = postorder(curr.left);
        int right = postorder(curr.right);
        
        int max_straight = Math.max(Math.max(left,right)+curr.val, curr.val);//case 1
        int max_caseVal = Math.max(max_straight, left+right+curr.val);//case 1&2 compared
        result = Math.max(result, max_caseVal);//case 3
        
        return max_straight;
    }
    
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        postorder(root);
        return result;
    }
}
