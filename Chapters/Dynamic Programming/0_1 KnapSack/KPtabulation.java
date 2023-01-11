//TC : O(N.W)
public class KPtabulation {

    public static int knapsack(int[] wt, int[] profit, int W, int N){
        int[][] dp = new int[N+1][W+1];

        for(int i=0; i<=N; i++){
            for(int j=0; j<=W; j++){
                if(i==0 || j==0){//item=0, weight=0, so profit=0
                    dp[i][j] = 0;
                }
                else if(wt[i-1] > j){//currItem weight greater than capacity, so exclude by taking maxProf till now we got
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // 2 Choice Include / Exclude
                    // Now we don't know which one will give max profit 
                    // So, Take MAX(Include,Exclude)
                    dp[i][j] = Math.max(dp[i][j] = dp[i-1][j], profit[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[N][W];
    }
    public static void main(String[] args) {
        int[]  wt  = {3, 2, 4};
        int[] profit = {6, 8, 7};
        int capacity = 8;
        int n = wt.length;     
        
        System.out.println(knapsack(wt, profit, capacity, n));
    }
}
