import java.util.*;
public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        //Map -->value,sum of indices
        Map<Integer,Long> map = new HashMap<>();
        int[] freq = new int[100001];
        //left sum
        for(int i=0; i<n; i++){
            int curr = arr[i];
            if(!map.containsKey(curr)){
                map.put(curr,0l);
            }
            result[i] += (((long)freq[curr] * i) - map.get(curr));
            map.put(curr,map.get(curr)+i);
            freq[curr]++;
        }
        //right sum
        map = new HashMap<>();
        freq = new int[100001];
        for(int i=n-1; i>=0; i--){
            int curr = arr[i];
            if(!map.containsKey(curr)){
                map.put(curr,0l);
            }
            result[i] += (map.get(curr) - i * (long)freq[curr]);
            map.put(curr,map.get(curr)+i);
            freq[curr]++;
        }
        return result;
    }
}
