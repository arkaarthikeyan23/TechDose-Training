import java.util.*;

public class CourseScheduleIV{
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] graph = new boolean[numCourses][numCourses];

        for(int[] prerequisite : prerequisites){
            int u = prerequisite[0], v = prerequisite[1];
            graph[u][v] = true;
        }

        for(int k=0; k<numCourses; k++){
            for(int i=0; i<numCourses; i++){
                for(int j=0; j<numCourses; j++){
                    if(graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0], v = query[1];
            ans.add(graph[u][v]);
        }
        return ans;
    }
}
