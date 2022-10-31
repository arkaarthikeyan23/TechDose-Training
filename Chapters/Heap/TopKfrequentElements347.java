package TechDose_Training.Chapters.Heap;
import java.util.*;
public class TopKfrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        //MaxHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            pq.offer(new int[]{m.getKey(), m.getValue()});
        }
        
        int[] result = new int[k];
        
        while(k>0){
            result[k-1] = pq.poll()[0];
            k--;
        }
        
        return result;
    }
}
