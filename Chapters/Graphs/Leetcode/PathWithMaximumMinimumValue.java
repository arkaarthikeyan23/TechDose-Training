import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        pq.offer(new int[]{grid[0][0],0,0});//(score, x, y)
        int minVal = grid[0][0];
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!pq.isEmpty()){
            int[] head = pq.poll();
            int score = head[0];
            int x = head[1];
            int y = head[2];
            minVal = Math.min(minVal, score);
            if(x==m-1 && y==n-1){
                return minVal;
            }
            
            for(int[] d : directions){
                int newX = x+d[0];
                int newY = y+d[1];
                if(newX<0 || newX>=m || newY<0 || newY>=n || grid[newX][newY]==-1)  continue;
                
                pq.offer(new int[]{grid[newX][newY], newX, newY});
                grid[newX][newY] = -1;//Marked as visited
            }
        }
        return grid[0][0];
        
    }
}
