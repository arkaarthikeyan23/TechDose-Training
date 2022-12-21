//TC:O(N) SC:O(1)
public class Inorder{
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void inorder(TreeNode root){
        TreeNode curr=root, pred=null;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.val+" ");
                curr = curr.right;
            }
            else{
                pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred = pred.right;
                }
                //visiting the node for 1st time
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }
                //visiting the node for 2nd time
                else{
                    pred.right = null;
                    System.out.print(curr.val+" ");
                    curr = curr.right;
                }
            }
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