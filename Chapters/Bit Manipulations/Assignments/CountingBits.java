public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;//0-->000 -->0 1's
        for(int i=1; i<=n; i++){
            result[i] = result[i/2] + i%2;
        }
        return result;
    }
}
