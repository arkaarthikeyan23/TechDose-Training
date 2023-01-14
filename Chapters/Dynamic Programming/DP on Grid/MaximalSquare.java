public class MaximalSquare {
    public int min(int a, int b, int c){
        if(a<b && a<c)  return a;
        else if(b<c)    return b;
        return c;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        int largest=0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest*largest;
    }
}
