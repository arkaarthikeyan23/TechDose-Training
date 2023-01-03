package Chapters.Graphs.Assignments;
import java.util.*;
//TC:O(V+E)
//GRAPH COLORNG -> 2 colors(0->unvisited 1->visited)
public class CycleDetectionUndirected
{
    public static boolean isCyclic_Util(List<List<Integer>> al, boolean[] visited, int curr, int parent){
        
        visited[curr] = true;

        for(int adj : al.get(curr)){
            if(visited[adj] == false){
                if(isCyclic_Util(al, visited, adj, curr)){
                    return true;
                }
            }else if(adj != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclic(List<List<Integer>> al, int n){
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                if(isCyclic_Util(al, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        int n = 3;
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        //0->1->2
        al.get(0).add(1);
        al.get(0).add(2);
        //1->0->2
        al.get(1).add(0);
        al.get(1).add(2);
        //2->0->1
        al.get(2).add(0);
        al.get(2).add(1);

        if(isCyclic(al, n)){
            System.out.println("Cycle is Detected!!");
        }else{
            System.out.println("Cycle is not Detected!!");
        }
    }
}