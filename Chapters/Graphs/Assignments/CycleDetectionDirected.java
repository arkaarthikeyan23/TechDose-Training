package Chapters.Graphs.Assignments;
import java.util.*;
//TC:O(V+E)
//GRAPH COLORNG -> 3 colors(0->unvisited 1->processing 2->processed)
public class CycleDetectionDirected{

    public static boolean isCyclic_Util(List<List<Integer>> al, int[] visited, int curr){
        //If curr node is already in processing chain, then there is a cycle
        if(visited[curr] == 1){
            return true;
        }
        visited[curr] = 1;
        for(int adj : al.get(curr)){
            //For processed nodes, we don't need to make dfs calls
            if(visited[adj] != 2){
                if(isCyclic_Util(al, visited, adj)){
                    return true;
                }
            }
        }
        visited[curr] = 2;//While backtracking, mark the curr node as processed
        return false;
    }


    public static boolean isCyclic(List<List<Integer>> al, int n){
        int[] visited = new int[n];

        for(int i=0; i<n; i++){
            if(visited[i]==0){
                if(isCyclic_Util(al, visited, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        al.get(0).add(1);

        al.get(1).add(2);
        //al.get(1).add(3);

        al.get(2).add(3);

        al.get(3).add(1);

        if(isCyclic(al, n)){
            System.out.println("Cycle is Detected!!!");
        }else{
            System.out.println("Cycle is not Detected!!!");
        }
    }
}