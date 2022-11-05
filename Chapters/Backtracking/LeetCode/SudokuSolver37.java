public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    public boolean dfs(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                
                if(board[i][j]=='.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;
                            //If curr no. is valid then update the board and then again recursively call the board.
                            if(dfs(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;//if none of the no. satisfy the board, then return false to previous function call.
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0; i<9; i++){
            //checking in the curr row
            if(board[row][i] == ch){
                return false;
            }
            //checking in the curr col
            if(board[i][col] == ch){
                return false;
            }
            //checking in the curr 3*3 board
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            if(board[r][c] == ch){
                return false;
            }
        }
        return true;
    }
}
