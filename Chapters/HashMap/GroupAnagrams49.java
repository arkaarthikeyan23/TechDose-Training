import java.util.*;
public class GroupAnagrams49 {
    //TC: O(N kLogk)
    public List<List<String>> groupAnagrams1(String[] strs) {
        //(sorted str, original str list)
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> list = map.getOrDefault(sorted,new ArrayList<>());
            list.add(strs[i]);
            map.put(sorted,list);
        }
        return new ArrayList<>(map.values());
    }
    //TC : O(Nk)
    public List<List<String>> groupAnagrams2(String[] strs) {
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
