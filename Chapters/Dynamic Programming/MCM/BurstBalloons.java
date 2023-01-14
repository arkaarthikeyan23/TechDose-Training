public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr = new int[n+2];
        arr[0]=1; arr[n+1]=1;
        for(int i=1; i<=n; i++){
            arr[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];

        for(int win=1; win<=n; win++){
            for(int l=1; l<=(n-win)+1; l++){
                int r = l+win-1;
                for(int k=l; k<=r; k++){
                    int left = dp[l][k-1];
                    int right = dp[k+1][r];
                    int cost = arr[l-1] * arr[k] * arr[r+1];

                    int temp = left + right + cost;
                    dp[l][r] = Math.max(dp[l][r], temp);
                }
            }
        }
        return dp[1][n];
    }

}
