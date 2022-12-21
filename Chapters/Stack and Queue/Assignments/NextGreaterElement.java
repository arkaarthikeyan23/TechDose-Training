import java.util.Stack;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{18,7,6,12,10};
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        //smaller or equal elements can be pushed over top of the stack 
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                nge[stk.pop()] = arr[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nge[stk.pop()] = -1;
        }
        for(int val : nge){
            System.out.print(val+" ");
        }
    }
}
