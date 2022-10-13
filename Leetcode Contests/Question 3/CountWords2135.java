import java.util.*;
public class CountWords2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        int count=0;
        Set<String> set = new HashSet<>();
        for(String s : startWords){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }
        for(String s : targetWords){
            for(int i=0; i<s.length(); i++){
                String curr = s.substring(0,i)+s.substring(i+1);
                char[] c = curr.toCharArray();
                Arrays.sort(c);
                if(set.contains(new String(c))){
                    count++;
                    break;
                }                
            }
        }
        return count;
    }
}
