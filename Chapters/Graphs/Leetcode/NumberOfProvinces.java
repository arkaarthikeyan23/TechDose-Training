import java.util.*;

public class NumberOfProvinces{
    public void dfs(List<List<Integer>> al, boolean[] visited, int curr){
        visited[curr]=true;
        for(int adj : al.get(curr)){
            if(visited[adj]==false){
                dfs(al, visited, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]!=0){
                    al.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                dfs(al, visited, i);
                count++;
            }
        }
        return count;
    }
}