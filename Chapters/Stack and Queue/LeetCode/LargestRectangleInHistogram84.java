package LeetCode;
import java.util.Stack;
public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //Monotonic  stack
        Stack<Integer> stk = new Stack<>();
        //Fill left
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            left[i] = stk.isEmpty()?0:stk.peek()+1;
            stk.push(i);
        }
        stk.clear();
        //Fill right
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            right[i] = stk.isEmpty()?n-1:stk.peek()-1;
            stk.push(i);
        }
        //Max Area
        int max = -1;
        for(int i=0; i<n; i++){
            int area = (right[i] - left[i] + 1) * heights[i];
            max = Math.max(max,area);
        }
        return max;
    }
}
