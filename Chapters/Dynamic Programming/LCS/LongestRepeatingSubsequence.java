public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "AABB";
        int n = s.length();

        String[][] dp = new String[n+1][n+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)    dp[i][j] = "";
                else if(i!=j && s.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j]  = dp[i-1][j-1]+s.charAt(i-1);
                }
                else{
                    int l1 = dp[i-1][j].length(), l2 = dp[i][j-1].length();
                    dp[i][j] = l1>l2?dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
