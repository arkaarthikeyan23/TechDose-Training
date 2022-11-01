
import java.util.*;
public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char ch : map.keySet()){
            pq.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int count = (int)(map.get(ch));
            while(count-->0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
