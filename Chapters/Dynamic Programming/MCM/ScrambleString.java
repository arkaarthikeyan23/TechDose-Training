import java.util.*;

public class ScrambleString {
    //Memoization + Pruning
    Map<String,Boolean> map = new HashMap<>();
    public boolean solve(String s1, String s2){
        if(s1.equals(s2))   return true;
        String key = s1+"*"+s2;
        if(map.containsKey(key))    return map.get(key);

        //Pruning : Avoid unneccessary recursion calls
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(char c : s1.toCharArray()){
            f1[c-'a']++;
        }
        for(char c : s2.toCharArray()){
            f2[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(f1[i] != f2[i]){
                map.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        for(int i=1; i<n; i++){
            if( ((solve(s1.substring(0,i), s2.substring(0,i)) && solve(s1.substring(i), s2.substring(i)))) 
 /*FLIP CASE*/|| ((solve(s1.substring(0,i), s2.substring(n-i)) && solve(s1.substring(i), s2.substring(0,n-i)))) )
            {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);   
    }
}
