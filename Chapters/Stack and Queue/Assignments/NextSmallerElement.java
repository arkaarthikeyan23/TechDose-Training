import java.util.Stack;
public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,10};
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stk = new Stack<>();
        //greater or equal elements can be pushed over top of stack
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
                nse[stk.pop()] = arr[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nse[stk.pop()] = -1;
        }
        for(int val : nse){
            System.out.print(val+" ");
        }
    }
}
