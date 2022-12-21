package Leetcode;
public class InorderSuccessorInBST {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    //TC:O(Height) SC:O(1)
    public static TreeNode getInorderSuccessorInBST(TreeNode root, TreeNode val, TreeNode successor){
        
        while(root != null){
            if(root.val <= val.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        TreeNode res = null;
        TreeNode val = new TreeNode(8);

        res = getInorderSuccessorInBST(root, val, res);

        if(res==null){
            System.out.println("No Successor");
        }else{
            System.out.println(res.val);
        }
    }
}
