package Chapters.Graphs.Leetcode;

import java.util.*;
//TC:O(V+E)
public class PossibleBipartition{
    public boolean isBipartite(List<List<Integer>> al, int[] color, int curr){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        color[curr] = 1;
    
        while(!q.isEmpty()){
            int head = q.poll();
            for(int val : al.get(head)){
                if(color[val] == color[head]){//odd length cycle
                    return false;
                }
                if(color[val] == -1){//unvisited node
                    color[val] = 1-color[head];
                    q.add(val);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> al = new ArrayList<>();

        for(int i=0; i<=n; i++){
            al.add(new ArrayList<>());
        }

        for(int a[] : dislikes){
            al.get(a[0]).add(a[1]);
            al.get(a[1]).add(a[0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        //For multi component graph
        for(int i=1; i<=n; i++){
            if(color[i]==-1){
                if(!isBipartite(al, color, i)){
                    return false;
                }
            }
        }
        return true;
    }
}