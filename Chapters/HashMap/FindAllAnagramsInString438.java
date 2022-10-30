import java.util.*;
public class FindAllAnagramsInString438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] phash = new int[26];
        int[] hash = new int[26];
        int m = s.length(), n=p.length();
        if(m<n){
            return result;
        }
        for(int i=0; i<n; i++){
            phash[p.charAt(i)-'a']++;
            hash[s.charAt(i)-'a']++;
        }
        int start=0, end=p.length();
        if(Arrays.equals(hash,phash)){
            result.add(start);
        }
        while(end<m){
            hash[s.charAt(start)-'a']--;
            hash[s.charAt(end)-'a']++;
            if(Arrays.equals(hash,phash)){
                result.add(start+1);
            }
            start++;
            end++;
        }
        return result;
    }
}
