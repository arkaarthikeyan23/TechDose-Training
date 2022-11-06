import java.util.HashSet;
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                char number = board[i][j];
                if(number!='.'){
                    if(set.contains(number+"_R_" +i) || 
                      set.contains(number+"_C_"+j) ||
                      set.contains(number+"_B_"+(i/3)+"_"+(j/3))){
                        return false;
                    }else{
                        set.add(number+"_R_" +i);
                        set.add(number+"_C_" +j);
                        set.add(number+"_B_"+(i/3)+"_"+(j/3));
                    }
                }
            }
        }
        return true;
    }
}
