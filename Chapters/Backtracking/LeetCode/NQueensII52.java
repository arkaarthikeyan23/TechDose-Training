import java.util.*;

public class NQueensII52{
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2*n-1];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        dfs(ans, board, 0, leftRow, upperDiagonal, lowerDiagonal);
        return ans.size();
    }
    public void dfs(List<List<String>> ans, char[][] board, int col, boolean[] leftRow, boolean[] upperDiagonal, boolean[] lowerDiagonal){
        int n = board.length;
        if(col==n){
            ans.add(construct(board));
            return;
        }
        for(int row=0; row<n; row++){
            if(!(leftRow[row]) && !(upperDiagonal[row+col]) && !(lowerDiagonal[n-1+col-row])){
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiagonal[row+col] = true;
                lowerDiagonal[n-1+col-row] = true;
                dfs(ans, board, col+1, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                leftRow[row] = false;
                upperDiagonal[row+col] = false;
                lowerDiagonal[n-1+col-row] = false;
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int row=0; row<board.length; row++){
            list.add(new String(board[row]));
        }
        return list;
    }
}