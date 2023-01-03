package Chapters.Graphs.Assignments.Algorithms;

import java.util.*;
//Using Adj List and MinHeap
//TC:O(Elogv)
public class DijkstraAlgorithm_PriorityQueue {

    public static void dijkstra(int[][] graph, int v){
        int[] wt = new int[v];
        boolean[] set = new boolean[v];
        int[] parent = new int[v];

        Arrays.fill(wt,Integer.MAX_VALUE);
        wt[0] = 0;
        parent[0] = -1;
        //(node, wt) -->min wt
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{0,0});

        for(int i=0; i<v-1; i++){
            
            int u = pq.remove()[0];
            set[u] = true;

            for(int j=0; j<v; j++){
                if(graph[u][j]!=0 && wt[u]!=Integer.MAX_VALUE && set[j]==false && (wt[u]+graph[u][j] < wt[j])){
                    wt[j] = wt[u]+graph[u][j];
                    parent[j] = u;
                    pq.add(new int[]{j,wt[j]});
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
