import java.util.*;
class AllPathsFromSourceToTarget {

    public void dfs(List<List<Integer>> ans, int[][] graph, boolean[] visited, Stack<Integer> pathStack, int src, int dest){
        visited[src] = true;
        pathStack.push(src);

        if(src == dest){
            ans.add(new ArrayList<>(pathStack));
            visited[src] = false;
            pathStack.pop();
            return;
        }

        for(int val : graph[src]){
            if(visited[val] == false){
                dfs(ans, graph, visited, pathStack, val, dest);
            }
        }
        pathStack.pop(); 
        visited[src] = false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> pathStack = new Stack<>();

        dfs(ans, graph, visited, pathStack, 0, n-1);
        return ans; 
    }
}
