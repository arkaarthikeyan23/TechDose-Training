import java.util.*;
//DFS + STACK : TC:O(V+E)
public class TopologicalSort1{

   //Topological Sort
   public static void dfs(List<List<Integer>> al, boolean[] visited, Stack<Integer> stk, int curr){
        visited[curr] = true;

        for(Integer adj : al.get(curr)){
            if(visited[adj] == false){
                dfs(al, visited, stk, adj);
            }
        }
        //before backtracking push the curr node into the stack
        stk.push(curr);
   }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        //0->2->3
        al.get(0).add(2);
        al.get(0).add(3);
        //3->1
        al.get(3).add(1);
        //4->1->2
        al.get(4).add(1);
        al.get(4).add(2);
        //5->0->2
        al.get(5).add(0);
        al.get(5).add(2);
        
        boolean[] visited = new boolean[n];
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                dfs(al, visited, stk, i);
            }
        }
        
        //Topological Sort Ordering
        while(!stk.isEmpty()){
            System.out.print(stk.pop()+" ");
        }
    }
}