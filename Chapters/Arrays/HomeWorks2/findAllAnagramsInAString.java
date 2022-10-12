import java.util.*;
//LC : 438
public class findAllAnagramsInAString
{
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(s.length()<p.length())
            return result;
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        
        for(int i=0; i<p.length(); i++){
            hash1[s.charAt(i)-'a']++;
            hash2[p.charAt(i)-'a']++;
        }
        
        int start=0, end = p.length();
        if(Arrays.equals(hash1,hash2)){
            result.add(start);
        }
        
        while(end<s.length()){
            hash1[s.charAt(start)-'a']--;
            hash1[s.charAt(end)-'a']++;
            
            if(Arrays.equals(hash1,hash2)){
                result.add(start+1);
            }
            start++;
            end++;
        }
        return result;
    }
}