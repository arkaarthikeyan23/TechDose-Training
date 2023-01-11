public class OnesAndZeros {
    //DP
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String s : strs){
            int zero=0, one=0;
            for(char ch : s.toCharArray()){
                if(ch=='0') zero++;
                else one++;
            }

            for(int i=m; i>=zero; i--){
                for(int j=n; j>=one; j--){
                    dp[i][j] = Math.max(1+dp[i-zero][j-one], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    //MEMOIZATION
    int[][][] mem;
    public int findMaxForm1(String[] strs, int m, int n) {
        mem = new int[strs.length+1][m+1][n+1];
        return kp(strs, m, n, 0);
    }
    public int kp(String[] arr, int zero, int one, int index){
        if(index==arr.length || zero+one==0)    return 0;
        int m=0, n=0;

        if(mem[index][zero][one] > 0){
            return mem[index][zero][one];
        }

        for(char ch: arr[index].toCharArray()){
            if(ch=='0') m++;
            else n++;
        }
        int include=0;
        if(m<=zero && n<=one)   include = 1+kp(arr, zero-m, one-n, index+1);

        int exclude = kp(arr, zero, one, index+1);

        mem[index][zero][one] =  Math.max(include, exclude);

        return mem[index][zero][one];
    }
}
