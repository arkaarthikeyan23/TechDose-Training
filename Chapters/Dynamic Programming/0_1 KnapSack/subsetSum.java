public class subsetSum{
    //Recursive Approach: TC:O(2^N)
    public static boolean isSubsetSum1(int[] set, int n, int sum){
        //Base Cases
        if(sum==0)  return true;
        if(sum!=0 && n==0)  return false;

        //If curr element is greater than sum, then exclude it
        if(set[n-1] > sum)  return isSubsetSum1(set, n-1, sum);
        //Else check if sum can be obtained by excluding or including the curr element
        return isSubsetSum1(set, n-1, sum) || isSubsetSum1(set, n-1, sum-set[n-1]);
    }

    //Tabulation Method TC:O(No. of. elements * sum)
    public static boolean isSubsetSum2(int[] set, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];

        //If sum is 0, then answer is true
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        //If set is empty, then sum>1 cannot be obtained, so fill the cells with false
        for(int i=1; i<=n; i++){
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

        /*for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] set = {2, 2, 3};
        int n = set.length;
        int sum = 5;
        System.out.println(isSubsetSum1(set, n, sum));
        System.out.println(isSubsetSum2(set, n, sum));
    }
}