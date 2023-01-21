import java.util.*;
import javafx.util.Pair;
public class PathWithMaximumProbability{
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair<Integer,Double>>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        int index=0;
        for(int[] edge : edges){
            al.get(edge[0]).add(new Pair<>(edge[1], succProb[index]));
            al.get(edge[1]).add(new Pair<>(edge[0], succProb[index]));
            index++;
        }
        double[] dist = new double[n];
        Arrays.fill(dist, -1.0);
        dist[start] = 1.0;

        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((a,b)->{
            if(b.getValue() > a.getValue()){
                return 1;
            }
            return -1;
        });
        pq.offer(new Pair<>(start, dist[start]));

        while(!pq.isEmpty()){
            Pair<Integer,Double> head = pq.poll();
            int vertex = head.getKey();
            double currProb = head.getValue();

            if(vertex == end){
                return dist[end];
            }

            for(Pair<Integer,Double> adj : al.get(vertex)){
                int adjVertex = adj.getKey();
                double adjProb = adj.getValue();
                if(currProb * adjProb > dist[adjVertex]){
                    dist[adjVertex] = currProb * adjProb;
                    pq.offer(new Pair<>(adjVertex, dist[adjVertex]));
                }
            }
        }
        return 0.0;
    }
}