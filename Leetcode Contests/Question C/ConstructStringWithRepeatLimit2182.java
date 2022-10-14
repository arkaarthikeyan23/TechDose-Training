import java.util.*;
public class ConstructStringWithRepeatLimit2182 {
    private class Pair{
        char key;
        int val;
        Pair(char key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((Pair a,Pair b)->(b.key-a.key));
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                maxHeap.add(new Pair((char)(i+'a') , freq[i]));
            }
        }        
        StringBuilder result = new StringBuilder();
        while(maxHeap.size()>0){
            //highest lexicographical element
            Pair pair = maxHeap.poll();
            int count = pair.val;
            //consume the highest lexicographical element uptill repeatLimit
            for(int i=0; i<repeatLimit && count>0; i++){
                result.append(pair.key);
                count--;
            }
            if(count>0 && maxHeap.size()>0){
                Pair secondHighest = maxHeap.poll();
                result.append(secondHighest.key);
                if( secondHighest.val > 1)
                    maxHeap.add(new Pair(secondHighest.key, secondHighest.val-1));
                maxHeap.add(new Pair(pair.key,count));
            }
        }
        return result.toString();
    }
}
