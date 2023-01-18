import java.util.*;
public class NoOfConnectedComponentsInUndirectedGraph {
    public void dfs(List<List<Integer>> al, boolean[] visited, int curr){
        visited[curr] = true;
        for(int adj : al.get(curr)){
            if(visited[adj] == false){
                dfs(al, visited, adj);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            al.get(edge[0]).add(edge[1]);
            al.get(edge[1]).add(edge[0]);
        }
        int count=0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                dfs(al, visited, i);
                count++;
            }
        }
        return count;
    }
}
