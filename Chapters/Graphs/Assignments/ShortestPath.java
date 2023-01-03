package Chapters.Graphs.Assignments;

//Shortest Path between source and destination

import java.util.*;

public class ShortestPath {
    static int hops = 0;
    public static void bfs(List<List<Integer>> al, boolean[] visited, int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            hops++;
            visited[curr] = true;
            System.out.print(curr+" ");
            for(int val : al.get(curr)){
                if(visited[val] == false){
                    q.add(val);
                    visited[val] = true;
                }
                if(val == dest){
                    System.out.print(dest+"\nNo. Of. Hops : "+ hops);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<5; i++){
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);
        al.get(1).add(0);
        al.get(0).add(2);
        al.get(2).add(0);
        al.get(1).add(3);
        al.get(3).add(1);
        al.get(1).add(4);
        al.get(4).add(1);
        al.get(2).add(4);
        al.get(4).add(2);
        al.get(3).add(4);
        al.get(4).add(3);
        
        boolean[] visited = new boolean[5];
        bfs(al, visited, 0, 4);
    }
}
