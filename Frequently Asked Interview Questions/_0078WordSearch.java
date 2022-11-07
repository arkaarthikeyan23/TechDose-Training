public class _0078WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //if curr char matches the first char in word, then start dfs/bfs
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[m][n];
                    if(dfs(board, i, j, visited, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int wordIndex){
        //Success case
        if(wordIndex == word.length()){
            return true;
        }
        //Corner case
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] == true){
            return false;
        }
        //Mismatch case
        if(board[i][j] != word.charAt(wordIndex)){
            return false;
        }
        visited[i][j] = true;
        //Traverse in all four directions
        if(dfs(board, i-1, j, visited, word, wordIndex+1) || dfs(board, i+1, j, visited, word, wordIndex+1) ||
          dfs(board, i, j-1, visited, word, wordIndex+1) || dfs(board, i, j+1, visited, word, wordIndex+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
        
    }
}
