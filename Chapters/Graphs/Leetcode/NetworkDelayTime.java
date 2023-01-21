import java.util.*;
import javafx.util.Pair;

public class NetworkDelayTime {
    public int bfs(List<List<Pair<Integer,Integer>>> al, int n, int k){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(Pair<Integer,Integer> p : al.get(curr)){
                int dest = p.getKey();
                int weight = p.getValue();
                if(dist[curr] + weight < dist[dest]){
                    dist[dest] = dist[curr] + weight;
                    q.offer(dest);
                }
            }
        }
        int maxCost=0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxCost = Math.max(maxCost, dist[i]);
        }
        return maxCost;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer,Integer>>> al = new ArrayList<>();
        for(int i=0; i<=n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            al.get(u).add(new Pair<>(v, w));
        }
        return bfs(al, n, k);
    }
}
