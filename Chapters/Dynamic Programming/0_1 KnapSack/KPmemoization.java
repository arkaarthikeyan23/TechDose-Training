import java.util.Arrays;

//TC:O(N.W)
public class KPmemoization {
    static int[][] mem;
    public static int knapsack(int[] wt, int[] profit, int W, int N){
        //BASE CASE:
        if(W==0 || N==0){
            return 0;
        }
        //LOOK UP:
        int result = 0;
        if(mem[N-1][W-1] != -1){
            return mem[N-1][W-1];
        }
        //SKIP CASE:
        if(wt[N-1] > W){
            result = knapsack(wt, profit, W, N-1);
        }
        else{
            result = Math.max(knapsack(wt, profit, W, N-1), profit[N-1]+knapsack(wt, profit, W-wt[N-1], N-1));
        }
        return mem[N-1][W-1] = result;
    }
    public static void main(String[] args) {
        int[]  wt  = {3, 2, 4};
        int[] profit = {6, 8, 7};
        int capacity = 8;
        int n = wt.length;
        mem = new int[n+1][capacity+1];
        for(int[] curr : mem){
            Arrays.fill(curr, -1);
        }
        System.out.println(knapsack(wt, profit, capacity, n));
    }
}
