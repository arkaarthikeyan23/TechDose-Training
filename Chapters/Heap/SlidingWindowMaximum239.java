package TechDose_Training.Chapters.Heap;

import java.util.*;

import javafx.util.Pair;

public class SlidingWindowMaximum239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length, index=0;
        int[] result = new int[n-k+1];
        //Pair-->(value,index)
        Deque<Pair<Integer,Integer>> dq = new LinkedList<>();
        for(int i=0; i<n; i++){
            //Remove first element if it goes out of window size
            if(!dq.isEmpty() && dq.peekFirst().getValue()<=(i-k)){
                dq.removeFirst();
            }
            //Maintain elements in Descending order
            while(!dq.isEmpty() && nums[i] > dq.peekLast().getKey()){
                dq.removeLast();
            }
            //Push current NODE
            dq.addLast(new Pair<>(nums[i],i));
            //Include maximum of current window
            if(i>=(k-1)){
                result[index++] = dq.peekFirst().getKey();
            }
        }
        return result;
    }
}