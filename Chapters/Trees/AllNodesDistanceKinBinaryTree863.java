import java.util.*;

public class AllNodesDistanceKinBinaryTree863{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    public void mark_parents(TreeNode root, Map<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parent_track.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        mark_parents(root, parent_track);
        
        Map<TreeNode,Boolean> visited = new HashMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k)  break;
            currLevel++;
        
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
         }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}

