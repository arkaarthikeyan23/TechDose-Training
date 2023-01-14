public class editDistance{
    public int min(int a, int b, int c){
        if(a<b && a<c)  return a;
        else if(b<c)    return b;
        return c;
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                //If first string is empty, insert all chars of str2
                if(i==0)    dp[i][j] = j;
                //If second string is empty, delete all chars of str2
                else if(j==0)   dp[i][j] = i;
                //If curr char is same, then consider the diagonal
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{               //Insert, Delete, Replace
                    dp[i][j] = 1+min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}