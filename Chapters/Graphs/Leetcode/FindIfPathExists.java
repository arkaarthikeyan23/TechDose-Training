package Chapters.Graphs.Leetcode;

import java.util.*;

class FindIfPathExists {
    public boolean bfs(List<List<Integer>> al, boolean[] visited, int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == dest){
                return true;
            }
            visited[curr] = true;
            for(Integer val : al.get(curr)){
                if(visited[val] == false){
                    q.add(val);
                    visited[val] = true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        return bfs(al, visited, source, destination);
    }
}