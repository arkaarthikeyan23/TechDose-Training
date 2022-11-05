import java.util.*;;
public class LetterCombinationsOfPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }
        String[] set = new String[10];
        set[2] = "abc"; 
        set[3] = "def";
        set[4] = "ghi";
        set[5] = "jkl";
        set[6] = "mno";
        set[7] = "pqrs";
        set[8] = "tuv";
        set[9] = "wxyz";
        
        List<String> ans = new ArrayList<>();
        
        solve(ans, set, digits, 0, "");
        return ans;
    }
    
    public void solve(List<String> ans, String[] set, String digits, int index, String curr){
        if(index==digits.length()){
            ans.add(curr);
            return;
        }
        String possibleChars = set[digits.charAt(index)-'0'];
        for(char ch : possibleChars.toCharArray()){
            solve(ans, set, digits, index+1, curr+ch);
        }
    }
}
