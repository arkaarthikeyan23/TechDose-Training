import java.util.Stack;
public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int max=0;
        int[] heights = new int[c];
        for(int i=0; i<r; ++i){
            Stack<Integer> stk = new Stack<>();
            int[] left = new int[c];
            int[] right = new int[c];
            for(int j=0; j<c; ++j){
                heights[j] = matrix[i][j]=='1' ? 1+heights[j] : 0;
            }
            //Fill left to right
            for(int j=0; j<c; ++j){
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[j]){
                    stk.pop();
                }
                left[j] = stk.isEmpty() ? 0 : stk.peek()+1;
                stk.push(j);
            }
            stk.clear();
            //Fill right to left
            for(int j=c-1; j>=0; --j){
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[j]){
                    stk.pop();
                }
                right[j] = stk.isEmpty() ? c-1 : stk.peek()-1;
                stk.push(j);
            }
            //Find Max area
            for(int j=0; j<c; ++j){
                int area = (right[j] - left[j] + 1) * heights[j];
                max = Math.max(max,area);
            }
        }
        return max;
    }
}
