import java.util.*;
public class _0047KthLargestElement {
        //TC:O(NlogK)
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0; i<nums.length; i++){
                pq.offer(nums[i]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
}
