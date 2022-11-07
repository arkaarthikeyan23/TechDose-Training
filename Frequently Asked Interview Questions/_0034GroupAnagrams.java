import java.util.*;
public class _0034GroupAnagrams {
    //TC : O(Nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> map = new HashMap<>();
        
        for(String s : strs){
            Map<Character,Integer> tempMap = new HashMap<>();
            for(char ch : s.toCharArray()){
                tempMap.put(ch,tempMap.getOrDefault(ch,0)+1);
            }
            if(map.containsKey(tempMap)){
                map.get(tempMap).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(tempMap,list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
