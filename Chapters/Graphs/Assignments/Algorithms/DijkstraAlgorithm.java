package Chapters.Graphs.Assignments.Algorithms;

import java.util.*;
//TC:O(V^2)
public class DijkstraAlgorithm {

    public static int selectMinVertex(int[] wt, boolean[] set){
        int min = Integer.MAX_VALUE;
        int vertex=0;
        for(int i=0; i<wt.length; i++){
            if(set[i] == false && wt[i] < min){
                min = wt[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void dijkstra(int[][] graph, int v){
        int[] wt = new int[v];
        boolean[] set = new boolean[v];
        int[] parent = new int[v];

        Arrays.fill(wt,Integer.MAX_VALUE);
        wt[0] = 0;
        parent[0] = -1;

        for(int i=0; i<v-1; i++){
            int u = selectMinVertex(wt, set);
            set[u] = true;
            for(int j=0; j<v; j++){
                if(graph[u][j]!=0 && wt[u]!=Integer.MAX_VALUE && set[j]==false && (wt[u] + graph[u][j] < wt[j])){
                    wt[j] = wt[u] + graph[u][j];
                    parent[j] = u;
                }
            }
        }
        System.out.println("Shortest Path Graph");
        System.out.println("U->V : Weight");
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+"->"+i+"=>"+wt[i]);
        }
    }

    public static void main(String[] args) {
        int[][]  graph = {{0, 1, 4, 0, 0, 0},
                          {1, 0, 4, 2, 7, 0},
                          {4, 4, 0, 3, 5, 0},
                          {0, 2, 3, 0, 4, 6},
                          {0, 7, 5, 4, 0, 7},
                          {0, 0, 0, 6, 7, 0}
                         };
        dijkstra(graph, 6);
    }
}
