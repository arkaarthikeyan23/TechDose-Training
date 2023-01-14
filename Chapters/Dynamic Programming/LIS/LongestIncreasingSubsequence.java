import java.util.Arrays;

public class LongestIncreasingSubsequence{
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS,1);
        int max = 1; 
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] && LIS[i]<=LIS[j]){
                    LIS[i] = 1+LIS[j];
                    max = Math.max(max, LIS[i]);
                }
            }
        }
        return max;
    }
}