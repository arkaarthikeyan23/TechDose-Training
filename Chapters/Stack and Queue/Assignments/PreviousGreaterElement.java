package Assignments;

import java.util.Stack;
public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,15};
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stk = new Stack<>();
        //left to right decreasing order
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] >= arr[stk.peek()]){
                stk.pop();
            }
            pge[i] = stk.isEmpty()?-1:arr[stk.peek()];
            stk.push(i);
        }
        for(int val : pge){
            System.out.print(val+" ");
        }
    }

}
