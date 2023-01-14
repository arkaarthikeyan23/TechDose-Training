import java.util.*;

public class NumberOfLIS{
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] count = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(count,1);
        int maxLen = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] && LIS[i] < 1+LIS[j]){
                    LIS[i] = 1+LIS[j];
                    count[i] = count[j]; // New subsequence
                }
                else if(nums[i]>nums[j] && LIS[i] == 1+LIS[j]){
                    count[i] = count[i] + count[j]; 
                }
            }
            maxLen = Math.max(maxLen, LIS[i]);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            if(LIS[i] == maxLen){
                ans = ans + count[i];
            }
        }
        return ans;
    }
}