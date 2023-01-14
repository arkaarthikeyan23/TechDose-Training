import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max=Integer.MIN_VALUE;
        int[] heights = new int[cols];

        for(int i=0; i<rows; i++){
            
            for(int j=0; j<cols; j++){
                heights[j] = matrix[i][j]=='1'?1+heights[j] : 0;
            }

            int[] left = new int[cols];
            int[] right = new int[cols];
            Stack<Integer> stk = new Stack<>();

            for(int j=0; j<cols; j++){
                while(!stk.isEmpty() && heights[stk.peek()]>=heights[j]){
                    stk.pop();
                }
                left[j] = stk.isEmpty()?0:stk.peek()+1;
                stk.push(j);
            }
            stk.clear();
            for(int j=cols-1; j>=0; j--){
                while(!stk.isEmpty() && heights[stk.peek()]>=heights[j]){
                    stk.pop();
                }
                right[j] = stk.isEmpty()?cols-1:stk.peek()-1;
                stk.push(j);
            }

            for(int j=0; j<cols; j++){
                int area = heights[j] * (right[j]-left[j] + 1);
                max = Math.max(area, max);
            }
        }
        return max;
    }
}
