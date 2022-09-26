import java.util.*;
public class kthLargestElement {
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
    //Method 2: Quick Select
    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public static int partition(int[] nums, int low, int high){
        int pivot=nums[high], i=low-1;
        for(int j=low; j<=high-1; j++){
            if(nums[j]<=pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }
    
    public static int find(int[] nums,int low, int high, int k){
        int pi = partition(nums,low,high);
        if(pi == k){
            return nums[pi];
        }
        else if (pi < k){
            return find(nums,pi+1,high,k);
        }
        else{
            return find(nums,low,pi-1,k);
        }
    }
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        return find(nums,0,n-1,n-k);
    }
}
