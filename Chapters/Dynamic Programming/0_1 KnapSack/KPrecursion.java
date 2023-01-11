//TC:O(2^N)
public class KPrecursion{

    public static int knapsack(int[] wt, int[] profit, int W, int N){
        //BASE CASE:
        if(W==0 || N==0){
            return 0;
        }
        //SKIP CASE:
        if(wt[N-1] > W){
            return knapsack(wt, profit, W, N-1);
        }
        //MAX(Exclude, Include)
        else{
            return Math.max(knapsack(wt, profit, W, N-1), profit[N-1] + knapsack(wt, profit, W-wt[N-1], N-1));
        }
    }

    public static void main(String[] args) {
        int[]  wt  = {3, 2, 4};
        int[] profit = {6, 8, 7};
        int capacity = 8;
        int n = wt.length;
        System.out.println(knapsack(wt, profit, capacity, n));
    }
}