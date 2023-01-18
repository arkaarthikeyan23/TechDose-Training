import java.util.*;

//TC:O(V+E)
public class IsGraphBipartite{
    public boolean isBipartite1(List<List<Integer>> al, int[] color, int node){
        Queue<Integer> q = new LinkedList<>();
        color[node] = 1;
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int ele : al.get(curr)){
                if(color[ele] == color[curr]){//odd length cycle
                    return false;
                }
                if(color[ele] == -1){//unvisited node
                    color[ele] = 1-color[curr];
                    q.add(ele);
                }
            }
        } 
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<graph[i].length; j++){
                al.get(i).add(graph[i][j]);
                al.get(graph[i][j]).add(i);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(!isBipartite1(al, color, i)){
                    return false;
                }
            }
        }
        return true;
    }
}