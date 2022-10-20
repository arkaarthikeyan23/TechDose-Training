import java.util.Queue;
import java.util.LinkedList;
public class RottingOranges996 {
    static int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        while(!rotten.isEmpty()){
            int size = rotten.size();
            while(size-->0){
                int[] position = rotten.poll();
                for(int[] dir : directions){
                    int x = position[0] + dir[0];
                    int y = position[1] + dir[1];
                    if(x>=0 && x<m && y>=0 && y<n &&grid[x][y]==1){
                        rotten.offer(new int[]{x,y});
                        grid[x][y] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        return (fresh==0)?time-1 : -1;
    }
}
