public class RodCutting{
    //MEMOIZATION: TC:O(N.W)
    public static int ubk(int[][] mem, int[] len, int[] price, int maxLen, int n){
        //BASE CASE:
        if(n==0 || maxLen==0){
            return 0;
        }
        //LOOK UP:
        if(mem[n][maxLen]!=0) return mem[n][maxLen];

        //EXCLUDE:
        if(len[n-1] > maxLen)   mem[n][maxLen] = ubk(mem, len, price, maxLen, n-1);
        //MAX(INCLUDE, EXCLUDE)
        else    mem[n][maxLen] = Math.max(price[n-1]+ubk(mem, len, price, maxLen-len[n-1], n), ubk(mem, len, price, maxLen, n-1));

        return mem[n][maxLen];
    }

    public static void main(String[] args) {
        int[] len = {1,2,3,4};
        int[] price = {1,5,8,9};
        int rodLength = 4;
        int n = len.length;
        int[][] mem = new int[n+1][rodLength+1];
        System.out.println(ubk(mem, len, price, rodLength, len.length));
    }
}