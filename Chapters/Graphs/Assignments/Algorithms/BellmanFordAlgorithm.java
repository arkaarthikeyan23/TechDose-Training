package Chapters.Graphs.Assignments.Algorithms;

import java.util.*;

//TC:O(V.E)
public class BellmanFordAlgorithm {

    public static void bellmanFord(int[][] edgeList, int v, int e){
        int[] value = new int[v];
        
        int[] parent = new int[v];
        
        Arrays.fill(value, Integer.MAX_VALUE);
        value[0] = 0;
        parent[0] = -1;
        
        boolean updated=false;
        //Repeat (V-1) times
        for(int i=0; i<v-1; i++){
            updated = false;
            for(int j=0; j<e; j++){
                int U = edgeList[j][0];//src
                int V = edgeList[j][1];//dst
                int wt = edgeList[j][2];//wt

                if(value[U]!=Integer.MAX_VALUE && value[U]+wt < value[V]){
                    value[V] = value[U]+wt;
                    parent[V] = U;
                    updated = true;
                }
            }
            if(updated == false){
                break;
            }
        }

        //check by relaxing once more if we have a negative edge cycle
        for(int i=0; i<e && updated == true; i++){
            int U = edgeList[i][0];
            int V = edgeList[i][1];
            int wt = edgeList[i][2];

            if(value[U]!=Integer.MAX_VALUE && value[U]+wt < value[V]){
                System.out.println("Negative edge weight cycle is detected !!!");
                return;
            }
        }

        //Print Shortest Path Graph
        System.out.println("Shortest Path Graph");
        System.out.println("U->V => Weight");
    
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+"->"+i+"=>"+value[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] edgeList = new int[e][3];//0->src 1->dst 2->wt

        for(int i=0; i<e; i++){
            edgeList[i][0] = sc.nextInt();
            edgeList[i][1] = sc.nextInt();
            edgeList[i][2] = sc.nextInt();
        }
        sc.close();

        bellmanFord(edgeList, v, e);
    }
}
