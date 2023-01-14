public class ShortestCommonSuperSequence {
    public String getLCS(String s1, String s2){
        int m = s1.length(), n=s2.length();
        String[][] dp = new String[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0)    dp[i][j]="";
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }
                else{
                    int l1 = dp[i-1][j].length();
                    int l2 = dp[i][j-1].length();
                    dp[i][j] = l1>l2? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = getLCS(str1, str2);//Find LCS
        String scs = "";
        int p1=0, p2=0;

        for(char ch : lcs.toCharArray()){

            while(str1.charAt(p1) != ch){//Add all non -LCS chars from str1
                scs += str1.charAt(p1++);
            }
            while(str2.charAt(p2) != ch){//Add all non -LCS chars from str2
                scs += str2.charAt(p2++);
            }

            scs += ch;//Include LCS chars only once
            p1++;
            p2++;
        }
        //Add remaining parts from str1 and str2
        scs += str1.substring(p1) + str2.substring(p2);
        return scs;
    }
}
