import java.util.Stack;
public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,10};
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();
        //greater or equal elements can be pushed over top of the stack
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
                pse[stk.pop()] = arr[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            pse[stk.pop()] = -1;
        }
        for(int val : pse){
            System.out.print(val+" ");
        }
    }
}
