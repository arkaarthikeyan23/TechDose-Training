import java.util.*;

public class GenerateParenthesis22{
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrackHelper(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    public void backtrackHelper(List<String> ans, StringBuilder str, int open, int closed, int n){
        //Abort condition
        if(closed > open){
            return;
        }
        //Success Condition
        if(open == closed && str.length() == 2*n){
            ans.add(str.toString());
            return;
        }
        if(open<n){
            str.append('(');
            backtrackHelper(ans, str, open+1, closed, n);
            str.deleteCharAt(str.length()-1);//while backtracking we have to remove the last appended char
        }
        if(open>closed){
            str.append(')');
            backtrackHelper(ans, str, open, closed+1, n);
            str.deleteCharAt(str.length()-1);
        }
    }
}