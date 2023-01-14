public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        int m = s1.length(), n=s2.length();

        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }

        System.out.println(max);
    }
}
