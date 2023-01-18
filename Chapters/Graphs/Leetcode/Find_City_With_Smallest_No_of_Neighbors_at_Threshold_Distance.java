import java.util.*;

public class Find_City_With_Smallest_No_of_Neighbors_at_Threshold_Distance{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        //Mark 0 for self loops;
        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        int[] neighborsCount = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j]!=0 && dist[i][j] <= distanceThreshold){
                    neighborsCount[i]++;
                }
            }
        }

        int vertex=0, minNeighbors = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(neighborsCount[i] <= minNeighbors){
                vertex=i;
                minNeighbors = neighborsCount[i];
            }
            
        }
        return vertex;
    }
}