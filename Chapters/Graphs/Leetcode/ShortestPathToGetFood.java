import java.util.*;

public class ShortestPathToGetFood{
    public int bfs(char[][] grid, int m, int n, int startX, int startY){
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int levelCount=0;
        while(!q.isEmpty()){
            levelCount++;
            int size = q.size();
            while(size-->0){
                int[] curr = q.poll();
                for(int[] direction : directions){
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x<0 || x>=m || y<0 || y>=n || grid[x][y]=='X'){
                        continue;
                    }
                    if(grid[x][y] == '#'){
                        return levelCount;
                    }
                    else{
                        if(!visited[x][y]){
                            q.add(new int[]{x,y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }


    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int startX=0, startY=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '*'){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        return bfs(grid, m, n, startX, startY);
    }
}