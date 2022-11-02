package Assignments;
public class TreeTraversals{
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static TreeNode root;
    //Complete Binary Tree
    static TreeNode levelBuild(int[] arr, int index){
        TreeNode node=null;
        if(index<arr.length){
            node = new TreeNode(arr[index]);
            node.left = levelBuild(arr, 2*index);
            node.right = levelBuild(arr, 2*index+1);
        }
        return node;
    }

    static void preorder(TreeNode root){
        TreeNode temp = root;
        if(temp!=null){
            System.out.print(temp.data+" ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }

    static void inorder(TreeNode root){
        TreeNode temp = root;
        if(temp!=null){
            inorder(temp.left);
            System.out.print(temp.data+" ");
            inorder(temp.right);
        }
    }

    static void postorder(TreeNode root){
        TreeNode temp = root;
        if(temp!=null){
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.data+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        root = levelBuild(arr,1);
        System.out.println("Preorder Traversal:");
        preorder(root);
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }
}