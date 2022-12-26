
import java.util.*;

public class BFS {

    public static void bfs(List<List<Integer>> al, boolean[] visited, int source)
    {
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            for(int i=0; i<al.get(curr).size(); i++){
                if(visited[al.get(curr).get(i)]==false){
                    q.add(al.get(curr).get(i));
                    visited[al.get(curr).get(i)] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<=n; i++){
            al.add(new ArrayList<>());
        }
        al.get(1).add(2);
        al.get(1).add(3);
        al.get(1).add(4);
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(3).add(1);
        al.get(3).add(2);
        al.get(3).add(4);
        al.get(3).add(5);
        al.get(4).add(1);
        al.get(4).add(3);
        al.get(4).add(5);
        al.get(5).add(4);
        al.get(5).add(3);
        al.get(5).add(6);
        al.get(5).add(7);
        al.get(6).add(5);
        al.get(7).add(5);
        bfs(al,new boolean[n+1], 1);
    }
}
