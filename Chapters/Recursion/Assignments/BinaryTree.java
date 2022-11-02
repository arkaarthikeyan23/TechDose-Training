package Assignments;
import java.util.*;

public class BinaryTree {
    static TreeNode root;
    static class TreeNode{
        int data;
        TreeNode left, right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static void insert(TreeNode root, int val){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode nn = new TreeNode(val);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp  = q.poll();
            if(temp.left == null){
                temp.left = nn;
                break;
            }
            if(temp.right == null){
                temp.right = nn;
                break;
            }
            if(temp.left.data != -1){
                q.offer(temp.left);
            }
            if(temp.right.data != -1){
                q.offer(temp.right);
            }
        }
    }

    static void preorder(TreeNode root){
        if(root!=null && root.data!=-1){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(TreeNode root){
        if(root!=null && root.data!=-1){
            preorder(root.left);
            System.out.print(root.data+" ");
            preorder(root.right);
        }
    }

    static void postorder(TreeNode root){
        if(root!=null && root.data!=-1){
            preorder(root.left);
            preorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,4,5,6};
        root = new TreeNode(1);
        for(int i=1; i<arr.length; i++){
            insert(root,arr[i]);
        }
        System.out.println("Preorder Traversal");
        preorder(root);
        System.out.println("\nInorder Traversal");
        inorder(root);
        System.out.println("\nPostorder Traversal");
        postorder(root);
    }
}
