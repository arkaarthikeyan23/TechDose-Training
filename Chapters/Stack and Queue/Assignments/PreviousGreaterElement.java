import java.util.Stack;
public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,10};
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stk = new Stack<>();
        //smaller or equal elements can be pushed over top of the stack
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                pge[stk.pop()] = arr[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            pge[stk.pop()] = -1;
        }
        for(int val : pge){
            System.out.print(val+" ");
        }
    }

}
