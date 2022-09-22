import java.util.*;
public class mergeIntervals {
    //TC : O(NlogN)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<intervals.length; i++){
            int[] currInt = intervals[i];
            if(!stack.isEmpty()){
                int[] top = stack.peek();
                //Successful overlap
                if(top[1]>=currInt[0]){
                    stack.pop();
                    int minStart = top[0];
                    int maxEnd = Math.max(top[1],currInt[1]);
                    stack.push(new int[]{minStart,maxEnd});
                }
                //No overlap
                else{
                    stack.push(currInt);
                }
            }
            else{
                stack.push(currInt);
            }
        }
        int[][] result = new int[stack.size()][2];
        int index=stack.size()-1;
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            result[index][0] = top[0];
            result[index][1] = top[1];
            index--;
        }
        return result;
    } 
}
