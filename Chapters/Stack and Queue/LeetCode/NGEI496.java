package LeetCode;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class NGEI496{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        //element,next greater element 
        Map<Integer,Integer> map = new HashMap<>();
        //Monotonic stack
        Stack<Integer> stk = new Stack<>();
        for(int val : nums2){
            while(!stk.isEmpty() && val > stk.peek()){
                map.put(stk.pop(),val);
            }
            stk.push(val);
        }
        int[] result = new int[m];
        for(int i=0; i<m; i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}