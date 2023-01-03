package Chapters.Graphs.Assignments.Algorithms;


import java.util.*;
//TC:O(V*V)
public class PrimsAlgorithm {

    public static int selectMinVertex(int[] wt, boolean[] setMST, int v){
        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for(int i=0; i<v; i++){
            if(setMST[i]==false && wt[i] < min){
                min = wt[i];
                vertex = i;
            }
        }
        return vertex;
    }
    
    public static void findMST(int[][] adjMat, int v){
        int[] wt = new int[v]; //Used for edge relaxation
        boolean[] setMST = new boolean[v]; //TRUE->Vertex is included in MST
        int[] parent = new int[v]; //Stores MST

        Arrays.fill(wt, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        
        wt[0] = 0; //start node has value=0 to get picked 1st
        parent[0] = -1; //Start node has no parent

        //Form MST with (V-1) edges
        for(int i=0; i<v-1; i++){
            //1.Select Min Vertex from the weight array that is not included in setMST
            int u = selectMinVertex(wt, setMST, v);
            //2. Include the vertex in setMST
            setMST[u] = true;
            //3.Relax the adjacent vertices and update in weight array
            for(int j=0; j<v; j++){
                /* 3 constraints to relax:-
			      1.Edge is present from U to j.
			      2.Vertex j is not included in MST
			      3.Edge weight is smaller than current edge weight
			    */
                if(adjMat[u][j]!=0 && setMST[j]==false && adjMat[u][j] < wt[j]){
                    wt[j] = adjMat[u][j];
                    parent[j] = u;
                }
            }
        }

        //Print the MST using parent array
        System.out.println("U->V => Weight");
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+"->"+i+" => "+wt[i]);
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
