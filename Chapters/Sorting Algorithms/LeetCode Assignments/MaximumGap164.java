import java.util.Arrays;

public class MaximumGap164 {
    //PigeonHole Principle
    //TC:O(N) sc:O(N) 
    public int maximumGap(int[] nums) {
        int maxGap = 0, n = nums.length;
        if(n<2) return 0; //Base Case
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        int bucketSize = (int) Math.ceil((double)(max-min)/(n-1));
        
        int[] minOfBucket = new int[n-1];
        int[] maxOfBucket = new int[n-1];
        
        Arrays.fill(minOfBucket,Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket,Integer.MIN_VALUE);
        
        //Set min and max element for each bucket
        for(int i=0; i<n; i++){
            if(nums[i]==min || nums[i]==max){
                continue;
            }
            int bucketIndex = (nums[i]-min)/bucketSize;
            
            minOfBucket[bucketIndex] = Math.min(minOfBucket[bucketIndex],nums[i]);
            maxOfBucket[bucketIndex] = Math.max(maxOfBucket[bucketIndex],nums[i]);
        }
        //Gap = Min in curr bucket - Max in prev bucket
        for(int i=0; i<n-1; i++){
            if(maxOfBucket[i]==Integer.MIN_VALUE){
                continue;
            }
            maxGap = Math.max(minOfBucket[i]-min , maxGap);
            min = maxOfBucket[i];
        }
        maxGap = Math.max(maxGap, max-min);//For 2 nos
        return maxGap;
    }
}
