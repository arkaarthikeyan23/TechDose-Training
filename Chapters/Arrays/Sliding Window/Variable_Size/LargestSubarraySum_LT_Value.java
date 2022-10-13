package Variable_Size;

import java.util.*;
public class LargestSubarraySum_LT_Value{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int sum=0, maxLen = Integer.MIN_VALUE;
        int start=0, end=0;
        while(end<n){
            sum += arr[end];
            while(sum>k){
                sum -= arr[start++];
            }
            maxLen  = Math.max( maxLen ,end-start);
            end++;
            System.out.printf("Start: %d End: %d Sum: %d\n", start, end, sum);
        }
        System.out.println("Smallest Length "+ maxLen );
    }
}