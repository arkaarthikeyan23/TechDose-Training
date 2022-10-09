import java.util.*;
public class countUniqueCharactersOfAllSubstrings {
    public int uniqueLetterString(String s) {
        int count=0, n = s.length();
        List<List<Integer>> list = new ArrayList<>();
        
        //prepend -1 for all keys in value list
        for(int i=0; i<26; i++){
            list.add(new ArrayList<>());
            list.get(i).add(-1);
        }
        //store all the indices
        for(int i=0; i<n; i++){
            int pos = (int)s.charAt(i) - 'A';
            list.get(pos).add(i);
        }
        //append length of string for all keys in at end of each list
        for(int i=0; i<26; i++){
            list.get(i).add(n);
        }
        
        for(int i=0; i<26; i++){
            for(int j=1; j<list.get(i).size()-1; j++){
                count +=(list.get(i).get(j) - list.get(i).get(j-1)) * (list.get(i).get(j+1) - list.get(i).get(j));
            }
        }
        return count;
    }
}
