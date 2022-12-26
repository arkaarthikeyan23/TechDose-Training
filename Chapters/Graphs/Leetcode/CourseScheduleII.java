package Chapters.Graphs.Leetcode;
import java.util.*;
public class CourseScheduleII {
    public static int[] bfs(List<List<Integer>> al, int[] indegree, int n){
        Queue<Integer> q = new LinkedList<>();
        //STEP 2: Add the vertices with indegree 0 into the queue
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans = new int[n];
        int count=0;
        //STEP 3: Process the queue, If the indegree of the vertices becomes 0 add it to the queue
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int val : al.get(curr)){
                indegree[val]-=1;
                if(indegree[val]==0){
                    q.add(val);
                }
            }
            ans[count++] = curr;
        }
        return (count==n)? ans : new int[0];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> al = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            al.add(new ArrayList<>());
        }
        //STEP 1: Calculate indegree 
        int[] indegree = new int[numCourses];
        for(int[] a : prerequisites){
            al.get(a[1]).add(a[0]);
            indegree[a[0]]++;
        }
        return bfs(al, indegree, numCourses);
    }
}
