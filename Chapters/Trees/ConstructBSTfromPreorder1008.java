public class ConstructBSTfromPreorder1008{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N)
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder, int start, int end){
        //Border case or value is out of range
        if(index==preorder.length || preorder[index]<start || preorder[index]>end){
            return null;
        }
        int val = preorder[index];
        index++; // for next iteration
        
        TreeNode root = new TreeNode(val);
        
        root.left = helper(preorder, start, val);
        root.right = helper(preorder, val, end);
        return root;
    }
}