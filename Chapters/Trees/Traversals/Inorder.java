package Chapters.Trees.Traversals;
import java.util.Stack;
//TC:O(N) SC:O(N)
public class Inorder {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void inorder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stk.isEmpty()){
            while(curr!=null){
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.val+" ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        inorder(root);
    }
}
