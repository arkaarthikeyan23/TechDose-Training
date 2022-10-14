public class SolvingQuestions2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for(int i=n-1; i>=0; i--){
            int futureIndex = i+questions[i][1]+1;
            if(futureIndex < n){
                dp[i] = dp[futureIndex] + questions[i][0];
            }else{
                dp[i] = questions[i][0];
            }
            if(i<n-1){
                dp[i] = Math.max(dp[i],dp[i+1]);
            }
        }
        return dp[0];
    }
}
