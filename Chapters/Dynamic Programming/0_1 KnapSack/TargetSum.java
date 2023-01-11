public class TargetSum {
    public int subsetSum(int[] nums, int sum){
        int n = nums.length;

        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(nums[i-1]>j)   dp[i][j] = dp[i-1][j];
                else    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        
        int sum=0;
        for(int val : nums){
            sum += val;
        }
        target = Math.abs(target);
        //If (sum+target) is odd, then we can't find equal partition
        if(sum < target || (sum+target)%2==1)   return 0;

        return subsetSum(nums, (sum+target)/2);
    }
}
