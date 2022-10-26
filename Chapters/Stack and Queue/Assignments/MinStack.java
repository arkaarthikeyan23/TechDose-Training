import java.util.Stack;
//Design stack which supports getmin in O(1) time and space
//LC:155
class MinStack {
    Stack<Long> stk;
    long min;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(Long.valueOf(val));
            min = val;
        }else if(val >= min){
            stk.push(Long.valueOf(val));
        }else{
            stk.push(2*Long.valueOf(val) - min);
            min = Long.valueOf(val);
        }
    }
    
    public void pop() {
        long popped = stk.pop();
        if(popped < min){
            min = 2*min - popped;
        }
    }
    
    public int top() {
        return (int)((stk.peek()>=min)? stk.peek() : min);
    }
    
    public int getMin() {
        return (int)min;
    }
}
