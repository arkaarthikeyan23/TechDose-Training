public class MinimumSubsetSumDiff {
    //TC:O(N.W)
    public static void main(String[] args) {
        int[] set = {1,6,11,5};
        int n = set.length;
        
        int sum=0;
        for(int val : set){
            sum+=val;
        }

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(set[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++){
            int first = i;
            int second = sum-i;
            if(dp[n][i] == true && Math.abs(first-second) < diff){
                diff = Math.abs(first-second);
            }
        }
        System.out.println(diff);
    }
}
