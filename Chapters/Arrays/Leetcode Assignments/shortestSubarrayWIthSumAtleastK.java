import java.util.*;
import javafx.util.Pair;
public class shortestSubarrayWIthSumAtleastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair<Long,Integer>> dq = new ArrayDeque<>();
        
        long sum=0;
        int shortestLen = Integer.MAX_VALUE;
       
        for(int i=0; i<n; i++){
            sum += nums[i];
            //Sum from start to i-th index
            if(sum>=k){
                shortestLen = Math.min(shortestLen,i+1);
            }
            Pair<Long,Integer> curr = new Pair<Long,Integer>(Long.MIN_VALUE,Integer.MIN_VALUE);
            //Reduce the window size to find minimum window with sum>=k
            while(!dq.isEmpty() && (sum - dq.getFirst().getKey()) >= k){
                curr = dq.getFirst();
                dq.removeFirst();
            }
            //Calculate the new shortestLen (if possible)
            if((int)curr.getValue() != (int)Integer.MIN_VALUE){
                shortestLen = Math.min(shortestLen, i - (int)curr.getValue());
            }
            //Maintain monotonically increasing order of deque
            while(!dq.isEmpty() && sum <= dq.getLast().getKey()){
                dq.removeLast();
            }
            dq.addLast(new Pair<>(sum,i));
        }
        return shortestLen==Integer.MAX_VALUE?-1:shortestLen;
    }
}
