public class Recursion {
    
    public static int mcm(int[] arr, int L, int R){
        //Bounds Check
        if(L>=R){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        
        for(int k=L; k<R; k++){
            int left = mcm(arr, L, k);
            int right = mcm(arr, k+1, R);
            int cost = arr[L-1] * arr[k] * arr[R];

            int temp = left + right + cost;
            ans = Math.min(ans, temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        int n = arr.length;
        System.out.println(mcm(arr, 1, n-1));
    }
}
