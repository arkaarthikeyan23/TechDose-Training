import java.util.Deque;
import java.util.LinkedList;
//LC:225
class MyStack {
    private Deque<Integer> dq;
    public MyStack() {
        dq = new LinkedList<>();
    }
    
    public void push(int x) {
        dq.addLast(x);
    }
    
    public int pop() {
        return dq.removeLast();
    }
    
    public int top() {
        return dq.getLast();
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}
