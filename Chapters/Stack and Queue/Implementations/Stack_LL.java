import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

class Stack{
    //Add at front, Delete At Front
    Node top;
    Stack(){
        top = null;
    }
    boolean isEmpty(){
        return top==null;
    }
    void push(int val){
        Node nn = new Node(val);
        nn.next = top;
        top = nn;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int result = top.data;
        top = top.next;
        return result;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }
}


public class Stack_LL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stk = new Stack();
    
        while(true){
            System.out.println("Operations: \n1)Push \n2)Pop \n3)Peek \n4)Exit");
            int option = sc.nextInt();
            boolean exit = false;
            switch(option){
                case 1:
                    System.out.println("Enter the element to be pushed\n");
                    int val = sc.nextInt();
                    stk.push(val);
                    break;
                case 2:
                    System.out.println("Popped element : "+stk.pop());
                    break;
                case 3:
                    System.out.println("Peek element : "+stk.peek());
                    break;
                default:
                    exit = true;
                    break;
            }
            if(exit){
                break;
            }
        }
        sc.close();
    }
}
