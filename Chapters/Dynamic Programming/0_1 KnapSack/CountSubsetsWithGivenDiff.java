public class CountSubsetsWithGivenDiff {
    public static void main(String[] args) {
        int[] set = {3,1,2,3};
        int n = set.length;
        int diff = 3;

        int sum=0;
        for(int val : set){
            sum+=val;
        }
        
        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(i==0){
                    dp[i][j] = 0;
                }
                else if(set[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-set[i-1]];
                }
            }
        }
        /*
        S2 - S1 = Diff
        (Sum-S1)-S1 = Diff
        Sum-2S1 = Diff
        S1 = (Diff + Sum)/2
        */         
        int s1 = (diff + sum)/2;
        System.out.println(dp[n][s1]);
    }
}
