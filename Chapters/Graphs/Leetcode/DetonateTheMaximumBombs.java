import java.util.*;
public class  DetonateTheMaximumBombs{
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(i==j) continue;
                long a = bombs[i][0] - bombs[j][0];//(x1-x2)
                long b = bombs[i][1] - bombs[j][1];//(y1-y2)
                if(Math.abs(Math.sqrt(a*a + b*b)) <= bombs[i][2]){
                    curr.add(j);
                }
            }
            al.add(curr);
        }

        int ans=0;
        //Apply BFS for all nodes as starting points
        for(int i=0; i<n; i++){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];
            visited[i] = true;
            q.add(i);
            int count=1;//count of detonated bombs
            
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int adj : al.get(curr)){
                    if(visited[adj]==false){
                        q.add(adj);
                        visited[adj] = true;
                        count++;
                    }
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
