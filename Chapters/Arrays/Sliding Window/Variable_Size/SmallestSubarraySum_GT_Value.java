package Variable_Size;
import java.util.*;
public class SmallestSubarraySum_GT_Value{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int sum=0, smallLen = Integer.MAX_VALUE;
        int start=0, end=0;
        while(end<n){
            sum += arr[end++];
            while(sum>k){
                System.out.printf("Start: %d End: %d Sum: %d\n", start, end, sum);
                smallLen = Math.min(smallLen,end-start);
                sum -= arr[start++];
            }
        }
        System.out.println("Smallest Length "+smallLen);
    }
}