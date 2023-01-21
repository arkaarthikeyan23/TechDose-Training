import java.util.*;

public class PathWithMinimumEffort{
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for(int[] arr : effort){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }   
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        effort[0][0]=0;
        pq.offer(new int[]{0,0,0});//(cost, x, y)
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];
            if(x==m-1 && y==n-1){
                return cost;
            }
            for(int[] d : directions){
                int newX = x+d[0];
                int newY = y+d[1];

                if(newX<0 || newX>=m || newY<0 || newY>=n)  continue;

                int newEffort = Math.max(cost, Math.abs(heights[newX][newY] - heights[x][y]));

                if(newEffort < effort[newX][newY]){
                    effort[newX][newY] = newEffort;
                    pq.offer(new int[]{newEffort, newX, newY});
                }
            }
        }   
        return 0;
    }
}