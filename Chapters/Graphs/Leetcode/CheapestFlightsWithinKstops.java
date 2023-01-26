import java.util.*;

public class CheapestFlightsWithinKstops{
    public int bfs(List<List<int[]>> al, int src, int dst, int k, int n){
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});//currNode, currCost, stops

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0], currCost= curr[1], stops = curr[2];
            for(int[] adj : al.get(currNode)){
                int newCost = adj[1] + currCost;
                if(newCost < cost[adj[0]]){
                    cost[adj[0]] = newCost;
                    if(stops<=k-1 && src!=dst){
                        q.offer(new int[]{adj[0], newCost, stops+1});
                    }
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];

    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] f : flights){
            al.get(f[0]).add(new int[]{f[1], f[2]});
        }
        return bfs(al, src, dst, k, n);
    }
}