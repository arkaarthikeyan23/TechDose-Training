public class DiameterOfBinaryTree543 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }
    public int height(TreeNode curr, int[] diameter){
        if(curr==null){
            return 0;
        }
        int lh = height(curr.left,diameter);
        int rh = height(curr.right,diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1+Math.max(lh,rh);
    }
}
