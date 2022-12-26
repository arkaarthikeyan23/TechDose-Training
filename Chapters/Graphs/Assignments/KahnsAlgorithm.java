import java.util.*;
//BFS: TC:O(V+E)
public class KahnsAlgorithm {

    public static boolean bfs(List<List<Integer>> al, int[] indegree, int n, List<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        //Step 2: Push all vertices with indegree 0 into the queue
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        //Process the queue,If the indegree of the vertices becomes 0 add it to the queue
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Integer val : al.get(curr)){
                indegree[val]-=1;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
            ans.add(curr);
            count++;
        }

        if(count!=n){
            return false;
        }
        return true;

    }
    public static void main(String[] args) {
        int n=6;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        //2->1
        al.get(2).add(1);
        //3->0->2
        al.get(3).add(0);
        al.get(3).add(2);
        //4->0->1
        al.get(4).add(0);
        al.get(4).add(1);
        //5->0->3
        al.get(5).add(0);
        al.get(5).add(3);
        int[] indegree = new int[n];
        //Step 1: Find Indegree of all vertices
        for(List<Integer> l : al){
            for(Integer val : l){
                indegree[val]+=1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        System.out.println(bfs(al, indegree, n, ans));
        System.out.println(ans);
    }
}
