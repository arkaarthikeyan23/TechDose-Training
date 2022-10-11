import java.util.*;
public class sumOfSubarrayMinimums
{
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] prev_smaller = new int[n];
        int[] next_smaller = new int[n];
        
        for(int i=0; i<n; i++){
            prev_smaller[i] = i;
            next_smaller[i] = n-i-1;
        }
        
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
                next_smaller[stk.peek()] = i-stk.peek()-1;
                stk.pop();
            }
            stk.push(i);
        }
        stk.clear();
        
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i]<= arr[stk.peek()]){
                prev_smaller[stk.peek()] = stk.peek()-i-1;
                stk.pop();
            }
            stk.push(i);
        }
        stk.clear();
        long result=0, mod = (long)1e9+7;
        for(int i=0; i<n; i++){
            result += ((long)arr[i] * (prev_smaller[i]+1) * (next_smaller[i]+1));
            result %= mod;
        }
        return (int)result;
    }
}