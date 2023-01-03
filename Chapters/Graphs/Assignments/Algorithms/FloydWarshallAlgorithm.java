package Chapters.Graphs.Assignments.Algorithms;
//TC:O(V^3) => O(V*(V^2))

public class FloydWarshallAlgorithm{

    public static void FloydWarshall(int[][] graph, int v){
        int[][] dist = new int[v][v];
        //Assign all values of graph to allPairs_SP
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0; k<v; k++){
            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    //SKIP if K is unreachable from i or j is unreachable from k
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    //Check if new distance is shorter via vertex K
                    else if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        //Check for negative edge weight cycle
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(dist[i][i] < 0){
                    System.out.println("Negative edge weight cycle is detected!!!");
                    return;
                }
            }
        }
        //Print Shortest Path Graph
        //(Values printed as Integer.MAX_VALUE defines there is no path)
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                        {0, 3, Integer.MAX_VALUE, 5},
                        {2, 0, Integer.MAX_VALUE, 8},
						{Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
						{Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 0},
                    };
        FloydWarshall(graph, 4);
                
    }
}