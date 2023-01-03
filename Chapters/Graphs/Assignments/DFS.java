package Chapters.Graphs.Assignments;

//All Paths from Source to Destination

import java.util.*;
//TC:O(V*E)
public class DFS{
    static List<List<Integer>> res = new ArrayList<>();

    public static void dfs(List<List<Integer>> al, boolean[] visited, Stack<Integer> pathStack, int src, int dest){
        visited[src] = true;
        pathStack.push(src);

        if(src == dest){
            res.add(new ArrayList<>(pathStack));
            visited[src] = false;
            pathStack.pop();
            return;
        }
        
        for(int i=0; i<al.get(src).size(); i++){
            if(visited[al.get(src).get(i)] == false){
                dfs(al, visited, pathStack, al.get(src).get(i), dest);
            }
        }
        visited[src] =  false;
        pathStack.pop();
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
    
        Stack<Integer> pathStack = new Stack<Integer>();
        boolean[] visited = new boolean[5];
        dfs(al, visited, pathStack, 0, 4);
        
        for(List<Integer> l : res){
            System.out.println(l);
        }
    }
}