package Chapters.Graphs.Assignments.Algorithms;
import java.util.*;
//TC:O(ElogV)
//Using AdjList and MinHeap
public class PrimsAlgorithm_PriorityQueue {

    public static void findMST(int[][] graph, int v){
        int[] wt = new int[v];
        boolean[] set = new boolean[v];
        int[] parent = new int[v];

        Arrays.fill(wt, Integer.MAX_VALUE);
        wt[0] = 0;
        parent[0] = -1;

        //(node,wt)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{0,0});

        for(int i=0; i<v-1; i++){

            int u = pq.remove()[0];
            set[u] = true;

            for(int j=0; j<v; j++){
                if(graph[u][j]!=0 && set[j]==false && graph[u][j] < wt[j]){
                    wt[j] = graph[u][j];
                    parent[j] = u;
                    pq.add(new int[]{j,wt[j]});
                }
            }
        }

        System.out.println("U->V => Weight");
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+"->"+i+"=>"+wt[i]);
        }

    }


    public static void main(String[] args) {
        int[][] adjMat = {{0, 4, 6, 0, 0, 0},
                          {4, 0, 6, 3, 4, 0},
                          {6, 6, 0, 1, 0, 0},
                          {0, 3, 1, 0, 2, 3},
                          {0, 4, 0, 2, 0, 7},
                          {0, 0, 0, 3, 7, 0}
                         };
        findMST(adjMat, 6);
    }
}
