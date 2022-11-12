public class ConvertBSTtoSortedDLL {
    static class TreeNode{
        int val;
        TreeNode left, right;//prev=left  next=right
        TreeNode(int val){
            this.val = val;
            left=null;
            right=null;
        }
    }

    static TreeNode head, prev;
    
    public static void inorder(TreeNode root){
        if(root==null)  return;

        inorder(root.left);
        if(head==null){
            head = root;
        }else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inorder(root.right);
    }


    static void display(TreeNode head){
        TreeNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.right;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);

        head = null;
        prev = null;
        inorder(root);
        display(head);
    }
}
