import java.util.*;

public class NQueens51{
    //APPROACH 1:
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }        
        
        dfs(0, board, ans);
        return ans;
    }
    public void dfs(int col, char[][] board, List<List<String>> ans){
        if(col == board[0].length){
            ans.add(construct(board));
            return;
        }
        for(int row=0; row<board.length; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                dfs(col+1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    public boolean validate(char[][] board, int row, int col){
        int dupRow=row;
        int dupCol=col;
        
        //Left upper Diagonal
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        //Left column
        row = dupRow;
        col = dupCol;
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        //Left lower Diagonal
        row = dupRow;
        col = dupCol;
        while(row<board.length && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
    //APPROACH 2:
    public List<List<String>> solveNQueens1(int n) {
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
        
        dfs1(ans, board, 0, leftRow, upperDiagonal, lowerDiagonal);
        return ans;
    }
    public void dfs1(List<List<String>> ans, char[][] board, int col, boolean[] leftRow, boolean[] upperDiagonal, boolean[] lowerDiagonal){
        int n = board.length;
        if(col==n){
            ans.add(construct1(board));
            return;
        }
        
        for(int row=0; row<n; row++){
            if(!(leftRow[row]) && !(upperDiagonal[row+col]) && !(lowerDiagonal[n-1+col-row])){
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiagonal[row+col] = true;
                lowerDiagonal[n-1+col-row] = true;
                dfs1(ans, board, col+1, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                leftRow[row] = false;
                upperDiagonal[row+col] = false;
                lowerDiagonal[n-1+col-row] = false;
            }
        }
    }
    public List<String> construct1(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}