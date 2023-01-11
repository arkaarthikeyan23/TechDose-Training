public class countSubsetsWithGivenSum {
    //Recursive Approach: TC:O(2^N)
    public static int subsetSum1(int[] set, int n, int sum){
        if(sum==0)  return 1;
        if(sum!=0 && n==0)  return 0;

        if(set[n-1] > sum)  return subsetSum1(set, n-1, sum);

        return subsetSum1(set, n-1, sum) + subsetSum1(set, n-1, sum-set[n-1]);
    }

    //Tabulation Method: TC:O(N.W)
    public static int subsetSum2(int[] set, int n, int sum){
        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=sum; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(set[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }    
                else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-set[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] set = {3,1,2,3};
        int n = set.length;
        int sum = 6;
        System.out.println(subsetSum1(set, n, sum));
        System.out.println(subsetSum2(set, n, sum));
    }
}
