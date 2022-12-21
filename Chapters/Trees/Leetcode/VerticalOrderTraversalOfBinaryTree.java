package Leetcode;
import java.util.*;

public class VerticalOrderTraversalOfBinaryTree{
    static Map<Integer,PriorityQueue<int[]>> map; 

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
            left=null;
            right=null;
        }
    }

    public static void preorder(TreeNode root, int x, int y){
        if(root==null){
            return;
        }
        PriorityQueue<int[]> pq = map.getOrDefault(y, new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){//if elements are in same x axis , then maintain elements in ASC order
                return a[1]-b[1];
            }
            return a[0]-b[0];//By Default maintain elements in level wise;
        }));

        pq.add(new int[]{x,root.val});
        map.put(y, pq);

        preorder(root.left, x+1, y-1);
        preorder(root.right, x+1, y+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        map = new TreeMap<>();
        preorder(root, 0, 0);

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, PriorityQueue<int[]>> m : map.entrySet()){
            PriorityQueue<int[]> pq = m.getValue();
            while(!pq.isEmpty()){
                int[] arr = pq.poll();
                ans.add(arr[1]);
            }
        }
        System.out.println(ans);
    }
}

/*
 TC1
X
     |       |           |            |
0    |       |          (1)           |
     |       |           |            |
1    |      (2)          |           (3)
     |       |           |            | 
     |       |           |            | 
2   (4)      |        (5) (6)         |
     |       |           |            | 
    
   -2      -1           0            1 -----> Y
 */