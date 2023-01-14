public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=1, start=0;

        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){ // All substrings of length 1 are palindromes
            dp[i][i] = true;
        }
        for(int i=0; i<n-1; i++){// check for sub-string of length 2.
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start=i;
                maxLen=2;
            }
        }
        // Check for lengths greater than 2. k is length of substring
        for(int k=3; k<=n; k++){
            for(int i=0; i<n-k+1; i++){// Fix the starting index
            // Get the ending index of substring from starting index i and length k
                int j = i+k-1;
                if(dp[i+1][j-1]==true && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(k>maxLen){
                        maxLen = k;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
