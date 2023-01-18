import java.util.*;

public class ParallelCourses{
    public int khansAlgo(List<List<Integer>> al, int[] indegree, int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            count++;
            
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();
                res.add(curr);
                for(int adj : al.get(curr)){
                    indegree[adj]-=1;
                    if(indegree[adj]==0){
                        q.add(adj);
                    }
                }
            }
        }
        return res.size()!=n?-1:count;
    }

    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<=n; i++){
            al.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int[] edge : relations){
            al.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        return khansAlgo(al, indegree, n);
    }
}