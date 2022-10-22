package Assignments;

import java.util.*;
public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,15};
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();
        //left to right increasing order
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] <= arr[stk.peek()]){
                stk.pop();
            }
            pse[i] = stk.isEmpty()?-1:arr[stk.peek()];
            stk.push(i);
        }
        for(int val : pse){
            System.out.print(val+" ");
        }
    }
}
