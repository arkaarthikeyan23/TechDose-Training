import java.util.Stack;
//Design stack which supports getmin in O(1) time and space
public class MinStack {
    static Stack<Integer> stk;
    static int min;
    public MinStack(){
        stk = new Stack<>();
    }
    
    void push(int curr){
        if(stk.isEmpty()){
            stk.push(curr);
            min = curr;
            return;
        }
        else if(curr>=min){
            stk.push(curr);
        }
        else{
            min = curr;
            stk.push(2*curr - min);
        }
    }

    void pop(){
        int curr = stk.peek();
        if(stk.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else if(curr>=min){
            System.out.println(stk.pop());
        }
        else{
            System.out.println(min);
            min = 2*min - curr;
        }
    }

    void getMin(){
        if(stk.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println(min);
        }
    }

    void peek(){
        int curr = stk.peek();
        if(stk.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else if(curr>=min){
            System.out.println(min);
        }else{
            System.out.println(curr);
        }
    }
}
