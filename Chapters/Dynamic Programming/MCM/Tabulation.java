public class Tabulation {
    //TC:O(N^3)
    public static int mcm(int[] arr, int n){
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = 0; //cost of dp[1][1] = 0;
        }

        for(int win=2; win<=(n-1); win++){
            for(int l=1; l<=(n-win); l++){
                int r = l+win-1;
                dp[l][r] = Integer.MAX_VALUE;
                for(int k=l; k<r; k++){
                    int left = dp[l][k];
                    int right = dp[k+1][r];
                    int cost = arr[l-1] * arr[k] * arr[r];

                    int temp = left + right + cost;
                    dp[l][r] = Math.min(dp[l][r], temp);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int[] arr ={4, 2, 3, 1, 3};
        int n = arr.length;
        System.out.println(mcm(arr, n));
    }
}
