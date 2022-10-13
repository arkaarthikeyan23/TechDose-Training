package Fixed_Size;
import java.util.*;
public class longestSubarraySumEqualsK {
    public static int longestSubarray(int[] arr, int n, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0, max=0; 
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum==k){
                max = i+1;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            if(map.containsKey(sum-k)){
                int currLen = i - map.get(sum-k);
                if(currLen>max){
                    max = currLen;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(longestSubarray(arr,n,k));
    }
}
