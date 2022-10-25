class StackNode{
    int data;
    StackNode next;
    StackNode(int data){
        this.data = data;
        next = null;
    }
}
class Stack{
    StackNode top;

    public void push(int data){
        if(this.top==null){
            top = new StackNode(data);
            return;
        }
        StackNode curr = new StackNode(data);
        curr.next = this.top;
        this.top = curr;
    }

    public StackNode pop(){
        
        StackNode curr = this.top;
        this.top = this.top.next;
        return curr;
    
    }

    public void display(){
        StackNode curr = this.top;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void reverse(){
        StackNode head = this.top, newHead = null;
        while(head!=null){
            StackNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        this.top = newHead;
    }
}
public class ReverseStack {
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Original Stack");
        s.display();
        s.reverse();
        System.out.println("Reversed Stack");
        s.display();
    }
    
}
