package Assignments;

import java.util.*;
public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,15};
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stk = new Stack<>();
        //Right to left increasing order
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i] <= arr[stk.peek()]){
                stk.pop();
            }
            nse[i] = stk.isEmpty()?-1:arr[stk.peek()];
            stk.push(i);
        }
        for(int val : nse){
            System.out.print(val+" ");
        }
    }
}
