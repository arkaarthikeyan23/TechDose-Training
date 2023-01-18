import java.util.*;
public class CourseSchedule {
    //Using Kahn's algorithm
    public boolean bfs(List<List<Integer>> al, int[] indegree, int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int val : al.get(curr)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
            count++;
        }
        return count==n?true : false; 
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            al.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] a : prerequisites){
            al.get(a[1]).add(a[0]);
            indegree[a[0]]++;
        }
        return bfs(al, indegree, numCourses);
    }
}
