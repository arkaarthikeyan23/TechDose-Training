package Assignments;

import java.util.Stack;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,15};
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        //Right to left decreasing order
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i] >= arr[stk.peek()]){
                stk.pop();
            }
            nge[i] = stk.isEmpty()?-1:arr[stk.peek()];
            stk.push(i);
        }
        for(int val : nge){
            System.out.print(val+" ");
        }
    }
}
