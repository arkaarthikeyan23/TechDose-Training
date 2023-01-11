
public class PartitionEqualSubsetSum416 {
    //Recursive Approach: TC:O(2^N)
    public static boolean canPartition1(int[] set, int n, int sum){
        //Base Cases:
        if(sum==0)  return true;
        if(sum!=0 && n==0)  return false;
        
        //EXCLUDE:
        if(set[n-1] > sum)  return canPartition1(set, n-1, sum);

        return canPartition1(set, n-1, sum) || canPartition1(set, n-1, sum-set[n-1]);
    }

    //Tabulation Method: TC:O(N.SUM)
    public static boolean canPartition2(int[] set, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=sum; i++){
            dp[0][i] = false;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(set[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] set = {1,5,11,5};
        int n = set.length;
        int sum=0;
        for(int val : set){
            sum += val;
        }
        //If sum of all elements is odd, then we can't divide it into two equal subsets
        if(sum%2==1){
            System.out.println("false");
            return;
        }
        //Else check If subset has sum equal to totalSum/2
        System.out.println(canPartition1(set, n, sum/2));

        System.out.println(canPartition2(set, n, sum/2));
    }
}
